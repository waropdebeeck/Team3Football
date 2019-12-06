package be.thomasmore.playersservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="player")
@Data
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int player_id;

    @Column(name="team_id")
    private int team_id;

    @Column(name="name")
    private String name;

    @Column(name="number")
    private int number;

    @Column(name="age")
    private int age;
}