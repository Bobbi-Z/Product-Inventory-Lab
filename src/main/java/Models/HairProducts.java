package Models;

public class HairProducts {
    private int sku;
    private String name;
    private String brand;
    private String use;
    private String typeOfHair;
    private int qty;
    private double price;

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
}
