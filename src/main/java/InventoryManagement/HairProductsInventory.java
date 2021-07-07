package InventoryManagement;

import Models.HairProducts;

import java.util.ArrayList;
import java.util.List;

public class HairProductsInventory {
    private static int nextSku = 1;
    private int sku;
    private String name;
    private String brand;
    private String use;
    private String typeOfHair;
    private int qty;
    private double price;

    public static ArrayList<HairProductsInventory> inventory = new ArrayList<>();

    public static Object inventory(String name, String brand, String use,
                                   String typeOfHair, int qty, double price) {
        return inventory;
    }

    public static HairProductsInventory create(String name, String brand, String use,
                                      String typeOfHair, int qty, double price){
        HairProducts createdHairProducts = new HairProducts(nextSku++, name, brand,
                use, typeOfHair, qty, price);
        inventory.add(createdHairProducts);
        return createdHairProducts;
    }

    public HairProductsInventory findHairProductsInventory(int sku){
     inventory(sku)= name, brand, use, typeOfHair, qty, price;


        return (HairProductsInventory) inventory(sku);

    }

    private Object inventory(int sku) {

    }


    private ArrayList<HairProductsInventory> getInventory() {
        return inventory;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
    return brand;
    }

    public String getUse() {
    return use;
    }

    public String getTypeOfHair() {
    return typeOfHair;
    }

    public Integer getQty() {
    return qty;
    }

    public Double getPrice() {
    return getPrice();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setTypeOfHair(String typeOfHair) {
        this.typeOfHair = typeOfHair;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
