package io;

import Models.HairProducts;
import Models.MakeUp;
import Services.HairProductsServices;
import Services.MakeUpServices;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static io.Console.*;

//this will initialize the logic and services, and start the program
public class App {

    private HairProductsServices hairProductsServices = new HairProductsServices();
    private MakeUpServices makeUpServices = new MakeUpServices();
    //service needed to manage inventory
    public Scanner input = new Scanner(System.in);
    public int numChoice = 0;
    public String clientInput = "";

    public static void main(String... args) {
        App application = new App();
        //Instantiate the application
        application.testInventory();
        application.init();
        //a method to initialize the application
    }
    public void testInventory(){
        hairProductsServices.create("Clean & Pure Nourishing Detox Shampoo", "Nexxus",
                "Shampoo", "Straight | 1a-1c", 10, 26.99);
        hairProductsServices.create("Humectress Moisture Conditioner for Normal to Dry Hair",
                "Nexxus", "Conditioner", "Straight | 1a-1c", 10, 26.99);
        hairProductsServices.create("Silk Express Miracle Silk Hair Mask", "It's A 10",
                "Mask", "Straight | 1a-1c", 10, 36.99);
        hairProductsServices.create("Ghost Weightless Hair Oil", "Verb", "Style",
                "Straight | 1a-1c", 10, 18.00);
        makeUpServices.create("Complexion Rescue Tinted Hydrating Gel Cream Broad Spectrum SPF 30",
                "bareMinerals", "foundation", "Opal 01", 10, 33.00);
        makeUpServices.create("Better Than Sex Volumizing Mascara", "Too Faced", "Mascara",
                "Black", 10, 26.00);
        makeUpServices.create("24/7 Glide-On Waterproof Eyeliner Pencil", "Urban Decay",
                "Eyeliner", "Yeyo (metallic white shimmer)", 10, 22.00 );
        makeUpServices.create("Lip Glowy Balm", "Laneige", "Lip gloss", "Berry",
                10, 17.00);
        makeUpServices.create("Brilliant Eye Brightener", "Thrive", "Highlighter",
                "Stella (Champagne Shimmer)", 10, 24.00);
    }

    public void init() {
        Console.printWelcome();
        welcome();
    }

    public void welcome(){
        System.out.println("Enter 'm' to go to the main menu");
        switch (stringInput()){
            case "m":
            mainMenuChoices();
            break;
            default:
            notAValidChoice();
            welcome();
        }
    }

    public int numberInput(){
       // input.nextLine();
           numChoice = input.nextInt();
           return numChoice;
    }

    public String stringInput(){
      //  input.nextLine();
        clientInput = input.next();
        return clientInput;

    }
    public String returnToCurrentMenu() {
        System.out.println("Enter 'r' to return");
        switch (stringInput()) {
            case "r":
            return "r";
            default:
            notAValidChoice();
            returnToCurrentMenu();
        }
        return stringInput();
    }
     public void mainMenuChoices(){
        Console.mainMenu();
        System.out.println("Please enter your choice: ");
        switch (numberInput()) {
            case 1:
                allProductsList();
                break;
            case 2:
                searchBySku();
                break;
            case 3:
                addNewProduct();
                break;
            case 4:
                updateExisting();
                break;
            case 5:
               deleteProduct();
                break;
            case 6:
                exit();
                break;
            default:
                notAValidChoice();
                mainMenuChoices();

        }

    }

    public String notAValidChoice(){
        System.out.println("That is not a valid choice");
        return  returnToCurrentMenu();
    }

    public int pickHairOrMakeup() {
        pickHairOrMake();
        switch (numberInput()) {
            case 1: //hair products chosen
                return 1;
            case 2:
                return 2;
            case 3:
                mainMenuChoices();
                break;
            default:
                notAValidChoice();
                pickHairOrMake();
        }
        return numberInput();
    }

    public void findAllHair(){
        ArrayList<HairProducts> allHairProducts = hairProductsServices.findAll();
        if (hairProductsServices.inventory.isEmpty()) {
            notAValidChoice();
            mainMenuChoices();
        }
        for (HairProducts element : allHairProducts) {
            System.out.println(element.toString());
        }
    }

    public void findAllMU(){
        ArrayList<MakeUp> allMakeup = makeUpServices.findAll();
        if (makeUpServices.inventory.isEmpty()) {
            notAValidChoice();
            mainMenuChoices();
        }
        for (MakeUp element : allMakeup) {
            System.out.println(element.toString());

        }

    }

    public void allProductsList() {
        switch (pickHairOrMakeup()){
            case 1:
                findAllHair();
                break;
            case 2:
                findAllMU();
                break;
            case 3:
                mainMenuChoices();
                break;
            default:
                notAValidChoice();
                allProductsList();
        }
        returnToCurrentMenu();
        mainMenuChoices();
            }

