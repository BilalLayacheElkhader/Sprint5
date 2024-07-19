package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.controller.Auth.AuthResponse;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.controller.Auth.LoginRequest;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.controller.Auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        return null;
    }
}
