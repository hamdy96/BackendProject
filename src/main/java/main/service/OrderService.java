package main.service;

import main.models.Order;
import main.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository or;

    public List<Order> getAll(){
        return or.findAll();
    }

    public void newOrder(Order order){
        or.save(order);
    }
}
