package be.thomasmore.edge.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description="Model van Team met Players.")
public class TeamPlayer {
    @ApiModelProperty(notes="Het id van Team")
    private Team team;
    @ApiModelProperty(notes="De array met spelers")
    private List<Player> player;

    public TeamPlayer(Team team, List<Player> player) {
        this.team = team;
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
