package operation;

import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionHelperClass.Connection;

import java.util.Scanner;

public class UpdateProduct {

    private static Scanner sc = new Scanner(System.in);
    public void updatePro(){
        SessionFactory sessionFactory = Connection.sF();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER PRODUCT ID TO UPDATE THE DATA ");
        int id = sc.nextInt();
        System.out.println("ENTER PRODUCT NAME ");
        String proName = sc.next();
        System.out.println("ENTER UPDATED PRICE ");
        double price = sc.nextDouble();

       Product product = session.get(Product.class,id);
       product.setProductName(proName);
       product.setPrice(price);

       session.update(product);
       tx.commit();
       session.close();
    }
}
