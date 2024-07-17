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
    public List<PlayerDTO> getPlayersWithLowestWinRate() {
        List<Player> players = playerRepository.findAll();

        double lowestWinRate = players.stream()
                .mapToDouble(this::calculateWinRate)
                .min()
                .orElseThrow(() -> new PlayerNotFoundException("NO PLAYERS FOUND"));

        return players.stream()
                .filter(player -> calculateWinRate(player) == lowestWinRate)
                .map(player -> new PlayerDTO(player, calculateWinRate(player)))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerDTO> getPlayersWithHighestWinRate() {
        List<Player> players = playerRepository.findAll();

        double highestWinRate = players.stream()
                .mapToDouble(this::calculateWinRate)
                .max()
                .orElseThrow(() -> new PlayerNotFoundException("NO PLAYERS FOUND"));

        return players.stream()
                .filter(player -> calculateWinRate(player) == highestWinRate)
                .map(player -> new PlayerDTO(player, calculateWinRate(player)))
                .collect(Collectors.toList());
    }

    private double calculateWinRate(Player player) {
        List<Game> games = gameRepository.findByIdPlayer(player.getId());
        long totalGames = games.size();
        long wins = games.stream().filter(Game::isWin).count();
        return totalGames > 0 ? (double) wins / totalGames : 0.0;
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
