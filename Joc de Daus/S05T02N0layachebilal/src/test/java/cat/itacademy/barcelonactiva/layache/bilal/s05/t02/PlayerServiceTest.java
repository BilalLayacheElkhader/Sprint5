package cat.itacademy.barcelonactiva.layache.bilal.s05.t02;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerServiceTest {

    @Test
    public void testNameAndEmail() {
        String expectedName = "Nombre";
        String expectedEmail = "@correo";

        Player player = new Player();
        player.setName(expectedName);
        player.setEmail(expectedEmail);

        assertThat(player.getName()).isEqualTo(expectedName);
        assertThat(player.getEmail()).isEqualTo(expectedEmail);
    }
}
