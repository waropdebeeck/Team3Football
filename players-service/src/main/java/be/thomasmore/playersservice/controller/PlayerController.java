package be.thomasmore.playersservice.controller;

import be.thomasmore.playersservice.entity.Player;
import be.thomasmore.playersservice.repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Player> getAllPlayers(){
        return repository.findAll();
    }

    @GetMapping("/getPlayerByAge/{age}")
    public List<Player> getPlayerByAge(@PathVariable("age") int age){
        return repository.findPlayersByAge(age);
    }

    @GetMapping("/getPlayerByNumber/{number}")
    public List<Player> getPlayerByNumber(@PathVariable("number") int number){
        return repository.findPlayersByNumber(number);
    }
}