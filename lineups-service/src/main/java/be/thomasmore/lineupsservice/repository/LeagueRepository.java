package be.thomasmore.leagueinfoservice.repository;

import be.thomasmore.leagueinfoservice.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface LeagueRepository extends JpaRepository<League, Integer> {
    League findLeagueByName(@Param("name") String name);
}
