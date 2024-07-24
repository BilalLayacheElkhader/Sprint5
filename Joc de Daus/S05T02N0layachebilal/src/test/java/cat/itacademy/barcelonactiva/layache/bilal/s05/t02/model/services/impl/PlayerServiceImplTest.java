package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.impl;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.NameAlreadyExistException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.game.GameRepository;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    private Player player;
    private PlayerDTO playerDTO;

    @BeforeEach
    void setUp() {
        player = new Player();
        player.setId(1);
        player.setName("Test Player");

        playerDTO = new PlayerDTO();
        playerDTO.setId(1);
        playerDTO.setName("Test Player");
    }

    @Test
    void testUpdatePlayer() {
        when(playerRepository.findById(anyLong())).thenReturn(Optional.of(player));
        when(playerRepository.findByName(anyString())).thenReturn(Optional.empty());

        playerService.update(playerDTO);

        verify(playerRepository).save(player);
    }

    @Test
    void testUpdatePlayer_NotFound() {
        when(playerRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(PlayerNotFoundException.class, () -> playerService.update(playerDTO));
    }

    @Test
    void testUpdatePlayer_NameAlreadyExists() {
        when(playerRepository.findById(anyLong())).thenReturn(Optional.of(player));
        when(playerRepository.findByName(anyString())).thenReturn(Optional.of(new Player()));

        assertThrows(NameAlreadyExistException.class, () -> playerService.update(playerDTO));
    }

    @Test
    void testGetAllPlayers() {
        when(playerRepository.findAll()).thenReturn(Collections.singletonList(player));
        when(gameRepository.countByIdPlayer(anyLong())).thenReturn(10L);
        when(gameRepository.countByIdPlayerAndWinTrue(anyLong())).thenReturn(5L);

        List<PlayerDTO> players = playerService.getAll();

        assertEquals(1, players.size());
        assertEquals(50.0, players.get(0).getWinRatio());
    }

    @Test
    void testGetPlayerById() {
        when(playerRepository.findById(anyLong())).thenReturn(Optional.of(player));
        when(gameRepository.countByIdPlayer(anyLong())).thenReturn(10L);
        when(gameRepository.countByIdPlayerAndWinTrue(anyLong())).thenReturn(5L);

        PlayerDTO playerDTO = playerService.getById(1L);

        assertEquals(50.0, playerDTO.getWinRatio());
    }

    @Test
    void testGetPlayerById_NotFound() {
        when(playerRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> playerService.getById(1L));
    }

    @Test
    void testGetPlayersWithLowestWinRate() {
        when(playerRepository.findAll()).thenReturn(Collections.singletonList(player));
        when(gameRepository.countByIdPlayer(anyLong())).thenReturn(10L);
        when(gameRepository.countByIdPlayerAndWinTrue(anyLong())).thenReturn(5L);

        List<PlayerDTO> players = playerService.getPlayersWithLowestWinRate();

        assertEquals(1, players.size());
        assertEquals(50.0, players.get(0).getWinRatio());
    }

    @Test
    void testGetPlayersWithHighestWinRate() {
        when(playerRepository.findAll()).thenReturn(Collections.singletonList(player));
        when(gameRepository.countByIdPlayer(anyLong())).thenReturn(10L);
        when(gameRepository.countByIdPlayerAndWinTrue(anyLong())).thenReturn(5L);

        List<PlayerDTO> players = playerService.getPlayersWithHighestWinRate();

        assertEquals(1, players.size());
        assertEquals(50.0, players.get(0).getWinRatio());
    }
}
