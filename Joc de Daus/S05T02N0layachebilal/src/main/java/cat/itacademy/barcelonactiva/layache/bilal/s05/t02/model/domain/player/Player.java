package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String name;
    private String mail;
    private String password;
    //Role role;

    public Player(String name) {

        this.name =(name == null || name.isEmpty()) ? "Anonymous" : name;
        this.date = LocalDate.now();
    }
    /*public void setName(String name) {
        this.name = (name == null || name.isEmpty()) ? "Anonymous" : name;
    }*/
}
