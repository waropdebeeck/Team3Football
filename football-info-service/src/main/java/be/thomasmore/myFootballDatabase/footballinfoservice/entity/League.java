package be.thomasmore.myFootballDatabase.footballinfoservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="league")
@Data
@NoArgsConstructor
public class League {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="league_id")
    private int league_id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="country")
    private String country;

    @Column(name="country_code")
    private String country_code;

    @Column(name="season")
    private String season;

    @Column(name="season_start")
    private String season_end;

    @Column(name="logo")
    private String logo;

    @Column(name="flag")
    private String flag;

    @Column(name="standings")
    private int standings;

    @Column(name="is_current")
    private int is_current;

}
