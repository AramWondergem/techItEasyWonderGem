package nl.WonderGem.techItEasyWonderGem.Controllers;

import nl.WonderGem.techItEasyWonderGem.Exceptions.RecordNotFoundException;
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
       if ( id < 0) {
           throw new RecordNotFoundException("ID cannot be found");
       }
        return ResponseEntity.noContent().build();
   }

   @DeleteMapping("televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.noContent().build();
   }


}
