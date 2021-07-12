package io;

import Models.HairProducts;
import Models.MakeUp;
import Services.HairProductsServices;
import Services.MakeUpServices;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
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
                "bareMinerals", "Foundation", "Opal 01", 10, 33.00);
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
        System.out.println("Press any number to go to the main menu");
        numChoice = input.nextInt();
        mainMenu();
    }
    public void returnToCurrentMenu(){
        System.out.println("Enter any value to return");
        input.nextLine();
        clientInput = input.next();
    }
     public void mainMenu(){
        Console.mainMenu();
        System.out.println("Please enter your choice: ");
        input.nextLine();
        numChoice = input.nextInt();

        switch (numChoice) {
            case 1:
                choiceOne();
                break;
            case 2:
                choiceTwo();
                break;
            case 3:
                choiceThree();
                break;
            case 4:
                choiceFour();
                break;
            case 5:
               // choiceFive();
                break;

        }
    }

    public void choiceOne() {
        ArrayList<HairProducts> allHairProducts = hairProductsServices.findAll();
        ArrayList<MakeUp> allMakeup = makeUpServices.findAll();
        pickHairOrMake();
        System.out.println("Please choose ");
        numChoice = input.nextInt();
        if (numChoice == 1) {
            if (hairProductsServices.inventory.isEmpty()) {
                System.out.println("There is no current inventory");
                returnToCurrentMenu();
                choiceOne();
            } else {
                for (HairProducts element : allHairProducts) {
                    System.out.println(element.toString());
                }
                returnToCurrentMenu();
                choiceOne();
            }

        } else if (numChoice == 2) {

            if (makeUpServices.inventory.isEmpty()) {
                System.out.println("There is no current inventory");
                returnToCurrentMenu();
                choiceOne();
            } else {
                for (MakeUp element : allMakeup) {
                    System.out.println(element.toString());
                }
                returnToCurrentMenu();
                choiceOne();
            }

            }else{
            mainMenu();
        }
    }

    public void choiceTwo(){
        pickHairOrMake();
        System.out.println("Please choose ");
        numChoice = input.nextInt();
        int sku = 0;

        if(numChoice == 1) { //choosing hair
            System.out.println("Please enter sku: ");
            input.nextLine();
            sku = input.nextInt();
            HairProducts found = hairProductsServices.findHairProduct(sku);
            if (found == null) {
                System.out.println("This is not a valid sku");
                returnToCurrentMenu();
                choiceTwo();
            } else {
                System.out.println(found.toString());
                returnToCurrentMenu();
                choiceTwo();
            }
        } else if (numChoice == 2){
            System.out.println("Please enter sku: ");
            input.nextLine();
            sku = input.nextInt();
            MakeUp found = makeUpServices.findMakeUp(sku);
            if (found == null){
                System.out.println("This is not a valid sku");
                returnToCurrentMenu();
                choiceTwo();
            }else {
                System.out.println(found.toString());
                returnToCurrentMenu();
                choiceTwo();
            }

        } else {
            mainMenu();
        }
    }
    public void choiceThree() {
        pickHairOrMake();
        System.out.println("Choose the category of product");
        numChoice = input.nextInt();

        if (numChoice == 1) {
            String name = "";
            String brand = "";
            int useChoice = 0;
            String use = "";
            int hairTypeChoice = 0;
            String typeOfHair = "";
            Integer qty = 0;
            double price = 0;

            System.out.println("Please fill in the required information.");
            System.out.println("Product name: ");
            input.nextLine();
            name = input.next();

            System.out.println("Brand of product: ");
            input.nextLine();
            name = input.next();

            Console.productUse();
            System.out.println("Please select product use from the following options: ");
            input.nextLine();
            useChoice = input.nextInt();
            String resultOfUseChoice = "";
            if (useChoice == 5) {
                choiceThree();
            } else if (useChoice >= 6) {
                System.out.println("That was not a valid selection");
                returnToCurrentMenu();
                choiceThree();
                switch (useChoice) {
                    case 1:
                        resultOfUseChoice = Integer.toString(1);
                        resultOfUseChoice = "Shampoo";
                        break;
                    case 2:
                        resultOfUseChoice = Integer.toString(2);
                        resultOfUseChoice = "Conditioner";
                        break;
                    case 3:
                        resultOfUseChoice = Integer.toString(3);
                        resultOfUseChoice = "Mask";
                        break;
                    case 4:
                        resultOfUseChoice = Integer.toString(4);
                        resultOfUseChoice = "Style";
                        break;
                }
                use = resultOfUseChoice;
            }

            Console.hairType();
            System.out.println("Please select hair type this product is for from the following options: ");
            input.nextLine();
            hairTypeChoice = input.nextInt();
            String resultOfTypeChoice = "";
            if (hairTypeChoice == 5) {
                choiceThree();
            } else if (hairTypeChoice >= 6) {
                System.out.println("That was not a valid selection");
                returnToCurrentMenu();
                choiceThree();
            }
            switch (hairTypeChoice) {
                case 1:
                    resultOfTypeChoice = Integer.toString(1);
                    resultOfTypeChoice = "Straight | 1a-1c";
                    break;
                case 2:
                    resultOfTypeChoice = Integer.toString(2);
                    resultOfTypeChoice = "Wavy | 2a-2c";
                    break;
                case 3:
                    resultOfTypeChoice = Integer.toString(3);
                    resultOfTypeChoice = "Curley | 3a-3c";
                    break;
                case 4:
                    resultOfTypeChoice = Integer.toString(4);
                    resultOfTypeChoice = "Coily | 4a-4c";
                    break;
            }
            typeOfHair = resultOfTypeChoice;

            System.out.println("Please enter the quantity: ");
            input.nextLine();
            qty = input.nextInt();

            System.out.println("Please enter the price in format example 0.00: ");
            input.nextLine();
            price = input.nextDouble();


           HairProducts newlyCreated = hairProductsServices.create(name, brand, use, typeOfHair,
                   qty, price);
            System.out.println("The product you have created is: \n *** " + newlyCreated + " ***");
            returnToCurrentMenu();
            mainMenu();

        } else if (numChoice == 2) {

            String name = "";
            String brand = "";
            int makeupTypeChoice = 0;
            String type = "";
            String color = "";
            Integer qty = 0;
            double price = 0;

            System.out.println("Please fill in the required information.");
            System.out.println("Product name: ");
            input.nextLine();
            name = input.next();

            System.out.println("Brand of product: ");
            input.nextLine();
            brand = input.next();

            Console.makeUpType();
            System.out.println("Please select the product type from the following options: ");
            input.nextLine();
            makeupTypeChoice = input.nextInt();
            String resultOfMakeupTypeChoice = "";
            if (makeupTypeChoice == 6) {
                choiceThree();
            } else if (makeupTypeChoice >= 7) {
                System.out.println("That was not a valid selection");
                returnToCurrentMenu();
                choiceThree();
                switch (makeupTypeChoice) {
                    case 1:
                        resultOfMakeupTypeChoice = Integer.toString(1);
                        resultOfMakeupTypeChoice = "Foundation";
                        break;
                    case 2:
                        resultOfMakeupTypeChoice = Integer.toString(2);
                        resultOfMakeupTypeChoice = "Mascara";
                        break;
                    case 3:
                        resultOfMakeupTypeChoice = Integer.toString(3);
                        resultOfMakeupTypeChoice = "Eyeliner";
                        break;
                    case 4:
                        resultOfMakeupTypeChoice = Integer.toString(4);
                        resultOfMakeupTypeChoice = "Highlighter";
                        break;
                    case 5:
                        resultOfMakeupTypeChoice = Integer.toString(5);
                        resultOfMakeupTypeChoice = "Lip Gloss";
                }
                type = resultOfMakeupTypeChoice;
            }

            System.out.println("Color of product: ");
            input.nextLine();
            color = input.next();

            System.out.println("Please enter the quantity: ");
            input.nextLine();
            qty = input.nextInt();

            System.out.println("Please enter the price in format example 0.00: ");
            input.nextLine();
            price = input.nextDouble();

            MakeUp newlyCreated = makeUpServices.create(name, brand, type, color, qty, price);
            System.out.println("The product you have created is: \n *** " + newlyCreated + " ***");
            returnToCurrentMenu();
            mainMenu();

        } else {
            mainMenu();
        }
    }
    public void choiceFour(){
        ArrayList<HairProducts> allHairProducts = hairProductsServices.findAll();
        ArrayList<MakeUp> allMakeup = makeUpServices.findAll();
        pickHairOrMake();
        System.out.println("Please choose the type of product you want to update: ");
        input.nextLine();
        numChoice = input.nextInt();
        if (numChoice == 1) {
            if (hairProductsServices.inventory.isEmpty()) {
                System.out.println("There is no current inventory");
                returnToCurrentMenu();
                choiceFour();
            } else {
                for (HairProducts element : allHairProducts) {
                    System.out.println(element.toString());
                }
            }
            System.out.println("Please choose the item you want to update by SKU: ");
            input.nextLine();
            int sku = input.nextInt();
            HairProducts found = hairProductsServices.findHairProduct(sku);
            if (found == null) {
                System.out.println("This is not a valid sku");
                returnToCurrentMenu();
                choiceFour();
            } else {
                correctYesOrNo();
                System.out.println(found.toString());
                System.out.println("Is this the correct product you want to up date?");
                input.nextLine();
                clientInput = input.next();
                if (clientInput == "n"){
                    choiceFour();
                }
                changeQtyOrPrice();
                System.out.println("Please make your selection");
                input.nextLine();
                numChoice = input.nextInt();
                switch (numChoice){
                    case 1:
                        System.out.println("Please enter in the new quantity: ");
                        input.nextLine();
                        int newQty = input.nextInt();
                        HairProducts updatedQty = found.updateQty(sku, newQty);
                        System.out.println("The updated product is: \n" + updatedQty);
                        returnToCurrentMenu();
                        mainMenu();
                    case 2:
                        System.out.println("Please enter in the new price formatted as 0.00: ");
                        input.nextLine();
                        double newPrice = input.nextDouble();
                        HairProducts updatedPrice = found.updatePrice(sku, newPrice);
                        System.out.println("The updated product is \n" + updatedPrice.toString());
                        returnToCurrentMenu();
                        mainMenu();
                }
            }




    }
    //public void choiceFive(){

    }



       /*     case 4:
                Console.changeQtyOrPrice();
                input.nextLine();
                System.out.println("Please enter sku: ");
                sku = input.nextInt();




            case 6:
                System.out.println("Returning to Welcome Screen");
                System.exit(6);

            default:
                System.out.println("Your input is invalid");
                break;
        }


    }*/

    }
