package io;

import Models.HairProducts;
import Services.HairProductsServices;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

//this will initialize the logic and services, and start the program
public class App {

    private HairProductsServices hairProductsServices = new HairProductsServices();
    //service needed to manage inventory

    public static void main(String... args) {
        App application = new App();
        //Instantiate the application
        application.testInventory();
        application.init();
        //a method to initialize the application
    }
    public void testInventory(){
        hairProductsServices.create("Clean & Pure Nourishing Detox Shampoo", "Nexxus",
                "Shampoo", "Straight", 10, 26.99);
        hairProductsServices.create("Humectress Moisture Conditioner for Normal to Dry Hair",
                "Nexxus", "Conditioner", "Straight", 10, 26.99);
        hairProductsServices.create("Silk Express Miracle Silk Hair Mask", "It's A 10",
                "Mask", "Straight", 10, 36.99);
        hairProductsServices.create("Ghost Weightless Hair Oil", "Verb", "Style",
                "Straight", 10, 18.00);

    }

    public void init() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        Console.printWelcome();
        System.out.println("Press any number to go to the main menu");
        choice = input.nextInt();
        mainMenu();
    }
     public void mainMenu(){
        Scanner input = new Scanner(System.in);
         int choice = 0;
        Console.mainMenu();
        System.out.println("Please enter your choice: ");
        //input.nextLine();
        choice = input.nextInt();

        switch (choice) {
            case 1:
                choiceOne();
                break;
            case 2:
                choiceTwo();
                break;

        }
    }
    public void choiceOne(){
            Scanner scanOne = new Scanner(System.in);
            ArrayList<HairProducts> allHairProducts = hairProductsServices.findAll();
            if (hairProductsServices.inventory.isEmpty()) {
                System.out.println("There is no current inventory");
            } else {
                for (HairProducts element : allHairProducts) {
                    System.out.println("SKU: " + element.getSku() + " Name: " + element.getName() +
                            " Brand: " + element.getBrand() + " Use: " + element.getUse() +
                            " Hair Type: " + element.getTypeOfHair() + " Quantity: " + element.getQty() +
                            " Price: " + element.getPrice());
                }

            }
        System.out.println("Press any button to return to the main menu");
            scanOne.nextLine();
            mainMenu();
        }
    public void choiceTwo(){
        Scanner scanTwo = new Scanner(System.in);
                int sku = 0;
         Console.pickHairOrMake();
        System.out.println("Please choose ");
        int choiceHM = scanTwo.nextInt();
        if(choiceHM == 1) { //choosing hair
            System.out.println("Please enter sku: ");
            scanTwo.nextLine();
            sku = scanTwo.nextInt();
            HairProducts found = hairProductsServices.findHairProduct(sku);
            if (found == null) {
                System.out.println("This is not a valid sku");
            } else {
                System.out.println(found.toString());
            }
            choiceTwo();
        } //else for makeup & //else for exit
    }



         /*   case 3:
                String name = "";
                String brand = "";
                int useChoice = 0;
                String use = "";
                int hairTypeChoice = 0;
                String typeOfHair = "";
                Integer qty = 0;
                double price = 0;

                System.out.println("Please enter product name: ");
                name = input.next();
                System.out.println("Please enter product brand: ");
                brand = input.next();
                Console.productUse();
                System.out.println("Please select product use");
                useChoice = input.nextInt();
                String resultOfUseChoice = "";
                if (useChoice == 6) {
                    break;
                } else if (useChoice != 1 || useChoice != 2 || useChoice != 3 || useChoice != 4) {
                    System.out.println("That was not a valid selection");
                } else if (useChoice == 1) {
                    //resultOfUseChoice = Integer.toString(1);
                    resultOfUseChoice = "Shampoo";
                } else if (useChoice == 2) {
                    //resultOfUseChoice = Integer.toString(2);
                    resultOfUseChoice = "Conditioner";
                } else if (useChoice == 3) {
                    //resultOfUseChoice = Integer.toString(3);
                    resultOfUseChoice = "Mask";
                } else if (useChoice == 4) {
                    //resultOfUseChoice = Integer.toString(4);
                    resultOfUseChoice = "Style";
                }
                use  = resultOfUseChoice;
                Console.hairType();
                System.out.println("Please select the hair type this product is for");
                hairTypeChoice = input.nextInt();
                String resultOfTypeChoice = "";
                if (hairTypeChoice == 6) {
                    break;
                } else if (hairTypeChoice != 1 || hairTypeChoice != 2 || hairTypeChoice != 3 || hairTypeChoice != 4) {
                    System.out.println("That was not a valid selection");
                } else if (hairTypeChoice == 1) {
                   // resultOfTypeChoice = Integer.toString(1);
                    resultOfTypeChoice = "Straight | 1a-1c";
                } else if (hairTypeChoice == 2) {
                    //resultOfTypeChoice = Integer.toString(2);
                    resultOfTypeChoice = "Wavy | 2a-2c";
                } else if (hairTypeChoice == 3) {
                   // resultOfTypeChoice = Integer.toString(3);
                    resultOfTypeChoice = "Curley | 3a-3c";
                } else if (hairTypeChoice == 4) {
                    //resultOfTypeChoice = Integer.toString(4);
                    resultOfTypeChoice = "Coily | 4a-4c";
                }
                typeOfHair = resultOfTypeChoice;
                System.out.println("Please enter the quantity: ");
                qty = input.nextInt();
                System.out.println("Please enter the price in format example 0.00: ");
                price = input.nextDouble();

                hairProductsServices.create(name, brand, use,typeOfHair, qty, price);
                System.out.println("The product you have entered is: " +
                        hairProductsServices.inventory.get(hairProductsServices.inventory.size()));
                break;

            case 4:
                Console.changeQtyOrPrice();
                input.nextLine();
                System.out.println("Please enter sku: ");
                sku = input.nextInt();


            case 5:
                 System.out.println("Please enter sku: ");
                 sku = input.nextInt();

                 hairProductsServices.delete(sku);
                 if (hairProductsServices.findHairProduct(sku) == null) {
                     System.out.println("This is not a valid sku");
                 } else {
                     System.out.println(sku + " has been deleted.");
                 }
                 break;

            case 6:
                System.out.println("Returning to Welcome Screen");
                System.exit(6);

            default:
                System.out.println("Your input is invalid");
                break;
        }


    }*/

    }
