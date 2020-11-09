package main.service;

import main.models.Menu;
import main.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository mr;

    public List<Menu> getAll(){
        return mr.findAll();
    }

    public void newMenu(Menu menu){
        mr.save(menu);
    }

    public Menu findByName(String name){
        return mr.findByName(name);
    }

}
