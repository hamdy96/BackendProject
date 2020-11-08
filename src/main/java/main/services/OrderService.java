package main.services;

import main.models.Menu;
import main.models.Order;
import main.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo or;

    public List<Order> getAll(){
        return or.findAll();
    }

    public void newOrder(Order order){
        or.save(order);
    }
}
