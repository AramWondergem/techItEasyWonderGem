package nl.WonderGem.techItEasyWonderGem.controller;

import nl.WonderGem.techItEasyWonderGem.dto.UserInputDto;
import nl.WonderGem.techItEasyWonderGem.exception.BadRequestException;
import nl.WonderGem.techItEasyWonderGem.service.UserService;
import nl.WonderGem.techItEasyWonderGem.utility.Utility;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // get all users
    @PostMapping("")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserInputDto userInputDto, BindingResult br) {

        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            throw new BadRequestException(erroMessage);
        } else {
            String createdID = service.saveUser(userInputDto);
            URI uri = Utility.uriGenerator("/users/", createdID);
            return ResponseEntity.created(uri).body("User created");
        }
    }
    // get one user
    @GetMapping ("/{username}")
    public ResponseEntity<Object> getUser(@PathVariable String username) {
        return ResponseEntity.ok(service.getUser(username));
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PutMapping("/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable String username, @Valid UserInputDto userInputDto, BindingResult br) {
        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            throw new BadRequestException(erroMessage);
        } else {
            service.updateUser(username, userInputDto);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/username}")
    public ResponseEntity<Object> deleteRole (@PathVariable String username) {
        service.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

}
