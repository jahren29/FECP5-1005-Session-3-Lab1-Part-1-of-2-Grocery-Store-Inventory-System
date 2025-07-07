package org.example;

import java.util.HashMap;
import java.util.*;


public class Main {

    public static void viewInventory(HashMap<String, Integer> viewInventory) {

        if(viewInventory.isEmpty()){
            System.out.println("The inventory has no products!");
        }else{
            System.out.println("Here are the products:");
            for(String key : viewInventory.keySet()){
                System.out.println(key + " = " + viewInventory.get(key) + "pcs");

            }
        }
    }

    public static void addProduct(HashMap<String, Integer> addProduct){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String product = scan.next();
        System.out.print("Enter Quantity: ");
        int quantity = scan.nextInt();

        if(product.isEmpty() && quantity < 0){
            System.out.println("Invalid Input");
        }else{
            addProduct.put(product, quantity);
            System.out.println("Product Added Successfully!");
        }

    }

    public static void checkProduct(HashMap<String, Integer> checkProduct){
        Scanner scan = new Scanner(System.in);

        System.out.println("Select a product you want to check");
        String prodChecker = scan.next();
        if(!checkProduct.containsKey(prodChecker)){

            System.out.println("The product you wanted to check does not exist");
        }else{
            System.out.println("Here is the product you want to check: " + prodChecker + " = " + checkProduct.get(prodChecker) + "pcs" );

        }



    }

    private static void updateProduct(HashMap<String, Integer> myInventory) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String product = scan.next();
        System.out.print("Enter New Quantity: ");
        int quantity = scan.nextInt();

        if(quantity < 0){
            System.out.println("The quantity you have entered is not valid.");
        }else {
            myInventory.replace(product, quantity);
            System.out.println("The product has been updated");
        }


    }

    public static void removeProduct(HashMap<String, Integer> myInventory) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String product = scan.next();
        if(product.isEmpty()){

        System.out.println("You have entered Invalid Product Name! ");
        }else{
            myInventory.remove(product);
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

                    addProduct(myInventory);
                    break;

                case 3:
                    checkProduct(myInventory);
                    break;

                case 4:
                    updateProduct(myInventory);
                    break;


                case 5:
                    removeProduct(myInventory);
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Please try again with correct input. ");

            }
        }

    }

}