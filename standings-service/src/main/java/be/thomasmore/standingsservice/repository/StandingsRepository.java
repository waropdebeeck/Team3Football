package be.thomasmore.standingsservice.repository;

import be.thomasmore.standingsservice.entity.Standings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface StandingsRepository extends JpaRepository<Standings, Integer> {
    Standings findStandingByLeague(@Param("league_id") int league_id);
}
