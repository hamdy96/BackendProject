package main.services;

import main.model.Menu;
import main.model.User;
import main.repo.MenuRepo;
import main.repo.UserRepo;
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
