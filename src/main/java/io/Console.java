package io;
//this is the class responsible for use input and output
public class Console {
    public static void printWelcome(){
        System.out.println(""+
                "******************************************************\n" +
                "***              Welcome and Bienvenue             ***\n" +
                "***                       to                       ***\n" +
                "***               B's Inventory Manager            ***\n" +
                "******************************************************\n");
    }
    public static void mainMenu(){
        System.out.println(""+
                "******************************************************\n" +
                "***                    Main Menu                   ***\n" +
                "***                                                ***\n" +
                "***    1. Get complete inventory sorted by sku     ***\n" +
                "***    2. Search for a specific product by sku     ***\n" +
                "***    3. Create new product                       ***\n" +
                "***    4. Update existing product                  ***\n" +
                "***    5. Delete product                           ***\n" +
                "***    6. Exit                                     ***\n" +
                "******************************************************\n");
    }

    public static void productUse(){
        System.out.println(""+
                "******************************************************\n" +
                "***               Product Use Choices              ***\n" +
                "***                                                ***\n" +
                "***    1. Shampoo                                  ***\n" +
                "***    2. Conditioner                              ***\n" +
                "***    3. Mask                                     ***\n" +
                "***    4. Style                                    ***\n" +
                "***    5. Exit                                     ***\n" +
                "******************************************************\n");

    }

    public static void makeUpType(){
        System.out.println(""+
                "******************************************************\n" +
                "***              Product Type Choices              ***\n" +
                "***                                                ***\n" +
                "***    1. Foundation                               ***\n" +
                "***    2. Mascara                                  ***\n" +
                "***    3. Eyeliner                                 ***\n" +
                "***    4. Highlight                                ***\n" +
                "***    5. Lip gloss                                ***\n" +
                "***    6. Exit                                     ***\n" +
                "******************************************************\n");

    }

    public static void hairType() {
        System.out.println(""+
                "******************************************************\n" +
                "***                Hair Type Choices               ***\n" +
                "***                                                ***\n" +
                "***    1. Straight | 1a-1c                         ***\n" +
                "***    2. Wavy     | 2a-2c                         ***\n" +
                "***    3. Curly    | 3a-3c                         ***\n" +
                "***    4. Coily    | 4a-4c                         ***\n" +
                "***    5. Exit                                     ***\n" +
                "******************************************************\n");
    }


    public static void changeQtyOrPrice(){
        System.out.println(""+
                "******************************************************\n" +
                "***            What do you want to change?         ***\n" +
                "***                                                ***\n" +
                "***    1. Quantity                                 ***\n" +
                "***    2. Price                                    ***\n" +
                "***    3. Exit                                     ***\n" +
                "******************************************************\n");
    }
    public static void pickHairOrMake(){
        System.out.println(""+
                "******************************************************\n" +
                "***            Do you want Hair or MakeUp?         ***\n" +
                "***                                                ***\n" +
                "***    1. Hair Products                            ***\n" +
                "***    2. MakeUp Products                          ***\n" +
                "***    3. Exit                                     ***\n" +
                "******************************************************\n");
    }
    public static void correctYesOrNo(){
        System.out.println(""+
                "******************************************************\n" +
                "*** Confirm this is the product you want to change ***\n" +
                "***                                                ***\n" +
                "***             Type \"y\" for Yes                 ***\n" +
                "***             Type \"n\" for No                  ***\n" +
                "******************************************************\n");

    }

}
