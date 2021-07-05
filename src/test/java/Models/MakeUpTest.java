package Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MakeUpTest {

    private MakeUp makeUp;

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
    public void testQty(){
        MakeUp makeUp = new MakeUp();
        Integer expected = 100;
        makeUp.setQty(expected);
        String actual = makeUp.getQty();
        Assertions.assertEquals(expected, actual);
    }


}
