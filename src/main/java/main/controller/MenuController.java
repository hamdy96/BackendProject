package main.controller;

import main.model.Menu;
import main.model.User;
import main.repo.MenuRepo;
import main.repo.UserRepo;
import main.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuService ms;


    @GetMapping("/menu")
    public List<Menu> getAll(){
        return ms.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/menu")
    public void newMenu(@RequestBody Menu menu){
        menu.setId(ms.getAll().size()+1);
        ms.newMenu(menu);
    }
}
