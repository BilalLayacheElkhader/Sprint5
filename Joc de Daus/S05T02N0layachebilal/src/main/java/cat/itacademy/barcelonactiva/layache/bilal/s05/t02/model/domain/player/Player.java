package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.User.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String name;
    private String mail;
    private String password;
    Role role;

    public Player(String name) {

        this.name =(name == null || name.isEmpty()) ? "Anonymous" : name;
        this.date = LocalDate.now();
    }
    /*public void setName(String name) {
        this.name = (name == null || name.isEmpty()) ? "Anonymous" : name;
    }*/
}
