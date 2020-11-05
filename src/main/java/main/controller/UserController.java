package main.controller;

import main.model.User;
import main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService us;


    @GetMapping("/users")
    public List<User> getAll(){
        return us.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void newUser(@RequestBody User user){
        user.setId(us.getAll().size()+1);
        us.newUser(user);
    }


//    @PostMapping("/users")
//    public List<User> newUser(@RequestParam String name,@RequestParam String email,
//                              @RequestParam int user_type, @RequestParam String pw){
//
//        User user = new User();
//        user.setEmail(email);
//        user.setName(name);
//        user.setPassword(pw);
//        user.setUser_type(user_type);
//
//        ur.save(user);
//
//        return ur.findAll();
//
//    }
}
