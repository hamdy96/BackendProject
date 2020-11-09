package main.services;

import main.models.Menu;
import main.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepo mr;

    public List<Menu> getAll(){
        return mr.findAll();
    }

    public void newMenu(Menu menu){
        mr.save(menu);
    }

}
