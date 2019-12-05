package be.thomasmore.lineupsservice.repository;

import be.thomasmore.lineupsservice.entity.Lineup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin
public interface LineupRepository extends JpaRepository<Lineup, Integer> {
    List<Lineup> findAll();

    List<Lineup> findLineupByPlayerContainingIgnoreCase(String player);

    List<Lineup>  findLineupsByNumber(@Param("number") int number);

    List<Lineup> findLineupByPosContainingIgnoreCase(String pos);
}
