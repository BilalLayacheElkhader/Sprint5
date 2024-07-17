package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PlayerDTO {
    private long id;
    private LocalDate date;
    private String name;
    private double winRatio;

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.date = player.getDate();
    }

    public PlayerDTO(Player player, double winRatio) {
        this.id = player.getId();
        this.name = player.getName();
        this.winRatio = winRatio;

    }
}
