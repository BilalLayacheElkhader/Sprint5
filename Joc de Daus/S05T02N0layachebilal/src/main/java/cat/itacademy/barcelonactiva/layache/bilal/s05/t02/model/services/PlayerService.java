package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    void add(PlayerDTO playerDTO);
    void update(PlayerDTO playerDTO);
    void delete(long id);
    PlayerDTO getById(long id);
    List<PlayerDTO> getAll();
}
