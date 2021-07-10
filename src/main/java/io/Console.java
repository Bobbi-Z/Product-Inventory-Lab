package io;
//this is the class responsible for use input and output
public class Console {
    public static void printWelcome(){
        System.out.println(""+
                "******************************************************" +
                "***              Welcome and Bienvenue             ***" +
                "***                       to                       ***" +
                "***               B's Inventory Manager            ***" +
                "******************************************************");
    }
    public static void mainMenu(){
        System.out.println(""+
                "******************************************************" +
                "***                    Main Menu                   ***" +
                "***                                                ***" +
                "***    1. Get complete inventory sorted by sku     ***" +
                "***    2. Search for a specific product by sku     ***" +
                "***    3. Create new product                       ***" +
                "***    4. Update existing product                  ***" +
                "***    5. Delete product                           ***" +
                "***    6. Exit                                     ***" +
                "******************************************************");
    }

    public static void productUse(){
        System.out.println(""+
                "******************************************************" +
                "***               Product Use Choices              ***" +
                "***                                                ***" +
                "***    1. Shampoo                                  ***" +
                "***    2. Conditioner                              ***" +
                "***    3. Mask                                     ***" +
                "***    4. Style                                    ***" +
                "***    5. Exit                                     ***" +
                "******************************************************");

    }

    public static void hairType() {
        System.out.println(""+
                "******************************************************" +
                "***                Hair Type Choices               ***" +
                "***                                                ***" +
                "***    1. Straight | 1a-1c                         ***" +
                "***    2. Wavy     | 2a-2c                         ***" +
                "***    3. Curly    | 3a-3c                         ***" +
                "***    4. Coily    | 4a-4c                         ***" +
                "***    5. Exit                                     ***" +
                "******************************************************");
    }
}
