package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.impl;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerIdNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.PlayerService;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.NameAlreadyExistException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void add(PlayerDTO playerDTO) {
        Player player = new Player(playerDTO.getName());
        if (player.getName()== null || player.getName().isBlank()) {
            player.setName("Anonymous");
        }
        playerRepository.findByName(playerDTO.getName())
                .ifPresent(pl -> {
                    throw new NameAlreadyExistException(STR."Name \{pl.getName()} not avaible.");
                });
        playerRepository.save(player);

    }

    @Override
    public void update(PlayerDTO playerDTO) {
        Player existingPlayer = playerRepository.findById(playerDTO.getId())
                .orElseThrow(() -> new PlayerNotFoundException("Player Not Found with ID: " + playerDTO.getId()));
        existingPlayer.setName(playerDTO.getName());
        playerRepository.save(existingPlayer);
    }

    @Override
    public void delete(long id) {
        if (!playerRepository.existsById(id)) {
            throw new PlayerIdNotFoundException(STR."Player Not Found with ID:\{id}");
        }
        playerRepository.deleteById(id);

    }

    @Override
    public PlayerDTO getById(long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player Not Found with ID" + id));
        return new PlayerDTO(player);
    }

    @Override
    public List<PlayerDTO> getAll() {
        return playerRepository.findAll().stream().map(PlayerDTO::new).collect(Collectors.toList());
    }
}
