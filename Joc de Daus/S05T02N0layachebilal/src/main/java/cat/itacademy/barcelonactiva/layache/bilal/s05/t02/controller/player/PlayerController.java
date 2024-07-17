package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.controller.player;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/add")
    public ResponseEntity<String> createPlayer(@RequestBody PlayerDTO playerDTO){
        playerService.add(playerDTO);
        return ResponseEntity.ok("Added");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        playerService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody PlayerDTO playerDTO){
        playerService.update(playerDTO);
        return ResponseEntity.ok("Updated");
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<PlayerDTO>> getAll(){
        List<PlayerDTO> playerDTOS = playerService.getAll();
        return ResponseEntity.ok(playerDTOS);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<PlayerDTO> getById(@PathVariable int id){
        PlayerDTO playerDTO = playerService.getById(id);
        return ResponseEntity.ok(playerDTO);
    }
}
