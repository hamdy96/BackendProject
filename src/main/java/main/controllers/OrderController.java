package main.controllers;

import main.models.Order;
import main.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        order.setTotal(order.getTotal());
        os.newOrder(order);
    }

}
