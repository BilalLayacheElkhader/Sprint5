package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.impl;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.NameAlreadyExistException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerIdNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.game.Game;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.game.GameRepository;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player.PlayerRepository;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

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
    public void deleteAllGames(long idPlayer) {
        if (!playerRepository.existsById(idPlayer)) {
            throw new PlayerIdNotFoundException(STR."Player Not Found with ID:\{idPlayer}");
        }
        gameRepository.deleteByIdPlayer(idPlayer);
    }

    @Override
    public List<GameDTO> getAllGames(long idPlayer) {
        if (!playerRepository.existsById(idPlayer)) {
            throw new PlayerIdNotFoundException(String.format("Player Not Found with ID: %d", idPlayer));
        }
        return gameRepository.findByIdPlayer(idPlayer).stream()
                .map(game -> new GameDTO(game.getId(), game.getDie1(), game.getDie2(), game.isWin(), game.getIdPlayer()))
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageWinRate() {
        List<Game> allGames = gameRepository.findAll();
        OptionalDouble averageWinRate = allGames.stream()
                .mapToDouble(game -> game.isWin() ? 1.0 : 0.0)
                .average();
        return averageWinRate.orElse(0.0) * 100;
    }
}