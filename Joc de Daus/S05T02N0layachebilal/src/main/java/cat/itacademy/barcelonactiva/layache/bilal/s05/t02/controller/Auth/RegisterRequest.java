package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.controller.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    String mail;
    String password;
}
