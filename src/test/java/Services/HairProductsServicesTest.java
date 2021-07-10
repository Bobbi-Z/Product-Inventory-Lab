package Services;


import Models.HairProducts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HairProductsServicesTest {

        @Test
        public void createTest(){

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
            int actualSku = testHairProducts.getSku();
            String actualName = testHairProducts.getName();
            String actualBrand = testHairProducts.getBrand();
            String actualUse = testHairProducts.getUse();
            String actualTypeOfHair = testHairProducts.getTypeOfHair();
            int actualQty = testHairProducts.getQty();
            double actualPrice = testHairProducts.getPrice();


            // (4)
            Assertions.assertEquals(Integer.class.getName(), new Integer(actualSku).getClass().getName());
            Assertions.assertEquals(expectedName, actualName);
            Assertions.assertEquals(expectedBrand, actualBrand);
            Assertions.assertEquals(expectedUse, actualUse);
            Assertions.assertEquals(expectedTypeOfHair, actualTypeOfHair);
            Assertions.assertEquals(expectedQty, actualQty);
            Assertions.assertEquals(expectedPrice, actualPrice);

        }

       /* @Test
        public void createUpdateTest(){

            int expectedSku = 0;
            String expectedName = "Clean & Pure Nourishing Detox Shampoo";
            String expectedBrand = "Nexxus";
            String expectedUse = "Shampoo";
            String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
            int expectedQty = 100;
            double expectedPrice = 13.99;

            HairProductsServices hairProductsServices = new HairProductsServices();
            HairProducts testHairProducts = hairProductsServices.createNoSku(expectedSku,expectedName,
                    expectedBrand, expectedUse, expectedTypeOfHair,
                    expectedQty, expectedPrice);

            // (3)
            int actualSku = 0;
            String actualName = testHairProducts.getName();
            String actualBrand = testHairProducts.getBrand();
            String actualUse = testHairProducts.getUse();
            String actualTypeOfHair = testHairProducts.getTypeOfHair();
            int actualQty = testHairProducts.getQty();
            double actualPrice = testHairProducts.getPrice();


            // (4)

            Assertions.assertEquals(expectedSku, actualSku);
            Assertions.assertEquals(expectedName, actualName);
            Assertions.assertEquals(expectedBrand, actualBrand);
            Assertions.assertEquals(expectedUse, actualUse);
            Assertions.assertEquals(expectedTypeOfHair, actualTypeOfHair);
            Assertions.assertEquals(expectedQty, actualQty);
            Assertions.assertEquals(expectedPrice, actualPrice);

        }*/

        @Test
        public void testFindHairProduct(){

            String expectedName = "Clean & Pure Nourishing Detox Shampoo";
            String expectedBrand = "Nexxus";
            String expectedUse = "Shampoo";
            String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
            int expectedQty = 100;
            double expectedPrice = 13.99;

            HairProductsServices testHairProductServices = new HairProductsServices();
            HairProducts testHairP = testHairProductServices.create(expectedName,
                    expectedBrand, expectedUse, expectedTypeOfHair, expectedQty, expectedPrice);

            HairProducts actual = testHairProductServices.findHairProduct(1);

            Assertions.assertEquals(actual, testHairP);

        }

        @Test
        public void testFindAll(){

            String expectedName = "Clean & Pure Nourishing Detox Shampoo";
            String expectedBrand = "Nexxus";
            String expectedUse = "Shampoo";
            String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
            int expectedQty = 100;
            double expectedPrice = 13.99;

            HairProductsServices testHairProductServices = new HairProductsServices();
            HairProducts testHairAP = testHairProductServices.create(expectedName,
                    expectedBrand, expectedUse, expectedTypeOfHair, expectedQty, expectedPrice);

            ArrayList<HairProducts> hairArray = new ArrayList<>();
            hairArray.add(testHairAP);

            ArrayList<HairProducts> expected = testHairProductServices.findAll();

            Assertions.assertEquals(hairArray, expected);
        }
        @Test
        public void testDelete(){
            String expectedName = "Clean & Pure Nourishing Detox Shampoo";
            String expectedBrand = "Nexxus";
            String expectedUse = "Shampoo";
            String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
            int expectedQty = 100;
            double expectedPrice = 13.99;

            HairProductsServices testHairProductServices = new HairProductsServices();
            HairProducts testHairAP = testHairProductServices.create(expectedName,
                    expectedBrand, expectedUse, expectedTypeOfHair, expectedQty, expectedPrice);

            boolean actual = testHairProductServices.delete(1);

            Assertions.assertTrue(actual);

        }

 /*   @Test
    public void updateQty() {
        String expectedName = "Clean & Pure Nourishing Detox Shampoo";
        String expectedBrand = "Nexxus";
        String expectedUse = "Shampoo";
        String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
        int expectedQty = 5;
        double expectedPrice = 13.99;

        HairProductsServices testHairProductServices = new HairProductsServices();
        HairProducts testHairP = testHairProductServices.create(expectedName,
                expectedBrand, expectedUse, expectedTypeOfHair, expectedQty, expectedPrice);


        HairProducts actual = testHairProductServices.updateQty(1, 5);

        Assertions.assertEquals(actual, testHairP);
    }*/
}



