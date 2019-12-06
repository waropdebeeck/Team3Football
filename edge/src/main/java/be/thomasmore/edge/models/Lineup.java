package be.thomasmore.edge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description="Model van Lineup.")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lineup {
    @ApiModelProperty(notes="Het id van het Lineup")
    private String Id;
    @ApiModelProperty(notes="De naam van Lineup")
    private String naam;
    @ApiModelProperty(notes="Het playerId van Lineup ")
    private List<String> playerId;

    public Lineup() {
    }

    public Lineup(String id, String naam, List<String> playerId) {
        Id = id;
        this.naam = naam;
        this.playerId = playerId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<String> getPlayerId() {
        return playerId;
    }

    public void setPlayerId(List<String> playerId) {
        this.playerId = playerId;
    }
}
