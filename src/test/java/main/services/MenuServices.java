package main.services;

import main.models.Menu;
import main.repository.MenuRepo;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MenuServices {
    MenuService ms ;

    MenuRepo mr;

    @Test
    public void GetAllTest() {
        when(mr.findAll()).thenReturn(
                new LinkedList<Menu>(Arrays.asList(
                        new Menu(1,"chicken ranch",200,"img1"),
                        new Menu(2,"bbq",200,"img2"),
                        new Menu(3,"6 cheese",200,"img3"),
                        new Menu(4,"seafood",200,"img4"))));
        List<Menu> expected = mr.findAll();
        List<Menu> actual = ms.getAll();
        assertEquals(expected, actual);
    }

}
