package be.thomasmore.lineupsservice.controller;

import be.thomasmore.lineupsservice.entity.Lineup;
import be.thomasmore.lineupsservice.repository.LineupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Line;
import java.util.List;

    @RestController
    @RequestMapping("/lineups")
    public class LineupController {
        @Autowired
        private LineupRepository repository;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public List<Lineup> getAllLineupss() {
            return repository.findAll();
        }



        @GetMapping("/getLineupByPlayer/{player}")
        public List<Lineup> getLineupsByPlayer(@PathVariable("player") String player) {
            return repository.findLineupByPlayerContainingIgnoreCase(player);
        }

        @GetMapping("/getLineupsByNumber/{number}")
        public List<Lineup> getLineupsByNumber(@PathVariable("number") int number) {
            return repository.findLineupsByNumber(number);
        }

        @GetMapping("/findTracksByPos/{pos}")
        public List<Lineup> getLineupsByPos(@PathVariable("pos") String pos) {
            return repository.findLineupByPosContainingIgnoreCase(pos);
        }
    }

