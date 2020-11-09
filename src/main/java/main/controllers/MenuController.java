package main.controllers;

import main.models.Menu;
import main.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    MenuService ms;

    @GetMapping("/menu")
    public List<Menu> getAll(){
        logger.info("Get all menu items");
        return ms.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/newMenu")
    @PreAuthorize("hasRole('ADMIN')")
    public void newMenu(@RequestBody Menu menu){
        //menu.setId(ms.getAll().size()+1);
        logger.info("Post new menu items");
        ms.newMenu(menu);
    }
    @RequestMapping(value = "/menu/{name}")
    public void getByName(@PathVariable("name") String name){
        logger.info("Get menu item by name");
        ms.findByName(name);
    }

}
