package io;

import Models.HairProducts;
import Services.HairProductsServices;

import java.util.Scanner;

//this will initialize the logic and services, and start the program
public class App {

    private HairProductsServices hairProductsServices = new HairProductsServices();
    //service needed to manage inventory

    public static  void main(String...args){
        App application = new App();
        //Instantiate the application
        application.init();
        //a method to initialize the application
    }

    public void init(){
        Scanner input = new Scanner(System.in);
        boolean mainMenu = true;
        int choice = 0;
        do{ Console.printWelcome();
            Console.mainMenu();
            System.out.println("Please enter your choice: ");
            choice = input.nextInt();
        }
        while (choice < 7);

        switch (choice) {

            case 1:
                hairProductsServices.findAll();
                if (hairProductsServices.inventory.isEmpty()) {
                    System.out.println("There is no current inventory");
                } else {
                    System.out.println(hairProductsServices.inventory);
                }
                break;

            case 2:
                int sku = 0;
                System.out.println("Please enter sku: ");
                sku = input.nextInt();

                hairProductsServices.findHairProduct(sku);
                if (hairProductsServices.findHairProduct(sku) == null) {
                    System.out.println("This is not a valid sku");
                } else {
                    System.out.println(hairProductsServices.inventory.get(sku));
                }
                break;

            case 3:
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

            case 4: //Should be update product - couldn't figure it out
                System.out.println("Please enter sku: ");
                sku = input.nextInt();

                hairProductsServices.delete(sku);
                if (hairProductsServices.findHairProduct(sku) == null) {
                    System.out.println("This is not a valid sku");
                } else {
                    System.out.println(sku + " has been deleted.");
                }
                break;

       //   case 5:

            case 5:
                System.out.println("Returning to Welcome Screen");
                System.exit(6);

            default:
                System.out.println("Your input is invalid");
                break;
        }


    }

}
