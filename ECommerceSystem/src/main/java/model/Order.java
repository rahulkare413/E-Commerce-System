package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ordor")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderIdGenerator")
    @SequenceGenerator(name = "orderIdGenerator",allocationSize = 1000,initialValue = 100)

    @Column(name = "ordor_id")
    private int ordorId;

    @Column(name = "ordor_date")
    private Date ordorDate;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "customer_ref")
    private Customer customerRef;

    @OneToMany(mappedBy = "orderRef",cascade = CascadeType.ALL)
    private List<Product> productList;

    public void addProduct(Product p){
        if (productList==null){
            productList = new LinkedList<>();
        }
        productList.add(p);
        p.setOrderRef(this);
    }


}
