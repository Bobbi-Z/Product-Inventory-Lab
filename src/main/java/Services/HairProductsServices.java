package Services;

import Models.HairProducts;

import java.util.ArrayList;

public class HairProductsServices {

    private static int nextSku = 1;

    public ArrayList<HairProducts> inventory = new ArrayList<>();
    public ArrayList<HairProducts> inventoryForUpdates = new ArrayList<>();
    private static int skuForUpdates = 0;

    public HairProducts create(String name, String brand, String use, String typesOfHair, int qty, double price) {
        HairProducts createdHairProducts = new HairProducts(nextSku++, name, brand, use, typesOfHair, qty, price);

        inventory.add(createdHairProducts);
        return createdHairProducts;
    }
  /*  public ArrayList<HairProducts> createNoSku(int sku, String name, String brand, String use, String typesOfHair, int qty, double price) {
        HairProducts createdUpdateHP = new HairProducts(skuForUpdates, name, brand, use, typesOfHair, qty, price);
        if (inventoryForUpdates.isEmpty() == false){
            inventoryForUpdates.clear();
            inventoryForUpdates.add(createdUpdateHP);
        }
        inventoryForUpdates.add(createdUpdateHP);
        return createdUpdateHP;
    }*/

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
        for (int index = 0; index < inventory.size(); index++) {
            if (inventory.get(index).getSku() == sku) {
                inventory.remove(inventory.get(index));
                return true;
            }
        }
        return false;
    }

   /* public  HairProducts updateQty(int sku, int newQty) {
        for (int index = 0; index < inventory.size(); index++) {
            if (inventory.get(index).getSku() == sku) {

                inventoryForUpdates = createNoSku(sku, inventory.get(index).getName(),
                        inventory.get(index).getBrand(), inventory.get(index).getUse(),
                        inventory.get(index).getTypeOfHair(), newQty, inventory.get(index).getPrice());
               inventory.replace(index, inventoryForUpdates.get(sku))


            }
        }
        return inventory.get(sku);
    }*/
}