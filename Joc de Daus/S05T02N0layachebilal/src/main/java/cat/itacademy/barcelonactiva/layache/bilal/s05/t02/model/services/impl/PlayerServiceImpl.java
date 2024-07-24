package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.impl;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerIdNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.game.Game;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.game.GameRepository;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.PlayerService;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.NameAlreadyExistException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    @Override
    public void update(PlayerDTO playerDTO) {

        Player existingPlayer = playerRepository.findById(playerDTO.getId())
                .orElseThrow(() -> new PlayerNotFoundException("Player Not Found with ID: " + playerDTO.getId()));
        if (playerDTO.getName() == null || playerDTO.getName().isBlank()) {
            playerDTO.setName("Anonymous");
        }
        if (!"Anonymous".equals(playerDTO.getName())) {
            playerRepository.findByName(playerDTO.getName())
                    .ifPresent(pl -> {
                        throw new NameAlreadyExistException(STR."Name \{pl.getName()} not avaible.");
                    });
        }
        existingPlayer.setName(playerDTO.getName());
        playerRepository.save(existingPlayer);
    }



    @Override
    public List<PlayerDTO> getAll() {
        List<Player> players = playerRepository.findAll();
        List<PlayerDTO> playerDTOs = new ArrayList<>();

        for (Player player : players) {
            double winRate = calculateWinRate(player);
            PlayerDTO playerDTO = new PlayerDTO(player, winRate);
            playerDTOs.add(playerDTO);
        }

        return playerDTOs;
    }

    @Override
    public PlayerDTO getById(long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        double winRate = calculateWinRate(player);
        return new PlayerDTO(player, winRate);
    }

    @Override
    public List<PlayerDTO> getPlayersWithLowestWinRate() {
        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) return Collections.emptyList();
        double minWinRate = players.stream()
                .mapToDouble(this::calculateWinRate)
                .min()
                .orElse(0.0);
        return players.stream()
                .filter(player -> calculateWinRate(player) == minWinRate)
                .map(player -> new PlayerDTO(player, calculateWinRate(player)))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerDTO> getPlayersWithHighestWinRate() {
        List<Player> players = playerRepository.findAll();
        if (players.isEmpty()) return Collections.emptyList();
        double maxWinRate = players.stream()
                .mapToDouble(this::calculateWinRate)
                .max()
                .orElse(0.0);
        return players.stream()
                .filter(player -> calculateWinRate(player) == maxWinRate)
                .map(player -> new PlayerDTO(player, calculateWinRate(player)))
                .collect(Collectors.toList());
    }

    private double calculateWinRate(Player player) {
        long totalGames = gameRepository.countByIdPlayer(player.getId());
        long wins = gameRepository.countByIdPlayerAndWinTrue(player.getId());
        return totalGames == 0 ? 0.0 : (double) wins / totalGames * 100;
    }
}