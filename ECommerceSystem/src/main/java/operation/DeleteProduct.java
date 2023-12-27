package operation;

import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionHelperClass.Connection;

import java.util.Scanner;

public class DeleteProduct {
    private static Scanner sc = new Scanner(System.in);
    public void deletePro() {
        SessionFactory sessionFactory = Connection.sF();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER PRODUCT ID ");
        int id = sc.nextInt();

        Product p = session.get(Product.class,id);

        session.delete(p);
        tx.commit();
        session.close();
    }
}
