package be.thomasmore.teamsservice.repository;

import be.thomasmore.teamsservice.entity.Team;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin
public interface TeamRepository extends MongoRepository<Team, Integer> {
    List<Team> findAll();
}
