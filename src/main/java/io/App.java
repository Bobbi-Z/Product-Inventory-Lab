package io;

import Models.HairProducts;
import Models.MakeUp;
import Services.HairProductsServices;
import Services.MakeUpServices;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import static io.Console.*;

//this will initialize the logic and services, and start the program
public class App {


    //service needed to manage inventory
  //  public Scanner input = new Scanner(System.in);
    public int numChoice = 0;
    public String clientInput = "";

    public static void main(String... args) throws IOException {
        App application = new App();
        //Instantiate the application
       // application.testInventory();
        application.init();
        //a method to initialize the application
      //  CSVUtils.writeFiles();

    }
//    public void testInventory(){
//        hairProductsServices.create("Clean & Pure Nourishing Detox Shampoo", "Nexxus",
//                "Shampoo", "Straight | 1a-1c", 10, 26.99);
//        hairProductsServices.create("Humectress Moisture Conditioner for Normal to Dry Hair",
//                "Nexxus", "Conditioner", "Straight | 1a-1c", 10, 26.99);
//        hairProductsServices.create("Silk Express Miracle Silk Hair Mask", "It's A 10",
//                "Mask", "Straight | 1a-1c", 10, 36.99);
//        hairProductsServices.create("Ghost Weightless Hair Oil", "Verb", "Style",
//                "Straight | 1a-1c", 10, 18.00);
//        makeUpServices.create("Complexion Rescue Tinted Hydrating Gel Cream Broad Spectrum SPF 30",
//                "bareMinerals", "foundation", "Opal 01", 10, 33.00);
//        makeUpServices.create("Better Than Sex Volumizing Mascara", "Too Faced", "Mascara",
//                "Black", 10, 26.00);
//        makeUpServices.create("24/7 Glide-On Waterproof Eyeliner Pencil", "Urban Decay",
//                "Eyeliner", "Yeyo (metallic white shimmer)", 10, 22.00 );
//        makeUpServices.create("Lip Glowy Balm", "Laneige", "Lip gloss", "Berry",
//                10, 17.00);
//        makeUpServices.create("Brilliant Eye Brightener", "Thrive", "Highlighter",
//                "Stella (Champagne Shimmer)", 10, 24.00);
//    }

    public void init() throws IOException {
      MakeUpServices.readJSON();
      HairProductsServices.readJSON();
        // CSVUtils.loadFiles();
        Console.printWelcome();
        welcome();

    }

    public void welcome() throws IOException {
        System.out.println("Enter 'm' to go to the main menu");
        if (stringInput().equals("m")) {
            mainMenuChoices();
        }else{
            notAValidChoice();
            welcome();
        }
    }

    public int numberInput(){
         Scanner input = new Scanner(System.in);
           numChoice = input.nextInt();
           return numChoice;
    }

    public double priceInput(){
        Scanner input = new Scanner(System.in);
        double choice = input.nextDouble();
        return choice;
    }

    public String stringInput(){
        Scanner input = new Scanner(System.in);
        clientInput = input.nextLine();
        return clientInput;
    }

    public void returnToCurrentMenu() {
        System.out.println("Enter 'r' to return");
        if (stringInput().equals("r")) {
            return;
        }else{
            notAValidChoice();
            returnToCurrentMenu();
        }
        stringInput();
    }

