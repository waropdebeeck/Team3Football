package be.thomasmore.teamsservice.repository;

import be.thomasmore.teamsservice.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin
public interface TeamRepository extends JpaRepository<Team, Integer>{
    List<Team> findAll();
}
