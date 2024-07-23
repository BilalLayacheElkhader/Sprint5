package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.controller.player;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @PutMapping
    public ResponseEntity<String> updatePlayer(@RequestBody PlayerDTO playerDTO) {
        playerService.update(playerDTO);
        return ResponseEntity.ok("PLAYER UPDATED");
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> players = playerService.getAll();
        return ResponseEntity.ok(players);
    }
    @GetMapping("/ranking/loser")
    public ResponseEntity<List<PlayerDTO>> getPlayersWithLowestWinRate() {
        List<PlayerDTO> playersWithLowestWinRate = playerService.getPlayersWithLowestWinRate();
        return ResponseEntity.ok(playersWithLowestWinRate);
    }

    @GetMapping("/ranking/winner")
    public ResponseEntity<List<PlayerDTO>> getPlayersWithHighestWinRate() {
        List<PlayerDTO> playersWithHighestWinRate = playerService.getPlayersWithHighestWinRate();
        return ResponseEntity.ok(playersWithHighestWinRate);
    }
}
