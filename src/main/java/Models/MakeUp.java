package Models;

public class MakeUp {
    private int sku;
    private String name;
    private String brand;
    private String type;
    private String sectionOfFace;
    private int qty;
    private double price;

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

    public void setSectionOfFace(String sectionOfFace) {
        this.sectionOfFace = sectionOfFace;
    }

    public String getSectionOfFace() {
        return sectionOfFace;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
