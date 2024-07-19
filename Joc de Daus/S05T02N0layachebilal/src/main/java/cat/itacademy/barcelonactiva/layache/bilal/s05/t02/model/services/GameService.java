package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;

import java.util.List;

public interface GameService {
    GameDTO newGame(long idPlayer);

    void deleteAllGames(long idPlayer);

    List<GameDTO> getAllGames(long idPlayer);

    double getAverageWinRate();

    List<PlayerDTO> getPlayersWithLowestWinRate();

    List<PlayerDTO> getPlayersWithHighestWinRate();
}