package be.thomasmore.lineupsservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="lineup")
@Data
@NoArgsConstructor
public class Lineup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int lineup_id;

    @Column(name = "team_id")
    private int team_id;

    @Column(name = "player_id")
    private int player_id;

    @Column(name = "player")
    private String player;

    @Column(name = "number")
    private int number;

    @Column(name = "pos")
    private String pos;
}
