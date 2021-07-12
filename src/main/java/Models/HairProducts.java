package Models;

import Services.HairProductsServices;

public class HairProducts extends HairProductsServices {
    private int sku;
    private String name;
    private String brand;
    private String use;
    private String typeOfHair;
    private int qty;
    private double price;

    public HairProducts() {

    }

    public HairProducts(int sku, String name, String brand, String use,
                        String typeOfHair, int qty, double price) {
    setSku(sku);
    setName(name);
    setBrand(brand);
    setUse(use);
    setTypeOfHair(typeOfHair);
    setQty(qty);
    setPrice(price);
    }

    public void setSku(Integer sku) {
    this.sku = sku;
    }

    public Integer getSku() {
        return sku;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getUse() {
        return use;
    }

    public void setTypeOfHair(String typeOfHair) {
        this.typeOfHair = typeOfHair;
    }

    public String getTypeOfHair() {
        return typeOfHair;
    }

    public void setQty(int qty){
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "***     SKU: " + this.getSku() + "| Name: " + this.getName() +
                "| Brand: " + this.getBrand() + "| Use: " + this.getUse() +
                "| Hair Type: " + this.getTypeOfHair() + "| Quantity: " + this.getQty() +
                "| Price: " + this.getPrice() + "|     ***";
}
}
