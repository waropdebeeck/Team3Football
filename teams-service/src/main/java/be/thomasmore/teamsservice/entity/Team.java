package be.thomasmore.teamsservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;


@Data
@Document(collection = "team")
public class Team {
    @Id
    private String id;
    private String naam;
}

