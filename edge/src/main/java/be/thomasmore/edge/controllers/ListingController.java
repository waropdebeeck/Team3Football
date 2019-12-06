package be.thomasmore.edge.controllers;

import be.thomasmore.edge.models.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;



    @ApiOperation(value="Haal alle lineups op", response = Lineup.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lineups succesvol opgehaald"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Source not found")
    })
    @GetMapping("/lineups")
    public List<Lineup> getAllLineups() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://lineup-service/lineups", GenericResponseWrapper.class);

        List<Lineup> lineups = objectMapper.convertValue(wrapper.get_embedded().get("lineups"), new TypeReference<List<Lineup>>() { });

        return lineups;
    }

    @ApiOperation(value="Haal het lineups op Id", response = Lineup.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lineup werd succesvol opgehaald"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Source not found")
    })
    @GetMapping("/lineups/{id}")
    public Lineup getLineupByUserId(@ApiParam(value = "Het userId van Lineup", required = true)@PathVariable Integer id) {

        return restTemplate.getForObject("http:/lineup-service/lineups/search/findLineupByUserId?userId=" + id, Lineup.class);
    }

    @ApiOperation(value="Het lineup aanpassen gegeven id")
    @PutMapping("/updateLineup/{id}")
    public ResponseEntity<String> updateLineup(
            @ApiParam(value = "Het lineupId om het lineup te updaten", required = true)@PathVariable("id") String id,
            @ApiParam(value = "Lineup", required = true) @RequestBody Lineup lineup){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        restTemplate.put("http://lineup-service/lineups/" + id, lineup, Lineup.class);

        return ResponseEntity.ok().build();
    }
    @ApiOperation(value="Een lineup toevoegen")
    @PostMapping("/Createlineups/")
    public ResponseEntity<String> postLineup(@ApiParam(value = "Een nieu lineup object aanmaken ", required = true)@RequestBody Lineup lineup){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        ResponseEntity<Lineup> result = restTemplate.postForEntity(
                    "http://lineup-service/lineups/", lineup, Lineup.class
        );

        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Een player toevoegen")
    @PostMapping("/players")
    public ResponseEntity<String> postPlayer(@ApiParam(value = "Een nieuwe player object aanmaken ", required = true)@RequestBody Player player){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        ResponseEntity<Player> result = restTemplate.postForEntity(
                "http://players-service/players/", player, Player.class
        );

        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Verwijder het Lineup op Id")
    @DeleteMapping("/lineup/{id}")
    public ResponseEntity deleteLineupOnId(@ApiParam(value = "Het id van het verwijderde lineup", required = true)@PathVariable("id") Integer id){

        restTemplate.delete("http://lineup-service/lineups/" + id);
        return ResponseEntity.ok().build();
    }
    @ApiOperation(value="Haal alle teams op", response = Lineup.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Teams succesvol opgehaald"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Source not found")
    })
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://teams-service/teams", GenericResponseWrapper.class);

        List<Team> teams = objectMapper.convertValue(wrapper.get_embedded().get("teams"), new TypeReference<List<Team>>() { });

        return teams;
    }
    @ApiOperation(value="Haal alle players op", response = Lineup.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Players succesvol opgehaald"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "Source not found")
    })
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://players-service/teams", GenericResponseWrapper.class);

        List<Player> players = objectMapper.convertValue(wrapper.get_embedded().get("players"), new TypeReference<List<Player>>() { });

        return players;
    }

    @ApiOperation(value="Een team toevoegen")
    @PostMapping("/teams")
    public ResponseEntity<String> postTeam(@ApiParam(value = "Een nieuwe team object aanmaken ", required = true)@RequestBody Team team){

        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);

        ResponseEntity<Team> result = restTemplate.postForEntity(
                "http://teams-service/teams/", team, Team.class
        );

        return ResponseEntity.ok().build();
    }

}


