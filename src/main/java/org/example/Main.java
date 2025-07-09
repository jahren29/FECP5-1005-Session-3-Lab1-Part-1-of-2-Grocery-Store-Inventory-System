package org.example;

import java.util.HashMap;
import java.util.*;

public class Main {

    public static void viewInventory(HashMap<String, Integer> viewInventory) {

        if(viewInventory.isEmpty()){
            System.out.println("The inventory has no products!");
        }else{
            System.out.println("Product you want to check:");
            for(String key : viewInventory.keySet()){
                System.out.println(key + " = " + viewInventory.get(key) + "pcs");
            }
        }
    }

    public static boolean addProduct(HashMap<String, Integer> addProduct, String product, int quantity){

        if(quantity < 0 || product.isEmpty() ){
            System.out.println("Invalid Input");
            return false;

        }else{
            addProduct.put(product, quantity);
            System.out.println("Product Added Successfully!");
            return true;

        }

    }

    public static boolean checkProduct(HashMap<String, Integer> checkProduct, String prodChecker){

        if(!checkProduct.containsKey(prodChecker)){
            System.out.println("The product you wanted to check does not exist");
            return false;
        }else{
            System.out.println("Here is the product you want to check: ");
            System.out.println(prodChecker + " = " + checkProduct.get(prodChecker) + "pcs" );
            return true;
        }

    }

    public static boolean updateProduct(HashMap<String, Integer> updateProduct, String productToUpdate, int quantityToUpdate) {

        if(!updateProduct.containsKey(productToUpdate) || quantityToUpdate < 0){
            System.out.println("Product Not Found or Invalid Quantity");
            return false;

        }else {
            updateProduct.replace(productToUpdate, quantityToUpdate);
            System.out.println("The product has been updated");
            return true;
        }

    }

    public static void removeProduct(HashMap<String, Integer> removeProduct, String productToRemove) {

        if(!removeProduct.containsKey(productToRemove) || productToRemove.isEmpty()){

            System.out.println("You have entered Invalid Product Name! ");
        }else{
            removeProduct.remove(productToRemove);
            System.out.println("You have successfully deleted a product");
        }
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HashMap<String, Integer> myInventory = new HashMap<>();
        int choice = 0;
        while (choice != 6) {
            System.out.println("----- Grocery Inventory Menu -----");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.println("----- Grocery Inventory Menu -----");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    viewInventory(myInventory);
                    break;

                case 2:
                    System.out.print("Enter Product Name: ");
                    String product = scan.next();
                    System.out.print("Enter Quantity: ");
                    int quantity = scan.nextInt();

                    boolean addProductResult = addProduct(myInventory, product, quantity);
                    break;

                case 3:
                    System.out.print("Select a product you want to check: ");
                    String prodChecker = scan.next();
                    boolean checkProductResult = checkProduct(myInventory, prodChecker);
                    if(checkProductResult){
                        System.out.println("Product Checked SuccessFully ");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product Name: ");
                    String productToUpdate = scan.next();
                    System.out.print("Enter New Quantity: ");
                    int quantityToUpdate = scan.nextInt();
                    boolean updateProductResult = updateProduct(myInventory, productToUpdate, quantityToUpdate);

                    if(!updateProductResult){
                        System.out.println("Product Not Found");
                    }
                    break;


                case 5:
                    System.out.print("Enter Product Name: ");
                    String productToRemove = scan.next();
                    removeProduct(myInventory, productToRemove);
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Please try again with correct input. ");
                    break;
            }
        }

    }

}