     public void mainMenuChoices() throws IOException {
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

    public void notAValidChoice(){
        System.out.println("That is not a valid choice");
        returnToCurrentMenu();
    }

    public int pickHairOrMakeup() throws IOException {
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

    public void findAllHair() throws IOException {
        List<HairProducts> allHairProducts = HairProductsServices.findAll();
        if (HairProductsServices.inventory.isEmpty()) {
            notAValidChoice();
            mainMenuChoices();

        }
        for (HairProducts element : allHairProducts) {
            System.out.println(element.toString());
        }
    }

    public void findAllMU() throws IOException {
        List<MakeUp> allMakeup = MakeUpServices.findAll();
        if (MakeUpServices.inventory.isEmpty()) {
            notAValidChoice();
            mainMenuChoices();
        }
        for (MakeUp element : allMakeup) {
            System.out.println(element.toString());

        }

    }

    public void allProductsList() throws IOException {
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

   public HairProducts findHairBySku() throws IOException {
       int sku;
       System.out.println("Please enter sku: ");
       sku = numberInput();
       HairProducts foundHairProduct = HairProductsServices.findHairProduct(sku);
       if (foundHairProduct == null) {
           notAValidChoice();
           mainMenuChoices();
       }
       return foundHairProduct;
    }

   public MakeUp findMakeupBySku() throws IOException {
        int sku;
       System.out.println("Please enter sku: ");
       sku = numberInput();
       MakeUp foundMakeUpProduct = MakeUpServices.findMakeUp(sku);
       if (foundMakeUpProduct == null) {
           notAValidChoice();
           mainMenuChoices();
       }
        return foundMakeUpProduct;
   }

    public void searchBySku() throws IOException {
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

    public String hairProductUse() throws IOException {
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

    public String hairTypeSelection() throws IOException {
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

    public String addHairProdName() {
        System.out.println("Product name: ");
        return stringInput();
    }

    public String addHProdBrand(){
        System.out.println("Brand of product: ");
        return stringInput();
    }


    public void addHair() throws IOException {
        String name;
        String brand;
        String use;
        String typeOfHair;
        int qty;
        double price;

        System.out.println("Please fill in the required information.");

       name = addHairProdName();
        brand = addHProdBrand();
        use = hairProductUse();
        typeOfHair = hairTypeSelection();
        System.out.println("Please enter the quantity: ");
        qty = numberInput();
        System.out.println("Please enter the price in format example 0.00: ");

        price = priceInput();


        HairProducts newlyCreated = HairProductsServices.create(name, brand, use, typeOfHair,
                qty, price);
        System.out.println("The product you have created is: \n *** " + newlyCreated + " ***");
    }

    public String makeupTypeSelection() throws IOException {
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
                    break;
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



    public void addMakeup() throws IOException {
        String name;
        String brand;
        String type;
        String color;
        int qty;
        double price;

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
        price = priceInput();

        MakeUp newlyCreated = MakeUpServices.create(name, brand, type, color, qty, price);
        System.out.println("The product you have created is: \n *** " + newlyCreated + " ***");
    }


    public void addNewProduct() throws IOException {
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

   public void isThisCorrect() throws IOException {
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
   }

    public int changePriceOrQty() {
        changeQtyOrPrice();
        System.out.println("Please make your selection");
        return numberInput();
    }

    public void updateHairPQty() throws IOException {
        findAllHair();
        System.out.println("Please choose the item you want to update by SKU");
        HairProducts foundHairP = findHairBySku();
        System.out.println(foundHairP);
        isThisCorrect();
        System.out.println("Please enter in the new quantity: ");
        foundHairP.setQty(numberInput());
        System.out.println("The updated product is: \n" + foundHairP);
    }

    public void updateHairPPrice() throws IOException {
        findAllHair();
        System.out.println("Please choose the item you want to update by SKU");
        HairProducts foundHairP = findHairBySku();
        System.out.println(foundHairP);
        isThisCorrect();
        System.out.println("Please enter in the new price formatted as 0.00: ");
        foundHairP.setPrice(priceInput());
        System.out.println("The updated product is \n" + foundHairP);

    }

    public void updateHairP() throws IOException {
        switch (changePriceOrQty()) {
            case 1:
                updateHairPQty();
                break;
            case 2:
                updateHairPPrice();
                break;
            case 3:
                mainMenuChoices();
                break;
            default:
                notAValidChoice();
               updateHairP();
        }
        updateExisting();
    }

        public void updateMUQty() throws IOException {
            findAllMU();
            System.out.println("Please choose the item you want to update by SKU");
           MakeUp foundMU = findMakeupBySku();
            System.out.println(foundMU);
            isThisCorrect();
            System.out.println("Please enter in the new quantity: ");
            foundMU.setQty(numberInput());
            System.out.println("The updated product is: \n" + foundMU);
        }

        public void updateMUPrice() throws IOException {
            findAllMU();
            System.out.println("Please choose the item you want to update by SKU");
            MakeUp foundMU = findMakeupBySku();
            System.out.println(foundMU);
            isThisCorrect();
            System.out.println("Please enter in the new price formatted as 0.00: ");
            foundMU.setPrice(priceInput());
            System.out.println("The updated product is \n" + foundMU);
        }

        public void updateMU() throws IOException {
            switch (changePriceOrQty()) {
                case 1:
                    updateMUQty();
                    break;
                case 2:
                    updateMUPrice();
                    break;
                case 3:
                    mainMenuChoices();
                    break;
                default:
                    notAValidChoice();
                    updateMU();
            }
        updateExisting();
        }


    public void updateExisting() throws IOException {
        switch (pickHairOrMakeup()){
            case 1:
                updateHairP();
                break;
            case 2:
                updateMU();
                break;
            case 3:
                mainMenuChoices();
                break;
            default:
                notAValidChoice();
               updateExisting();
            }
            returnToCurrentMenu();
        mainMenuChoices();
    }

    public void deleteHair() throws IOException {
        findAllHair();
        System.out.println("Please choose the item you want to delete by SKU");
        HairProducts foundHairP = findHairBySku();
        System.out.println(foundHairP);
        isThisCorrect();
        System.out.println(foundHairP + "\n has been deleted");
        int sku = foundHairP.getSku();
        HairProductsServices.delete(sku);
    }

    public void deleteMakeup() throws IOException {
        findAllMU();
        System.out.println("Please choose the item you want to delete by SKU");
        MakeUp foundMU = findMakeupBySku();
        System.out.println(foundMU);
        isThisCorrect();
        System.out.println(foundMU + "\n has been deleted");
        int sku = foundMU.getSku();
        MakeUpServices.delete(sku);


    }

    public void deleteProduct() throws IOException {
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
