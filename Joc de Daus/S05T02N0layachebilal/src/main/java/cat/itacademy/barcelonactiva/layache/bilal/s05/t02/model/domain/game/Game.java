package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.game;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Game {
    @Id
    private String id;
    private int die1;
    private int die2;
    private boolean win;
    private long idPlayer;
    private static final Random RANDOM = new Random();
    private static final int DIE_SIDES = 6;
    public Game(long idPlayer){
        this.idPlayer = idPlayer;
        this.die1 = rollDie();
        this.die2 = rollDie();
        this.win = (this.die1 + this.die2) == 7;
    }
    private int rollDie() {
        return RANDOM.nextInt(DIE_SIDES) + 1;
    }


}
