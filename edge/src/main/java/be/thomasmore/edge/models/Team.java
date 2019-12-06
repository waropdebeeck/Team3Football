package be.thomasmore.edge.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="Model van Team.")
public class Team {
    @ApiModelProperty(notes="Het id van Team")
    private
    String id;
    @ApiModelProperty(notes="De naam van Team")
    private
    String naam;

    public Team() {
    }
    public Team(String id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
