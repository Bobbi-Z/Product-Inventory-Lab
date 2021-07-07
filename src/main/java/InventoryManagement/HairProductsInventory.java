package InventoryManagement;

import Models.HairProducts;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;

public class HairProductsInventory {
    private static int nextSku = 1;
    public static ArrayList<HairProducts> inventory = new ArrayList<>();

    public static Object inventory(String name, String brand, String use,
                                   String typeOfHair, int qty, double price) {
        return inventory;
    }

    public static HairProducts create(String name, String brand, String use,
                                      String typeOfHair, int qty, double price){
        HairProducts createdHairProducts = new HairProducts(nextSku++, name, brand,
                use, typeOfHair, qty, price);
        inventory.add(createdHairProducts);
        return createdHairProducts;
    }

    public HairProducts findHairProducts(int sku){
        return inventory.get(sku);

    }
}
