package Services;


import Models.HairProducts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HairProductsServicesTest {

    @Test
    public void createTest() throws IOException {

        String expectedName = "Clean & Pure Nourishing Detox Shampoo";
        String expectedBrand = "Nexxus";
        String expectedUse = "Shampoo";
        String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
        int expectedQty = 100;
        double expectedPrice = 13.99;

        HairProductsServices hairProductsServices = new HairProductsServices();
        HairProducts testHairProducts = hairProductsServices.create(expectedName,
                expectedBrand, expectedUse, expectedTypeOfHair,
                expectedQty, expectedPrice);

        // (3)

        String actualName = testHairProducts.getName();
        String actualBrand = testHairProducts.getBrand();
        String actualUse = testHairProducts.getUse();
        String actualTypeOfHair = testHairProducts.getTypeOfHair();
        int actualQty = testHairProducts.getQty();
        double actualPrice = testHairProducts.getPrice();


        // (4)
        Assertions.assertEquals(Integer.class.getName(), Integer.class.getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedUse, actualUse);
        Assertions.assertEquals(expectedTypeOfHair, actualTypeOfHair);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void testFindHairProduct() throws IOException {

        String expectedName = "Clean & Pure Nourishing Detox Shampoo";
        String expectedBrand = "Nexxus";
        String expectedUse = "Shampoo";
        String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
        int expectedQty = 100;
        double expectedPrice = 13.99;

        HairProductsServices testHairProductServices = new HairProductsServices();
        HairProducts testHairP = testHairProductServices.create(expectedName,
                expectedBrand, expectedUse, expectedTypeOfHair, expectedQty, expectedPrice);

        HairProducts actual = testHairProductServices.findHairProduct(1001);

        Assertions.assertEquals(actual, testHairP);

    }

    @Test
    public void testFindAll() throws IOException {

        String expectedName = "Clean & Pure Nourishing Detox Shampoo";
        String expectedBrand = "Nexxus";
        String expectedUse = "Shampoo";
        String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
        int expectedQty = 100;
        double expectedPrice = 13.99;

        HairProductsServices testHairProductServices = new HairProductsServices();
        HairProducts testHairAP2 = testHairProductServices.create(expectedName,
                expectedBrand, expectedUse, expectedTypeOfHair, expectedQty, expectedPrice);

        ArrayList<HairProducts> hairArray = new ArrayList<>();
        hairArray.add(testHairAP2);

        List<HairProducts> expected = testHairProductServices.findAll();

        Assertions.assertEquals(hairArray, expected);
    }

    @Test
    public void testDelete() throws IOException {
        String expectedName = "Clean & Pure Nourishing Detox Shampoo";
        String expectedBrand = "Nexxus";
        String expectedUse = "Shampoo";
        String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
        int expectedQty = 100;
        double expectedPrice = 13.99;

        HairProductsServices testHairProductServices = new HairProductsServices();
        HairProducts testHairAP3 = testHairProductServices.create(expectedName,
                expectedBrand, expectedUse, expectedTypeOfHair, expectedQty, expectedPrice);

        boolean actual = testHairProductServices.delete(testHairAP3.getSku());

        Assertions.assertTrue(actual);

    }

}