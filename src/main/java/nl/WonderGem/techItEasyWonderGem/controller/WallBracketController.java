package nl.WonderGem.techItEasyWonderGem.controller;


import nl.WonderGem.techItEasyWonderGem.dto.WallBracketInputDto;
import nl.WonderGem.techItEasyWonderGem.service.WallBracketService;
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
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllWallBrackets() {
        return ResponseEntity.ok(service.getAllWallBrackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneWallBracket(@PathVariable int id) {
        return ResponseEntity.ok(service.getWallBracketByID(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> createWallBracket(@Valid @RequestBody WallBracketInputDto telInputDto, BindingResult br) {

        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            return new ResponseEntity<>(erroMessage, HttpStatus.BAD_REQUEST);
        } else {
            Long createdID = service.createWallBracket(telInputDto);
            URI uri = Utility.uriGenerator("/wallbrackets/", createdID);
            return ResponseEntity.created(uri).body("WallBracket created");
        }


    }

    // Function to receive a array of WallBracketDto objects. It works, but I do not know if this is the way to do it. How would a batch operation normally work? Just do a lot of post request from the clienţ side?
    // I lost the @valid function. It does not check for mistakes. And I did not know how to return a list of Uri. The solution below will give back the right HTTP status update, but I am not sure if the arraylist is the right way to give back the URI's.

    @PostMapping("/multiple")
    public ResponseEntity<Object> createMultipeWallBrackets(@RequestBody WallBracketInputDto[] wallBracketListInputDto) {

        List<URI> uriList = new ArrayList<>();

        // Looping the list with DTO's to create the televisions in the database.
        for (WallBracketInputDto itemDto :
                wallBracketListInputDto) {
            Long createdID = service.createWallBracket(itemDto);
            URI uri = Utility.uriGenerator("/wallbrackets/", createdID);
            uriList.add(uri);
        }
        return new ResponseEntity<>(uriList,HttpStatus.CREATED);

    }


    @PutMapping ("/{id}")
    public ResponseEntity<Object> updateWallBracket(@PathVariable long id, @RequestBody WallBracketInputDto wallBracketInputDto){

        boolean succesfulUpdate = service.updateWallBracket(id,wallBracketInputDto);

        if (succesfulUpdate) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable long id) {

        boolean wallBracketDeleted = service.deleteWallBracket(id);

        if (!wallBracketDeleted) { //check if the deletions was successful. The repos checks if ID exists.
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}