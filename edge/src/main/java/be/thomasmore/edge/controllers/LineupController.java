package be.thomasmore.edge.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import be.thomasmore.edge.models.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lineups")
@Api(value = "Lineup  controller")
public class LineupController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @ApiOperation(value = "Lijst met all lineups")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succesvol, lijst met lineup opgehaald."),
            @ApiResponse(code = 401, message = "Unauthorized."),
            @ApiResponse(code = 403, message = "Permission denied."),
            @ApiResponse(code = 404, message = "Source not found.")
    })
    @GetMapping("/")
    public List<Lineup> getAll() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://lineup-service/lineups", GenericResponseWrapper.class);
        List<Lineup> lineups = objectMapper.convertValue(wrapper.get_embedded().get("lineups"),  new TypeReference<List<Lineup>>() { });

        return lineups;
    }

    @ApiOperation(value = "Bekijk een lijst met alle bijhorende objecten")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succesvol opgehaalde lijst met tracks."),
            @ApiResponse(code = 401, message = "U bent niet bevoegd om de bron te bekijken."),
            @ApiResponse(code = 403, message = "De toegang tot de bron die je probeerde te bereiken is verboden."),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken is niet gevonden.")
    })

    @GetMapping("/{lineup_id}")
    public Lineup getLineupByLineupId(@ApiParam(value = "LineupID waaruit het object van de artist zal worden opgehaald", required = true) @PathVariable("lineup_id") Integer lineup_id) {
        Lineup lineup = restTemplate.getForObject("http://lineup-service/lineups/" + lineup_id, Lineup.class);
        return lineup;
    }

}
