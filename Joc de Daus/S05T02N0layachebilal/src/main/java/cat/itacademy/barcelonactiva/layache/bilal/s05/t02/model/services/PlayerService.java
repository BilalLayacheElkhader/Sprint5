package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
        void add(PlayerDTO playerDTO);

        void delete(long id);

        void update(PlayerDTO playerDTO);

        List<PlayerDTO> getAll();

        PlayerDTO getById(long id);

        double getAverageWinRate();
        List<PlayerDTO> getPlayersWithLowestWinRate();
        List<PlayerDTO> getPlayersWithHighestWinRate();
}


