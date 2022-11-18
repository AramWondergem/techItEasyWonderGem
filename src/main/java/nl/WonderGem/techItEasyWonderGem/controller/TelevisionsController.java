package nl.WonderGem.techItEasyWonderGem.controller;

import nl.WonderGem.techItEasyWonderGem.exception.IndexOutOfBoundsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionsController {

    @GetMapping ("/televisions")
    public ResponseEntity<Object> getAllTelevisions(){
        return ResponseEntity.ok("all televisions");
    }

    @GetMapping ("/televisions/{id}")
    public ResponseEntity<Object> getOneTelevision(@PathVariable int id) {
        return ResponseEntity.ok("Television " + id);
    }

   @PostMapping ("/televisions")
   public ResponseEntity<Object> createTelevision(@RequestBody String television) {
        return ResponseEntity.created(null).body(television);
   }

   @PutMapping ("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television){
       if ( id < 0 ) {
           throw new IndexOutOfBoundsException("Use a positive number for the ID"); // todo waarschijnlijk naar service laag en aanpassen tekst
       }
        return ResponseEntity.noContent().build();
   }

   @DeleteMapping("televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.noContent().build();
   }


}
