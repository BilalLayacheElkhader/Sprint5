package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;

import java.util.List;

public interface GameService {
    GameDTO newGame(long idPlayer);
    List<GameDTO> getAllGames(long idPlayer);
    void deleteAllGames(long id);

    List<PlayerDTO> getPlayersWithLowestWinRate();
    List<PlayerDTO> getPlayersWithHighestWinRate();
    double getAverageWinRate();


}
