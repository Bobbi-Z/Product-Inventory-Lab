package Services;

import Models.MakeUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MakeUpServicesTest {

    @Test
    public void createTest(){

        String expectedName = "Eaze Drop Blurring Skin Tint";
        String expectedBrand = "Fenty Beauty";
        String expectedType = "Foundation";
        String expectedSectionOfFace = "Whole face";
        int expectedQty = 100;
        double expectedPrice = 29.50;

       MakeUpServices makeUpServices = new MakeUpServices();
        MakeUp testMakeUp = makeUpServices.create(expectedName,
                expectedBrand, expectedType, expectedSectionOfFace,
                expectedQty, expectedPrice);

        // (3)
        String actualName = testMakeUp.getName();
        String actualBrand = testMakeUp.getBrand();
        String actualType = testMakeUp.getType();
        String actualSectionOfFace = testMakeUp.getColor();
        int actualQty = testMakeUp.getQty();
        double actualPrice = testMakeUp.getPrice();


        // (4)
        Assertions.assertEquals(Integer.class.getName(), Integer.class.getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedType, actualType);
        Assertions.assertEquals(expectedSectionOfFace, actualSectionOfFace);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void testFindMakeUp(){

        String expectedName = "Eaze Drop Blurring Skin Tint";
        String expectedBrand = "Fenty Beauty";
        String expectedType = "Foundation";
        String expectedSectionOfFace = "Whole face";
        int expectedQty = 100;
        double expectedPrice = 29.50;

       MakeUpServices testMakeUpServices = new MakeUpServices();
        MakeUp testMU = testMakeUpServices.create(expectedName,
                expectedBrand, expectedType, expectedSectionOfFace, expectedQty, expectedPrice);

        MakeUp actual = testMakeUpServices.findMakeUp(2001);

        Assertions.assertEquals(actual, testMU);

    }

    @Test
    public void testFindAll(){

        String expectedName = "Eaze Drop Blurring Skin Tint";
        String expectedBrand = "Fenty Beauty";
        String expectedType = "Foundation";
        String expectedSectionOfFace = "Whole face";
        int expectedQty = 100;
        double expectedPrice = 29.50;

       MakeUpServices testMakeUpServices = new MakeUpServices();
        MakeUp testMakeU = testMakeUpServices.create(expectedName,
                expectedBrand, expectedType, expectedSectionOfFace, expectedQty, expectedPrice);

        ArrayList<MakeUp> makeUpArray = new ArrayList<>();
        makeUpArray.add(testMakeU);

        ArrayList<MakeUp> expected = testMakeUpServices.findAll();

        Assertions.assertEquals(makeUpArray, expected);
    }
    @Test
    public void testDelete(){
        String expectedName = "Eaze Drop Blurring Skin Tint";
        String expectedBrand = "Fenty Beauty";
        String expectedType = "Foundation";
        String expectedSectionOfFace = "Whole face";
        int expectedQty = 100;
        double expectedPrice = 29.50;

        MakeUpServices testMakeUpServices = new MakeUpServices();
        MakeUp testMUP2 = testMakeUpServices.create(expectedName,
                expectedBrand, expectedType, expectedSectionOfFace, expectedQty, expectedPrice);

        boolean actual = testMakeUpServices.delete(testMUP2.getSku());

        Assertions.assertTrue(actual);

    }

}
