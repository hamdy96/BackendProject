package main.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", referencedColumnName = "user_id",insertable = false,updatable = false,nullable = false)
    @JsonIgnoreProperties(value = {"orders","hibernateLazyInitializer"})
    private User user;


    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @Column(name = "total")
    private double total;


    @OneToMany(targetEntity = Menu.class, fetch = FetchType.LAZY)
    @JoinTable(name = "order_details",joinColumns = @JoinColumn(name = "order_id"),inverseJoinColumns = @JoinColumn(name = "menuitem_id"))
    List<Menu> items;

    public Order(){

    }

    public Order(int id,Date date,User user, double total,List<Menu> items) {
        this.user = user;
        this.total = total;
        this.id = id;
        this.date = date;
        this.items = items;
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

//    public double getTotal() {
//        return total;
//    }
    public double getTotal(){
    this.total = 0;
    for(int i=0;i<this.items.size();i++){
        this.total += this.items.get(i).getPrice();
    }
    return this.total;
}
    public void setTotal(double total) {
        this.total = total;
    }

    public List<Menu> getItems() {
        return items;
    }

    public void setItems(List<Menu> items) {
        this.items = items;
    }



}
