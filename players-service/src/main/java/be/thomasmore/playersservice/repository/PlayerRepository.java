package be.thomasmore.playersservice.repository;

import be.thomasmore.playersservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin
public interface PlayerRepository extends JpaRepository<Player, Integer>{
    List<Player> findAll();

    List<Player> findPlayersByAge(int age);

    List<Player> findPlayersByNumber(@Param("number") int number);
}