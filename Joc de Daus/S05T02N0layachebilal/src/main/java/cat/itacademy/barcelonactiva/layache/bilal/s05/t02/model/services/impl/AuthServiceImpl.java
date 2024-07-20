package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.impl;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.AuthResponse;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.request.AuthenticationRequest;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.dao.response.RegisterRequest;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.Role.Role;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player.PlayerRepository;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse register(RegisterRequest request) {
        var player = Player.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        playerRepository.save(player);
        var jwtToken =jwtService.generateToken(player);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    var player = playerRepository.findPlayerByEmail(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(player);
    return AuthResponse.builder().token(jwtToken).build();
    }
}
