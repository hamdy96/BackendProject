package main.controllers;

import main.models.Menu;
import main.models.Order;
import main.services.OrderService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class OrderController {



    @Autowired
    OrderService os ;

    @GetMapping("/orders")
    public List<Order> getAll(){
        return os.getAll();
    }

    @PostMapping("/orders")
    public void newOrder(@RequestBody Order order){

        os.newOrder(order);
    }
}
