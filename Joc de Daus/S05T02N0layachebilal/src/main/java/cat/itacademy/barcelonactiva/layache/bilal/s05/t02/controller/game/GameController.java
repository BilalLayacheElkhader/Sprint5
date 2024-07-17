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
@RequestMapping("/game")
public class GameController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private GameService gameService;

    @PostMapping("/newGame/{idPlayer}")
    public ResponseEntity<String> newGame(@PathVariable long idPlayer) {
        GameDTO gameDTO = gameService.newGame(idPlayer);
        return ResponseEntity.ok("Game Played");
    }
    @GetMapping("/getAllGames/{idPlayer}")
    public ResponseEntity<List<GameDTO>> getAllGames(@PathVariable long idPlayer) {
        List<GameDTO> games = gameService.getAllGames(idPlayer);
        return ResponseEntity.ok(games);
    }
    @DeleteMapping("/deleteAllGames/{idPlayer}")
    public ResponseEntity<String> deleteAllGames(@PathVariable long idPlayer) {
        gameService.deleteAllGames(idPlayer);
        PlayerDTO playerDTO = playerService.getById(idPlayer);
        return ResponseEntity.ok("ALL DELETED");
    }
}
