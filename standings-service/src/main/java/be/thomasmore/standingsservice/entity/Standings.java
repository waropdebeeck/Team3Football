package be.thomasmore.standingsservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="standings")
@Data
@NoArgsConstructor
public class Standings {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="league_id")
    private int league_id;

    @Column(name="team_id")
    private int team_id;

    @Colum(name="rank")
    private int rank;

    @Column(name"teamName")
    private String teamName;

    @Column(name="logo")
    private String logo;

    @Column(name="group")
    private String group;

    @Column(name="forme")
    private String forme;

    @Column(name="description")
    private String description;
}
