package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.controller.Auth;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.AuthResponse;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.request.AuthenticationRequest;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.response.RegisterRequest;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));

    }
}
