package be.thomasmore.edge.models;

import lombok.Data;

@Data
public class ListingItem {
    private Integer playerId;
    private Integer teamId;
    private Player player;
    private String pos;
    private Integer number;
}
