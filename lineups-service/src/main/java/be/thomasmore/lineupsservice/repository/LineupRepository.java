package be.thomasmore.lineupsservice.repository;

import be.thomasmore.lineupsservice.entity.Lineup;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sound.sampled.Line;
import java.util.List;

@CrossOrigin
public interface LineupRepository extends MongoRepository<Lineup, Integer> {
    Lineup findLineupById(@Param("id") String id);
    Lineup findLineupByUserId(@Param("userId") Integer userId);
}
