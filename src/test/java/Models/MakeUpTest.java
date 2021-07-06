package Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MakeUpTest {

    private MakeUp makeUp;

    @Test
    public void testConstructor(){
        int expectedSku = 654321;
        String expectedName = "Eaze Drop Blurring Skin Tint";
        String expectedBrand = "Fenty Beauty";
        String expectedType = "Foundation";
        String expectedSectionOfFace = "Whole face";
        int expectedQty = 100;
        double expectedPrice = 29.50;

        MakeUp testMakeUp = new MakeUp(expectedSku, expectedName, expectedBrand,
                expectedType, expectedSectionOfFace, expectedQty, expectedPrice);

        Assertions.assertEquals(expectedSku, testMakeUp.getSku());
        Assertions.assertEquals(expectedName, testMakeUp.getName());
        Assertions.assertEquals(expectedBrand, testMakeUp.getBrand());
        Assertions.assertEquals(expectedType, testMakeUp.getType());
        Assertions.assertEquals(expectedSectionOfFace, testMakeUp.getSectionOfFace());
        Assertions.assertEquals(expectedQty, testMakeUp.getQty());
        Assertions.assertEquals(expectedPrice, testMakeUp.getPrice());

    }

    @Test
    public void testSetSku(){
        MakeUp makeUp = new MakeUp();
        Integer expected = 654321;
        makeUp.setSku(expected);
        Integer actual = makeUp.getSku();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetName(){
        MakeUp makeUp = new MakeUp();
        String expected = "Eaze Drop Blurring Skin Tint";
        makeUp.setName(expected);
        String actual = makeUp.getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetBrand(){
        MakeUp makeUp = new MakeUp();
        String expected = "Fenty Beauty";
        makeUp.setBrand(expected);
        String actual = makeUp.getBrand();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetType(){
        MakeUp makeUp = new MakeUp();
        String expected = "Foundation";
        makeUp.setType(expected);
        String actual = makeUp.getType();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetSectionOfFace(){
        MakeUp makeUp = new MakeUp();
        String expected = "Whole face";
        makeUp.setSectionOfFace(expected);
        String actual= makeUp.getSectionOfFace();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetQty(){
        MakeUp makeUp = new MakeUp();
        Integer expected = 100;
        makeUp.setQty(expected);
        Integer actual = makeUp.getQty();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetPrice(){
        MakeUp makeUp = new MakeUp();
        Double expected = 29.50;
        makeUp.setPrice(expected);
        Double actual = makeUp.getPrice();
        Assertions.assertEquals(expected, actual);
    }
}
