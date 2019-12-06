package be.thomasmore.edge.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="Model van Player.")
public class Player {
    @ApiModelProperty(notes="Het id van Player")
    private
    String id;
    @ApiModelProperty(notes="De naam van Player")
    private
    String naam;
    @ApiModelProperty(notes="De leeftijd van Player")
    private
    Integer number;
    @ApiModelProperty(notes="De positie van Player")
    private
    String pos;


    public Player() {
    }

    public Player(String id, String naam, Integer number, String pos) {
        this.id = id;
        this.naam = naam;
        this.number = number;
        this.pos = pos;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }


}
