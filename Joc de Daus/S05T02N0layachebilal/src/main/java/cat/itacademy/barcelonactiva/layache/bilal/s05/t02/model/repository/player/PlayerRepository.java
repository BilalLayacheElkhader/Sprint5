package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.player;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    Optional<Player> findByName(String nickname);

    boolean existsByName(String name);
}
