package InventoryManagement;

import Models.HairProducts;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static InventoryManagement.HairProductsInventory.inventory;

public class HairProductsInventoryTest {

    private String name;
    private String brand;
    private String use;
    private String typeOfHair;
    private Integer qty;
    private Double price;
    private int sku;
    private Object HairProducts;
    private HairProductsInventory findHairProductsInventory;

    @Test
    public void createTest(){
        String expectedName = "Clean & Pure Nourishing Detox Shampoo";
        String expectedBrand = "Nexxus";
        String expectedUse = "Shampoo";
        String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
        int expectedQty = 100;
        double expectedPrice = 13.99;

        HairProductsInventory hairProductsInventory = new HairProductsInventory();
        HairProductsInventory testHairProductsInventory = HairProductsInventory.create(expectedName,
                expectedBrand,expectedUse,expectedTypeOfHair, expectedQty, expectedPrice);

        int actualSku = testHairProductsInventory.getSku();
        String actualName = testHairProductsInventory.getName();
        String actualBrand = testHairProductsInventory.getBrand();
        String actualUse = testHairProductsInventory.getUse();
        String actualTypeOfHair = testHairProductsInventory.getTypeOfHair();
        int actualQty = testHairProductsInventory.getQty();
        double actualPrice = testHairProductsInventory.getPrice();

        Assertions.assertEquals(Integer.class.getName(),
                new Integer(actualSku).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedUse, actualUse);
        Assertions.assertEquals(expectedTypeOfHair, actualTypeOfHair);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void create() {
    }

    @Test
    void findHairProductsTest() {
        Object expectedObject = HairProductsInventory.inventory(name = "Clean & Pure Nourishing Detox Shampoo", brand = "Nexxus",
               use = "Shampoo", typeOfHair = "1A, 1B, 1C, 2A, 2B, 2c", qty = 100, price =13.99);
        HairProductsInventory hairProductsInventory = new HairProductsInventory();
        HairProductsInventory actualObject = findHairProductsInventory.inventory.get(sku);
        Assertions.assertEquals(expectedObject, actualObject);


    }
}
