package be.thomasmore.auth.security.repository;

import be.thomasmore.auth.security.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser,String> {
    Boolean existsAppUserByUsernameEquals(String userName);
    AppUser findByUsernameEquals(String userName);
}
