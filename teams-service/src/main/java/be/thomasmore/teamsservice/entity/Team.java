package be.thomasmore.teamsservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="team")
@Data
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int team_id;

    @Column(name="number_of_players")
    private int number_off_players;

    @Column(name="name")
    private String name;
}
