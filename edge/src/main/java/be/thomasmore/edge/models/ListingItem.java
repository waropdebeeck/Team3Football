package be.thomasmore.edge.models;

import lombok.Data;

@Data
public class ListingItem {
    private Integer player_id;
    private Integer team_id;
    private String player;
    private String pos;
    private Integer number;
}
