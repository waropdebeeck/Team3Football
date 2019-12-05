package be.thomasmore.auth.security.repository;

import be.thomasmore.auth.security.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import be.thomasmore.auth.security.repository.AppUserRepository;
import be.thomasmore.auth.security.repository.AppUserRepository;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private AppUserRepository repository;


    @PostMapping(path ="/create")
    public ResponseEntity createNewUser(@RequestBody AppUser user){
        if(repository.findByUsernameEquals(user.getUsername())!= null)
            return ResponseEntity.badRequest().body("Deze gebruikers naam is al in gebruik");


        repository.save(user);


        return  ResponseEntity.ok(user);

    }
}
