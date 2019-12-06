package be.thomasmore.playersservice.repository;

import be.thomasmore.playersservice.entity.Player;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin
public interface PlayerRepository extends MongoRepository<Player, Integer> {
    List<Player> findAll();
    Player findPlayerById(@Param("Id")String Id);
}
