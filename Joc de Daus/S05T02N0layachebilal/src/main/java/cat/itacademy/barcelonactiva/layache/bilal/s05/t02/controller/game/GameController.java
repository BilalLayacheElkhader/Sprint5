package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.controller.game;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.GameService;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class GameController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @PostMapping("/{idPlayer}/games")
    public ResponseEntity<GameDTO> newGame(@PathVariable long idPlayer) {
        GameDTO gameDTO = gameService.newGame(idPlayer);
        return ResponseEntity.ok(gameDTO);
    }

    @GetMapping("/{idPlayer}/getAllGames")
    public ResponseEntity<List<GameDTO>> getAllGames(@PathVariable long idPlayer) {
        List<GameDTO> games = gameService.getAllGames(idPlayer);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/ranking")
    public ResponseEntity<String> getAverageWinRate() {
        double averageWinRate = gameService.getAverageWinRate();
        return ResponseEntity.ok("AVERAGE WIN RATE: " + averageWinRate + "%");
    }

    @DeleteMapping("/{idPlayer}/deleteAllGames")
    public ResponseEntity<String> deleteAllGames(@PathVariable long idPlayer) {
        gameService.deleteAllGames(idPlayer);
        PlayerDTO playerDTO = playerService.getById(idPlayer);
        return ResponseEntity.ok("ALL DELETED");
    }
}
