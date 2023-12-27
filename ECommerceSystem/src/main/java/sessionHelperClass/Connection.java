package sessionHelperClass;

import model.Customer;
import model.Order;
import model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {

    public static SessionFactory sF(){
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Order.class).addAnnotatedClass(Product.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        return sessionFactory;

    }

}
