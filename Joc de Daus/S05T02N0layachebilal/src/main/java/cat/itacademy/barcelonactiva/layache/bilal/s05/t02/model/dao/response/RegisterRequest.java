package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.response;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="player", uniqueConstraints ={@UniqueConstraint(columnNames = {"email"})} )
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
