package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @OneToMany(mappedBy = "customerRef",cascade = CascadeType.ALL)
    private List<Order> orderList;

    public void addOrder(Order o){
        if (orderList==null){
            orderList = new LinkedList<>();
        }
        orderList.add(o);
        o.setCustomerRef(this);
    }
}