   public HairProducts findHairBySku(){
       int sku = 0;
       System.out.println("Please enter sku: ");
       sku = numberInput();
       HairProducts foundHairProduct = hairProductsServices.findHairProduct(sku);
       if (foundHairProduct == null) {
           notAValidChoice();
           mainMenuChoices();
       }
       return foundHairProduct;
    }

   public MakeUp findMakeupBySku(){
        int sku = 0;
       System.out.println("Please enter sku: ");
       sku = numberInput();
       MakeUp foundMakeUpProduct = makeUpServices.findMakeUp(sku);
       if (foundMakeUpProduct == null) {
           notAValidChoice();
           mainMenuChoices();
       }
        return foundMakeUpProduct;
   }

    public void searchBySku() {
        switch (pickHairOrMakeup()) {
            case 1:
                System.out.println(findHairBySku());
                break;
            case 2:
                System.out.println(findMakeupBySku());
                break;
            case 3:
                mainMenuChoices();
                break;
            default:
                notAValidChoice();
                searchBySku();
        }
        returnToCurrentMenu();
        searchBySku();
    }

    public String hairProductUse(){
        Console.productUse();
        String resultOfUseChoice = "";
        switch (numberInput()){
            case 1:
                resultOfUseChoice = "Shampoo";
                break;
            case 2:
                resultOfUseChoice = "Conditioner";
                break;
            case 3:
                resultOfUseChoice = "Mask";
                break;
            case 4:
                resultOfUseChoice = "Style";
                break;
            case 5:
                addNewProduct();
                break;
            default:
                notAValidChoice();
                addNewProduct();
                break;

        }
     return  resultOfUseChoice;
    }

    public String hairTypeSelection(){
        Console.hairType();
        String resultOfTypeChoice = "";

        switch (numberInput()) {
            case 1:
                resultOfTypeChoice = "Straight | 1a-1c";
                break;
            case 2:
                resultOfTypeChoice = "Wavy | 2a-2c";
                break;
            case 3:
                resultOfTypeChoice = "Curly | 3a-3c";
                break;
            case 4:
                resultOfTypeChoice = "Coily | 4a-4c";
                break;
            case 5:
                addNewProduct();
                break;
            default:
                notAValidChoice();
                addNewProduct();
                break;
        }
        return resultOfTypeChoice;
    }


    public void addHair(){
        String name = "";
        String brand = "";
        String use = "";
        String typeOfHair = "";
        Integer qty = 0;
        double price = 0;

        System.out.println("Please fill in the required information.");
        System.out.println("Product name: ");
        name = stringInput();

        System.out.println("Brand of product: ");
        brand = stringInput();

        use = hairProductUse();

        typeOfHair = hairTypeSelection();


        System.out.println("Please enter the quantity: ");
        qty = numberInput();

        System.out.println("Please enter the price in format example 0.00: ");
        input.nextLine();
        price = input.nextDouble();


        HairProducts newlyCreated = hairProductsServices.create(name, brand, use, typeOfHair,
                qty, price);
        System.out.println("The product you have created is: \n *** " + newlyCreated + " ***");
    }

    public String makeupTypeSelection(){
        Console.makeUpType();
        System.out.println("Please select the product type from the following options: ");
        String resultOfMakeupTypeChoice = "";

            switch (numberInput()) {
                case 1:
                    resultOfMakeupTypeChoice = "Foundation";
                    break;
                case 2:
                    resultOfMakeupTypeChoice = "Mascara";
                    break;
                case 3:
                    resultOfMakeupTypeChoice = "Eyeliner";
                    break;
                case 4:
                    resultOfMakeupTypeChoice = "Highlighter";
                    break;
                case 5:
                    resultOfMakeupTypeChoice = "Lip Gloss";
                case 6:
                    addNewProduct();
                    break;
                default:
                    notAValidChoice();
                    addNewProduct();
                    break;
            }
        return resultOfMakeupTypeChoice;
        }



    public void addMakeup(){
        String name = "";
        String brand = "";
        String type = "";
        String color = "";
        Integer qty = 0;
        double price = 0;

        System.out.println("Please fill in the required information.");
        System.out.println("Product name: ");
        name = stringInput();

        System.out.println("Brand of product: ");
        brand = stringInput();

        type = makeupTypeSelection();

        System.out.println("Color of product: ");
        color = stringInput();

        System.out.println("Please enter the quantity: ");
        qty = numberInput();

        System.out.println("Please enter the price in format example 0.00: ");
        input.nextLine();
        price = input.nextDouble();

        MakeUp newlyCreated = makeUpServices.create(name, brand, type, color, qty, price);
        System.out.println("The product you have created is: \n *** " + newlyCreated + " ***");
    }


