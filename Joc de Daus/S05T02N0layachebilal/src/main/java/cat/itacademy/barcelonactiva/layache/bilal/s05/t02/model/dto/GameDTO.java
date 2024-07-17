package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class GameDTO implements Serializable {
    private String id;
    private int die1;
    private int die2;
    private boolean win;
    private long idPlayer;

    public GameDTO(long idPlayer){
        this.idPlayer = idPlayer;
    }
    public GameDTO(long idPlayer, int die1, int die2, boolean win) {
        this.idPlayer = idPlayer;
        this.die1 = die1;
        this.die2 = die2;
        this.win =  win;
    }
}
