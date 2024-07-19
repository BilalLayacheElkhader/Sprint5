package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.repository.game;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t02.model.domain.game.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    List<Game> findByIdPlayer(long idPlayer);
    void deleteByIdPlayer(long idPlayer);
    long countByIdPlayer(long idPlayer);
    long countByIdPlayerAndWinTrue(long idPlayer);
}