    public void addNewProduct() {
        switch (pickHairOrMakeup()){
            case 1:
            addHair();
            break;
            case 2:
            addMakeup();
            break;
            case 3:
            addNewProduct();
            break;
            default:
                notAValidChoice();
                addNewProduct();
        }
        returnToCurrentMenu();
        addNewProduct();
    }

   public String isThisCorrect(){
        correctYesOrNo();
       System.out.println("Is this the correct product you want to update?");
       switch (stringInput()){
           case "n":
               mainMenuChoices();
               break;
           case "y":
               break;
           default:
               notAValidChoice();
               isThisCorrect();
       }
       return "y";
   }

    public int changePriceOrQty() {
        changeQtyOrPrice();
        System.out.println("Please make your selection");
        return numberInput();
    }

    public HairProducts updateHairPQty() {
        findAllHair();
        System.out.println("Please choose the item you want to update by SKU: ");
        HairProducts foundHairP = findHairBySku();
        System.out.println(foundHairP);
        isThisCorrect();
        System.out.println("Please enter in the new quantity: ");
        foundHairP.setQty(numberInput());
        System.out.println("The updated product is: \n" + foundHairP);
        return foundHairP;
    }

    public HairProducts updateHairPPrice() {
        findAllHair();
        System.out.println("Please choose the item you want to update by SKU: ");
        HairProducts foundHairP = findHairBySku();
        System.out.println(foundHairP);
        isThisCorrect();
        System.out.println("Please enter in the new price formatted as 0.00: ");
        foundHairP.setPrice(input.nextDouble());
        System.out.println("The updated product is \n" + foundHairP);
        return foundHairP;

    }
    public void updateHairP() {
        switch (changePriceOrQty()) {
            case 1:
                updateHairPQty();
                break;
            case 2:
                updateHairPPrice();
                break;
            default:
                notAValidChoice();
               updateHairP();
        }
        updateExisting();
    }

        public MakeUp updateMUQty() {
            findAllMU();
            System.out.println("Please choose the item you want to update by SKU: ");
           MakeUp foundMU = findMakeupBySku();
            System.out.println(foundMU);
            isThisCorrect();
            System.out.println("Please enter in the new quantity: ");
            foundMU.setQty(numberInput());
            System.out.println("The updated product is: \n" + foundMU);
            return foundMU;
        }

        public MakeUp updateMUPrice(){
            findAllMU();
            System.out.println("Please choose the item you want to update by SKU: ");
            MakeUp foundMU = findMakeupBySku();
            System.out.println(foundMU);
            isThisCorrect();
            System.out.println("Please enter in the new price formatted as 0.00: ");
            foundMU.setPrice(input.nextDouble());
            System.out.println("The updated product is \n" + foundMU);
            return foundMU;
        }

        public void updateMU() {
            switch (changePriceOrQty()) {
                case 1:
                    updateMUQty();
                    break;
                case 2:
                    updateMUPrice();
                    break;
                default:
                    notAValidChoice();
                    updateMU();
            }
        updateExisting();
        }


    public void updateExisting(){
        switch (pickHairOrMakeup()){
            case 1:
                updateHairP();
                break;
            case 2:
                updateMU();
                break;
            default:
                notAValidChoice();
               updateExisting();
            }
            returnToCurrentMenu();
        mainMenuChoices();
    }

    public void deleteHair() {
        findAllHair();
        System.out.println("Please choose the item you want to delete by SKU: ");
        HairProducts foundHairP = findHairBySku();
        System.out.println(foundHairP);
        isThisCorrect();
        System.out.println(foundHairP + "\n has been deleted");
        int sku = foundHairP.getSku();
        foundHairP.delete(sku);
    }

    public void deleteMakeup() {
        findAllMU();
        System.out.println("Please choose the item you want to delete by SKU: ");
        MakeUp foundMU = findMakeupBySku();
        System.out.println(foundMU);
        isThisCorrect();
        System.out.println(foundMU + "\n has been deleted");
        int sku = foundMU.getSku();
        foundMU.delete(sku);


    }

    public void deleteProduct(){
       int sku = 0;
       switch (pickHairOrMakeup()) {
           case 1:
               deleteHair();
               break;
           case 2:
                deleteMakeup();
                break;
           case 3:
               mainMenuChoices();
               break;
           default:
               notAValidChoice();
               deleteProduct();
           }
        returnToCurrentMenu();
        mainMenuChoices();
       }


    public void exit(){
        System.out.println("GoodBye!");
        System.exit(0);
        }
}
