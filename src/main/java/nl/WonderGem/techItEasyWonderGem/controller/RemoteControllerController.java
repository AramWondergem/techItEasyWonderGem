package nl.WonderGem.techItEasyWonderGem.controller;

import nl.WonderGem.techItEasyWonderGem.dto.RemoteControllerInputDto;
import nl.WonderGem.techItEasyWonderGem.service.RemoteControllerService;
import nl.WonderGem.techItEasyWonderGem.utility.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {

    private final RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllRemoteControllers() {
        return ResponseEntity.ok(service.getAllRemoteControllers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneRemoteController(@PathVariable int id) {
        return ResponseEntity.ok(service.getRemoteControllerByID(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> createRemoteController(@Valid @RequestBody RemoteControllerInputDto telInputDto, BindingResult br) {

        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            return new ResponseEntity<>(erroMessage, HttpStatus.BAD_REQUEST);
        } else {
            Long createdID = service.createRemoteController(telInputDto);
            URI uri = Utility.uriGenerator("/remotecontrollers/", createdID);
            return ResponseEntity.created(uri).body("RemoteController created");
        }


    }

    // Function to receive a array of RemoteControllerDto objects. It works, but I do not know if this is the way to do it. How would a batch operation normally work? Just do a lot of post request from the clienţ side?
    // I lost the @valid function. It does not check for mistakes. And I did not know how to return a list of Uri. The solution below will give back the right HTTP status update, but I am not sure if the arraylist is the right way to give back the URI's.

    @PostMapping("/multiple")
    public ResponseEntity<Object> createMultipeRemoteControllers(@RequestBody RemoteControllerInputDto[] remoteControllerListInputDto) {

        List<URI> uriList = new ArrayList<>();

        // Looping the list with DTO's to create the televisions in the database.
        for (RemoteControllerInputDto itemDto :
                remoteControllerListInputDto) {
            Long createdID = service.createRemoteController(itemDto);
            URI uri = Utility.uriGenerator("/remotecontrollers/", createdID);
            uriList.add(uri);
        }
        return new ResponseEntity<>(uriList,HttpStatus.CREATED);

    }


    @PutMapping ("/{id}")
    public ResponseEntity<Object> updateRemoteController(@PathVariable long id, @RequestBody RemoteControllerInputDto remoteControllerInputDto){

        boolean succesfulUpdate = service.updateRemoteController(id,remoteControllerInputDto);

        if (succesfulUpdate) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRemoteController(@PathVariable long id) {

        boolean remoteControllerDeleted = service.deleteRemoteController(id);

        if (!remoteControllerDeleted) { //check if the deletions was successful. The repos checks if ID exists.
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}