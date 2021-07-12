package Models;

public class MakeUp {
    private int sku;
    private String name;
    private String brand;
    private String type;
    private String color;
    private int qty;
    private double price;

    public MakeUp() {
    }

    public MakeUp(int sku, String name, String brand, String type,
                  String color, int qty, double price) {
    setSku(sku);
    setName(name);
    setBrand(brand);
    setType(type);
    setColor(color);
    setQty(qty);
    setPrice(price);
    }


    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getSku() {
        return sku;
    }

    public void setName(String name) {
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQty() {
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
        return "SKU: " + this.getSku() + " Name: " + this.getName() +
                " Brand: " + this.getBrand() + " Type: " + this.getType() +
                " Color: " + this.getColor() + " Quantity: " + this.getQty() +
                " Price: " + this.getPrice();
    }
}
