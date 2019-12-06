package be.thomasmore.playersservice.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document(collection= "player")
public class Player {
    @Id
    private String id;
    private String naam;
    private Integer number;
    private String pos;

}
