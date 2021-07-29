package Services;

import Models.HairProducts;

import java.util.ArrayList;

public class HairProductsServices {

    private static int nextSku = 1000;

    public ArrayList<HairProducts> inventory = new ArrayList<>();

    public HairProducts create(String name, String brand, String use, String typesOfHair, int qty, double price) {
        HairProducts createdHairProducts = new HairProducts(nextSku++, name, brand, use, typesOfHair, qty, price);

        inventory.add(createdHairProducts);
        return createdHairProducts;
    }

    public HairProducts findHairProduct(int sku) {

        for (int index = 0; index < inventory.size(); index++) {
            if (inventory.get(index).getSku() == sku) {
                return inventory.get(index);

            }
        }
        return null;
    }

    public ArrayList<HairProducts> findAll() {
        return inventory;
    }

    public boolean delete(int sku) {
        for (HairProducts element : inventory) {
            if (element.getSku() == sku) {
                inventory.remove(element);
                return true;
            }
        }
        return false;
    }


}