package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.AuthResponse;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.request.AuthenticationRequest;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.response.RegisterRequest;

public interface AuthService {
    AuthResponse register (RegisterRequest request);
    AuthResponse authenticate(AuthenticationRequest request);
}
