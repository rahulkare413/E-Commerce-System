package operation;

import model.Customer;
import model.Order;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionHelperClass.Connection;

import java.util.Date;
import java.util.Scanner;

public class InsertData {

    private static Scanner sc = new Scanner(System.in);
    public Customer addCustomer(){
        SessionFactory sessionFactory = Connection.sF();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER CUSTOMER NAME ");
        String custName = sc.next();
        System.out.println("ENTER CUSTOMER EMAIL ID ");
        String emailId = sc.next();

        Customer c1 = new Customer();
        c1.setCustomerName(custName);
        c1.setCustomerEmail(emailId);

        System.out.println("HOW MANY CUSTOMER YOU WANT BE ADDED ");
        int count = sc.nextInt();
        for (int i = 1 ; i<=count ; i++){
            Order o1 = addOrder();
            c1.addOrder(o1);
        }
        session.save(c1);
        tx.commit();
        session.close();


        return c1;
    }

   public Order addOrder(){
       System.out.println("ORDER DATE ");
       Date date = new Date();

       Order o1 = new Order();
       o1.setOrdorDate(date);

       System.out.println("HOW MANY PRODUCT YOU WANT BE ADDED ");
       int count = sc.nextInt();
       for (int i = 1 ; i<=count ; i++){
           Product p1 = addProduct();
           o1.addProduct(p1);
       }

       return o1;
   }

   public Product addProduct(){
       System.out.println("ENTER PRODUCT NAME ");
       String productName = sc.next();
       System.out.println("ENTER PRODUCT DESCRIPTION ");
       String description = sc.next();
       System.out.println("ENTER PRODUCT PRICE ");
       double productPrice = sc.nextDouble();


       Product p1 = new Product();
       p1.setProductName(productName);
       p1.setProductDescription(description);
       p1.setPrice(productPrice);

       return p1;


   }
}
