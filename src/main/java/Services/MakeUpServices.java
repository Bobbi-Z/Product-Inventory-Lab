package Services;

import Models.MakeUp;

import java.util.ArrayList;

public class MakeUpServices {

    private static int nextSku = 1;

    private ArrayList<MakeUp> inventory = new ArrayList<>();

    public MakeUp create(String expectedName, String expectedBrand, String expectedType,
                         String expectedSectionOfFace, int expectedQty, double expectedPrice) {

        MakeUp createdMakeUp = new MakeUp(nextSku++, expectedName, expectedBrand,
                expectedType, expectedSectionOfFace, expectedQty, expectedPrice);

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
