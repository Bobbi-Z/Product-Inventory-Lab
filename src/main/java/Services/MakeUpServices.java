package Services;

import Models.MakeUp;

import java.util.ArrayList;

public class MakeUpServices {

    private static int nextSku = 2000;

    public ArrayList<MakeUp> inventory = new ArrayList<>();

    public MakeUp create(String name, String brand, String type,
                         String color, int qty, double price) {

        MakeUp createdMakeUp = new MakeUp(nextSku++, name, brand,
                type, color, qty, price);

        inventory.add(createdMakeUp);
        return createdMakeUp;

    }


    public MakeUp findMakeUp(int sku) {
        for (int index = 0; index < inventory.size(); index++) {
            if (inventory.get(index).getSku() == sku) {
                return inventory.get(index);

            }
        }
        return null;
    }

    public ArrayList<MakeUp> findAll() {
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
}


