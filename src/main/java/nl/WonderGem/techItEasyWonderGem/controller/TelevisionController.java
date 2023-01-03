package nl.WonderGem.techItEasyWonderGem.controller;


import nl.WonderGem.techItEasyWonderGem.dto.IdInputDto;
import nl.WonderGem.techItEasyWonderGem.dto.TelevisionInputDto;
import nl.WonderGem.techItEasyWonderGem.dto.TelevisionUpdateInputDto;
import nl.WonderGem.techItEasyWonderGem.service.TelevisionService;
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
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllTelevisions() {
        return ResponseEntity.ok(service.getAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTelevision(@PathVariable int id) {
        return ResponseEntity.ok(service.getTelevisionByID(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> createTelevision(@Valid @RequestBody TelevisionInputDto telInputDto, BindingResult br) {

        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            return new ResponseEntity<>(erroMessage, HttpStatus.BAD_REQUEST);
        } else {
            Long createdID = service.createTelevision(telInputDto);
            URI uri = Utility.uriGenerator("/televisions/", String.valueOf(createdID));
            return ResponseEntity.created(uri).body("Television created");
        }


    }

    // Function to receive a array of TelevisionDto objects. It works, but I do not know if this is the way to do it. How would a batch operation normally work? Just do a lot of post request from the clienţ side?
    // I lost the @valid function. It does not check for mistakes. And I did not know how to return a list of Uri. The solution below will give back the right HTTP status update, but I am not sure if the arraylist is the right way to give back the URI's.

    @PostMapping("/multiple")
    public ResponseEntity<Object> createMultipeTelevisions(@RequestBody TelevisionInputDto[] listTelInputDto) {

        List<URI> uriList = new ArrayList<>();

        // Looping the list with DTO's to create the televisions in the database.
        for (TelevisionInputDto telDto :
                listTelInputDto) {
            Long createdID = service.createTelevision(telDto);
            URI uri = Utility.uriGenerator("/televisions/", String.valueOf(createdID));
            uriList.add(uri);
        }
        return new ResponseEntity<>(uriList,HttpStatus.CREATED);

    }


    @PutMapping ("/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable long id, @RequestBody TelevisionUpdateInputDto telUpdateInputDto,BindingResult br){
        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            return new ResponseEntity<>(erroMessage, HttpStatus.BAD_REQUEST);
        } else {
            boolean succesfulUpdate = service.updateTelevision(id,telUpdateInputDto);

            if (succesfulUpdate) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable long id) {

        boolean televisionDeleted = service.deleteTelevision(id);

        if (!televisionDeleted) { //check if the deletions was successful. The repos checks if ID exists.
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @PutMapping ("/{id}/remotecontroller")
    public ResponseEntity<Object> adRemoteControllerToTelevision(@PathVariable long id, @RequestBody IdInputDto idInputDto,BindingResult br){
        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            return new ResponseEntity<>(erroMessage, HttpStatus.BAD_REQUEST);
        } else {
            boolean succesfulUpdate = service.assignRemoteControllerToTelevision(id, idInputDto.id);

            if (succesfulUpdate) {
                return ResponseEntity.ok("Remote controller added to telivision");
            } else {
                return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PutMapping ("/{id}/cimodule")
    public ResponseEntity<Object> adCiModuleToTelevision(@PathVariable long id, @RequestBody IdInputDto idInputDto,BindingResult br){
        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            return new ResponseEntity<>(erroMessage, HttpStatus.BAD_REQUEST);
        } else {
            boolean succesfulUpdate = service.assignCiModuleToTelevision(id, idInputDto.id);

            if (succesfulUpdate) {
                return ResponseEntity.ok("CI module added to telivision");
            } else {
                return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @PutMapping ("/{id}/wallbracket")
    public ResponseEntity<Object> adWallBracketToTelevision(@PathVariable long id, @RequestBody IdInputDto idInputDto,BindingResult br){
        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            return new ResponseEntity<>(erroMessage, HttpStatus.BAD_REQUEST);
        } else {
            boolean succesfulUpdate = service.assignWallBracketToTelevision(id, idInputDto.id);

            if (succesfulUpdate) {
                return ResponseEntity.ok("Wall bracket added to television");
            } else {
                return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}

//todo add control if objecdt is already added to television
