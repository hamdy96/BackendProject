package main.controllers;

import main.models.Menu;
import main.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @RequestMapping(method = RequestMethod.POST, value = "/newMenu")
    @PreAuthorize("hasRole('ADMIN')")
    public void newMenu(@RequestBody Menu menu){
        menu.setId(ms.getAll().size()+1);
        ms.newMenu(menu);
    }
}
