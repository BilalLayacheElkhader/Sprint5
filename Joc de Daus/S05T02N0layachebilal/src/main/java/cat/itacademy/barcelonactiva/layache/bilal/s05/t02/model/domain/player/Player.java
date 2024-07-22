package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player;


import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.Role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="player", uniqueConstraints ={@UniqueConstraint(columnNames = {"email"})} )
public class Player implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    public Player(String name) {

        this.name =(name == null || name.isEmpty()) ? "Anonymous" : name;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    /*public void setName(String name) {
        this.name = (name == null || name.isEmpty()) ? "Anonymous" : name;
    }*/
}
