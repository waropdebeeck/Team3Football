package be.thomasmore.edge.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description="Lineup model met speler array")
public class LineupPlayers {
    @ApiModelProperty(notes="Het lineup object")
    private Lineup lineup;
    @ApiModelProperty(notes="De array van spelers bij lineup")
    private List<Player> player;

    public LineupPlayers(Lineup lineup, List<Player> player) {
        this.lineup = lineup;
        this.player = player;
    }

    public Lineup getLineup() {
        return lineup;
    }

    public void setLineup(Lineup lineup) {
        this.lineup = lineup;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
