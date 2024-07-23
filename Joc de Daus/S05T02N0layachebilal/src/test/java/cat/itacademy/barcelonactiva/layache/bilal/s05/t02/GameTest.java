package cat.itacademy.barcelonactiva.layache.bilal.s05.t02;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    @Test
    public void testGame() {

        int die1 = 3;
        int die2 = 4;

        Game game = new Game();
        game.setDie1(die1);
        game.setDie2(die2);

        assertTrue(game.getDie1() >= 1 && game.getDie1() <= 6, "Numeros permitidos entre 1 y 6");
        assertTrue(game.getDie2() >= 1 && game.getDie2() <= 6, "Numeros permitidos entre 1 y 6");
    }



}
