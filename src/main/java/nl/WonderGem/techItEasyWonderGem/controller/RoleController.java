package nl.WonderGem.techItEasyWonderGem.controller;

import nl.WonderGem.techItEasyWonderGem.dto.RoleDto;
import nl.WonderGem.techItEasyWonderGem.exception.BadRequestException;
import nl.WonderGem.techItEasyWonderGem.service.RoleService;
import nl.WonderGem.techItEasyWonderGem.utility.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }


    @PostMapping("")
    public ResponseEntity<Object> createRole(@Valid @RequestBody RoleDto role, BindingResult br) {

        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            throw new BadRequestException(erroMessage);
        } else {
            String createdID = service.createRole(role);
            URI uri = Utility.uriGenerator("/roles/", createdID);
            return ResponseEntity.created(uri).body("Role created");
        }
    }



    @GetMapping("")
    public ResponseEntity<Object> getAllRoles() {
        return ResponseEntity.ok(service.getAllRoles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole (@PathVariable String id) {
        service.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
