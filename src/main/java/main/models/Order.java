package main.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name="id")
    private int id;

    @Column(name = "user_id")
    private User user;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @Column(name = "total")
    private int total;

    public Order(User user, int total) {
        this.user = user;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
