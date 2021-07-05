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
    public void testUse(){
        HairProducts hairProducts = new HairProducts();
        String expected = "Shampoo";
        hairProducts.setUse(expected);
        String actual = hairProducts.getUse();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTypeOfHair(){
        HairProducts hairProducts = new HairProducts();
        String expected = "1A, 1B, 1C, 2A, 2B, 2C,";
        hairProducts.setTypeOfHair(expected);
        String actual = hairProducts.getTypeOfHair();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testQty(){
        HairProducts hairProducts = new HairProducts();
        Integer expected = 100;
        hairProducts.setQty(expected);
        Integer actual = hairProducts.getQty();
        Assertions.assertEquals(expected, actual);
    }
}
