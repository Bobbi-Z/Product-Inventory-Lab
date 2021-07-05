package Models;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HairProductsTest {

    private HairProducts testHairProducts;

    @Test
    public void testSetSku(){
        HairProducts hairProducts = new HairProducts();
        Integer expected = 123456;
        //given
        hairProducts.setSku(expected);
        Integer actual = hairProducts.getSku();
        //when
        Assertions.assertEquals(expected, actual);
        //then
    }

    @Test
    public void testSetName(){
        HairProducts hairProducts = new HairProducts();
        String expected = "Clean & Pure Nourishing Detox Shampoo";
        hairProducts.setName(expected);
        String actual = hairProducts.getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetBrand(){
        HairProducts hairProducts = new HairProducts();
        String expected = "Nexxus";
        hairProducts.setBrand(expected);
        String actual = hairProducts.getBrand();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetUse(){
        HairProducts hairProducts = new HairProducts();
        String expected = "Shampoo";
        hairProducts.setUse(expected);
        String actual = hairProducts.getUse();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetTypeOfHair(){
        HairProducts hairProducts = new HairProducts();
        String expected = "1A, 1B, 1C, 2A, 2B, 2C,";
        hairProducts.setTypeOfHair(expected);
        String actual = hairProducts.getTypeOfHair();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetQty(){
        HairProducts hairProducts = new HairProducts();
        Integer expected = 100;
        hairProducts.setQty(expected);
        Integer actual = hairProducts.getQty();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetPrice(){
        HairProducts hairProducts = new HairProducts();
        Double expected = 13.99;
        hairProducts.setPrice(expected);
        Double actual = hairProducts.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testConstructor(){
        int expectedSku = 123456;
        String expectedName = "Clean & Pure Nourishing Detox Shampoo";
        String expectedBrand = "Nexxus";
        String expectedUse = "Shampoo";
        String expectedTypeOfHair = "1A, 1B, 1C, 2A, 2B, 2c";
        int expectedQty = 100;
        double expectedPrice = 13.99;

        HairProducts testHairProducts = new HairProducts(expectedSku, expectedName,
                    expectedBrand, expectedUse, expectedTypeOfHair,
                    expectedQty, expectedPrice);

        Assertions.assertEquals(expectedSku, testHairProducts.getSku());
        Assertions.assertEquals(expectedName, testHairProducts.getName());
        Assertions.assertEquals(expectedBrand, testHairProducts.getBrand());
        Assertions.assertEquals(expectedUse, testHairProducts.getUse());
        Assertions.assertEquals(expectedTypeOfHair, testHairProducts.getTypeOfHair());
        Assertions.assertEquals(expectedQty, testHairProducts.getQty());
        Assertions.assertEquals(expectedPrice, testHairProducts.getPrice());

    }
}
