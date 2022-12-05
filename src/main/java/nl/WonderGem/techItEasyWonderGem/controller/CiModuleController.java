package nl.WonderGem.techItEasyWonderGem.controller;

import nl.WonderGem.techItEasyWonderGem.dto.CiModuleInputDto;
import nl.WonderGem.techItEasyWonderGem.service.CiModuleService;
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
@RequestMapping("/ciModules")
public class CiModuleController {

    private final CiModuleService service;

    public CiModuleController(CiModuleService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllCiModules() {
        return ResponseEntity.ok(service.getAllCiModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCiModule(@PathVariable int id) {
        return ResponseEntity.ok(service.getCiModuleByID(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> createCiModule(@Valid @RequestBody CiModuleInputDto telInputDto, BindingResult br) {

        if (br.hasErrors()) {
            String erroMessage = Utility.badRequestMessageGenerator(br);
            return new ResponseEntity<>(erroMessage, HttpStatus.BAD_REQUEST);
        } else {
            Long createdID = service.createCiModule(telInputDto);
            URI uri = Utility.uriGenerator("/ciModules/", createdID);
            return ResponseEntity.created(uri).body("CiModule created");
        }


    }

    // Function to receive a array of CiModuleDto objects. It works, but I do not know if this is the way to do it. How would a batch operation normally work? Just do a lot of post request from the clienţ side?
    // I lost the @valid function. It does not check for mistakes. And I did not know how to return a list of Uri. The solution below will give back the right HTTP status update, but I am not sure if the arraylist is the right way to give back the URI's.

    @PostMapping("/multiple")
    public ResponseEntity<Object> createMultipeCiModules(@RequestBody CiModuleInputDto[] ciModuleListInputDto) {

        List<URI> uriList = new ArrayList<>();

        // Looping the list with DTO's to create the televisions in the database.
        for (CiModuleInputDto itemDto :
                ciModuleListInputDto) {
            Long createdID = service.createCiModule(itemDto);
            URI uri = Utility.uriGenerator("/ciModules/", createdID);
            uriList.add(uri);
        }
        return new ResponseEntity<>(uriList,HttpStatus.CREATED);

    }


    @PutMapping ("/{id}")
    public ResponseEntity<Object> updateCiModule(@PathVariable long id, @RequestBody CiModuleInputDto ciModuleInputDto){

        boolean succesfulUpdate = service.updateCiModule(id,ciModuleInputDto);

        if (succesfulUpdate) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCiModule(@PathVariable long id) {

        boolean ciModuleDeleted = service.deleteCiModule(id);

        if (!ciModuleDeleted) { //check if the deletions was successful. The repos checks if ID exists.
            return ResponseEntity.internalServerError().body(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}