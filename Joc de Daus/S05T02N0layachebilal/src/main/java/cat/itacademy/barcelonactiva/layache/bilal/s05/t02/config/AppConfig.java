package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.config;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final PlayerRepository playerRepository;
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> playerRepository.findPlayerByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("USER NOT FOUND"));
    }
}
