package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String name;
    public Player() {
    }

    public Player(String name) {

        this.name = name;
        this.date = LocalDate.now();
    }
}
