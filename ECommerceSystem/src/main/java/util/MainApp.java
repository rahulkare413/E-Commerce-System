package util;

import operation.DeleteProduct;
import operation.DisplayAll;
import operation.InsertData;
import operation.UpdateProduct;

import java.util.Scanner;

public class MainApp {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean status = true;
        while (status){
            System.out.println("1. INSERT DATA ");
            System.out.println("2. UPDATE DATA ");
            System.out.println("3. DISPLAY DATA ");
            System.out.println("4. DELETE DATA ");
            System.out.println("5. EXIT ");
            System.out.println("ENTER YOUR CHOICE 😎😎");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    InsertData insertData = new InsertData();
                    insertData.addCustomer();
                    break;
                case 2:
                    UpdateProduct updateProduct = new UpdateProduct();
                    updateProduct.updatePro();
                    break;
                case 3:
                    DisplayAll displayAll = new DisplayAll();
                    displayAll.displayProducts();
                    break;
                case 4:
                    DeleteProduct deleteProduct = new DeleteProduct();
                    deleteProduct.deletePro();
                    break;
                case 5:
                    System.out.println("THANKS FOR VISITING !!");
                    status = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE 🚫🚫");
            }

        }

    }
}
