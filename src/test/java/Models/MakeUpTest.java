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



}
