package operation;

import model.Customer;
import model.Order;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sessionHelperClass.Connection;

import java.util.List;
import java.util.Scanner;

public class DisplayAll {

    private static Scanner sc = new Scanner(System.in);
    public void displayProducts(){
        SessionFactory sessionFactory = Connection.sF();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("ENTER CUSTOMER ID ");
        int id = sc.nextInt();

       Query query = session.createQuery("from Customer c where c.customerId='"+id+"'");
       List<Customer> customerList = query.getResultList();
       for (Customer c : customerList){
           System.out.println("CUSTOMER ID "+ c.getCustomerId());
           System.out.println("CUSTOMER NAME "+ c.getCustomerName());
           System.out.println("CUSTOMER EMAIL ID "+ c.getCustomerEmail());
           System.out.println("---------------------------------------------");
           List<Order> orderList = c.getOrderList();
           for (Order o : orderList){
               System.out.println("ORDER ID "+ o.getOrdorId());
               System.out.println("ORDER DATE "+ o.getOrdorDate());
               System.out.println("---------------------------------------------");
               List<Product> productList = o.getProductList();
               for (Product p : productList){
                   System.out.println("PRODUCT ID " +p.getProductId());
                   System.out.println("PRODUCT NAME " +p.getProductName());
                   System.out.println("PRODUCT DESCRIPTION " +p.getProductDescription());
                   System.out.println("PRODUCT PRICE " +p.getPrice());
                   System.out.println("---------------------------------------------");
               }
           }
       }









    }
        }


