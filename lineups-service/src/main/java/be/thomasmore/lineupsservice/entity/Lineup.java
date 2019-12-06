package be.thomasmore.lineupsservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "lineup")
public class Lineup {
    @Id
    private String id;
    private String naam;
    private Integer userId;
    private List<String> playerId;
    }

