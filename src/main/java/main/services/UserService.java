package main.services;

import main.model.User;
import main.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo ur;

    public List<User> getAll(){
        return ur.findAll();
    }

    public void newUser(User user){
        ur.save(user);
    }

}
