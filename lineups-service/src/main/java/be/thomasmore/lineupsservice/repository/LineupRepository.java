package be.thomasmore.lineupsservice.repository;

import be.thomasmore.lineupsservice.entity.Lineup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface LineupRepository extends JpaRepository<Lineup, Integer> {
    Lineup findLineupByName(@Param("name") String name);
}
