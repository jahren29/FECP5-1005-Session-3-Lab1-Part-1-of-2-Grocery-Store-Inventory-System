package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private HashMap<String, Integer> myInventory;

    @BeforeEach
    void settingUpHashMap(){
        myInventory = new HashMap<>();
    }

    @Test
    void testAddProductWithAValidQuantityAndNotValid(){
        Main.addProduct(myInventory, "Banana", 30);
        assertEquals(30, myInventory.get("Banana"));

        boolean result = Main.addProduct(myInventory, "Orange", -10);
        assertFalse(result);

    }

    @Test
    void testAddingProductWithQuantityZero(){
        Main.addProduct(myInventory, "Mango", 0);      // adding products with quantity of zero

        assertEquals(0, myInventory.get("Mango"));

        myInventory.put("Milk", 10);                                    //adding products that exists
        Main.addProduct(myInventory, "Milk", 50);
        assertEquals(50, myInventory.get("Milk") );
    }



    @Test
    void testValidCheckAndNonExistent(){
        myInventory.put("Milk", 20);                                    // checking with valid or existing product
        Main.checkProduct(myInventory, "Milk");
        assertEquals(20, myInventory.get("Milk"));

        boolean result = Main.checkProduct(myInventory, "Ice Cream");
        assertFalse(result);                                           // checking for a product that doesn't exist
    }

    @Test
    void testUpdateAnExistingProductAndNonExisting(){
        myInventory.put("Bread", 300);                                  // updates an existing product with a valid identity
        Main.updateProduct(myInventory, "Bread", 25);
        assertEquals(25, myInventory.get("Bread"));

        boolean result = Main.updateProduct(myInventory, "Tofu", 10);
        assertFalse(result);                                            // test of updating a non-existing product

        myInventory.put("Apple", 10);
        boolean result1 = Main.updateProduct(myInventory, "Apple", -20);
        assertFalse(result1);                                           // test of updating if the quantity is less than 0

    }

    @Test
    void testRemoveAnExistingProductAndNonExisting(){
        myInventory.put("Eggs", 15);                                    //Existing
        Main.removeProduct(myInventory, "Eggs");
        assertFalse(myInventory.containsKey("Eggs"));

        Main.removeProduct(myInventory,"Pizza");        //Non Existing
        assertFalse(myInventory.containsKey("Pizza"));
    }















}