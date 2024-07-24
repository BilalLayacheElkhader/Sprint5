package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.impl;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.exceptions.PlayerIdNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.game.Game;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.game.GameRepository;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {

    @Mock
    private GameRepository gameRepository;

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private GameServiceImpl gameService;

    private Player player;
    private Game game;

    @BeforeEach
    void setUp() {
        player = new Player();
        player.setId(1L);
        player.setName("Test Player");

        game = new Game(1L);
        game.setId("kydladnslad");
        game.setWin(true);
    }

    @Test
    void testNewGame() {
        when(playerRepository.existsById(anyLong())).thenReturn(true);
        when(gameRepository.save(any(Game.class))).thenReturn(game);

        GameDTO gameDTO = gameService.newGame(1L);

        assertNotNull(gameDTO);
        assertEquals(1L, gameDTO.getIdPlayer());
        verify(gameRepository).save(any(Game.class));
    }

    @Test
    void testNewGame_PlayerNotFound() {
        when(playerRepository.existsById(anyLong())).thenReturn(false);

        assertThrows(PlayerIdNotFoundException.class, () -> gameService.newGame(1L));
    }

    @Test
    void testDeleteAllGames() {
        when(playerRepository.existsById(anyLong())).thenReturn(true);

        gameService.deleteAllGames(1L);

        verify(gameRepository).deleteByIdPlayer(1L);
    }

    @Test
    void testDeleteAllGames_PlayerNotFound() {
        when(playerRepository.existsById(anyLong())).thenReturn(false);

        assertThrows(PlayerIdNotFoundException.class, () -> gameService.deleteAllGames(1L));
    }

}