package be.thomasmore.teamsservice.controller;

import be.thomasmore.teamsservice.entity.Team;
import be.thomasmore.teamsservice.repository.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamRepository repository;

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Team> getAllTeams(){
        return repository.findAll();
    }
}
