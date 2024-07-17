package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.impl;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.NameAlreadyExistException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerIdNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.game.Game;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.game.GameRepository;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player.PlayerRepository;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameRepository gameRepository;
    @Override
    public GameDTO newGame(long idPlayer) {
        if (!playerRepository.existsById(idPlayer)) {
            throw new PlayerIdNotFoundException(STR."Player Not Found with ID:\{idPlayer}");
        }
        Game game = new Game(idPlayer);
        gameRepository.save(game);
        return new GameDTO(game.getIdPlayer(),game.getDie1(),game.getDie2(), game.isWin());
    }

    @Override
    public List<GameDTO> getAllGames(long idPlayer) {
        if (!playerRepository.existsById(idPlayer)) {
            throw new PlayerIdNotFoundException(STR."Player Not Found with ID:\{idPlayer}");
        }
        return gameRepository.findByIdPlayer(idPlayer).stream()
                .map(game ->{
                   GameDTO gameDTO =  new GameDTO(game.getIdPlayer(), game.getDie1(), game.getDie2(), game.isWin());
                    gameDTO.setId(game.getId());
                    return gameDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllGames(long id) {
        if (!playerRepository.existsById(id)) {
            throw new PlayerIdNotFoundException(STR."Player Not Found with ID:\{id}");
        }
        gameRepository.deleteByIdPlayer(id);
    }

    @Override
    public double getAverageWinRate() {
        List<Game> games = gameRepository.findAll();
        double winRate = games.stream()
                .mapToDouble(game -> game.isWin() ? 1 : 0)
                .average()
                .orElse(0.0);
        return winRate * 100;
    }


}
