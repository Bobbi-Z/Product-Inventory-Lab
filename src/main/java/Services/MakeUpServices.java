package Services;

import Models.MakeUp;
import Utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeUpServices {

    private static int nextSku = 2000;

    public static ArrayList<MakeUp> inventory = new ArrayList<>();

    public MakeUp create(String name, String brand, String type,
                         String color, int qty, double price) {

        MakeUp createdMakeUp = new MakeUp(nextSku++, name, brand,
                type, color, qty, price);

        inventory.add(createdMakeUp);
        return createdMakeUp;

    }


    public MakeUp findMakeUp(int sku) {
        for (MakeUp makeUp : inventory) {
            if (makeUp.getSku() == sku) {
                return makeUp;

            }
        }
        return null;
    }

    public static ArrayList<MakeUp> findAll() {
        return inventory;
    }

    public boolean delete(int sku) {
        for (int index = 0; index < inventory.size(); index++) {
            if (inventory.get(index).getSku() == sku) {
                inventory.remove(inventory.get(index));
                return true;
            }
        }
        return false;
    }
    public static void csvMakeUpFileSaver() throws IOException {

       // String csvMFile = "MacHD/Users/bobbi/Dev/Product-Inventory-Lab/MakeUp.csv";
        FileWriter writer = new FileWriter("MakeUp.csv");
        //Create a FileWriter object and pass the location of the file to write to

        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextSku))));
        //First we save the nextId value, so it can be read back in when we're loading the data

        for (MakeUp mProd : inventory) {
            List<String> list = new ArrayList<>();
            //Create an ArrayList of string representations of the object data
            list.add(String.valueOf(mProd.getSku()));
            list.add(mProd.getName());
            list.add(mProd.getBrand());
            list.add(mProd.getType());
            list.add(mProd.getColor());
            list.add(String.valueOf(mProd.getQty()));
            list.add(String.valueOf(mProd.getPrice()));


            CSVUtils.writeLine(writer, list);
            //Use the CSVUtils.writeLine to save the data to file
        }

        writer.flush();
        writer.close();
        //Flush and close connection to the file
    }
    public static void loadMUData(){
        //Set up some values to be used later
        //String csvMFile = "MacHD/Users/bobbi/Dev/Product-Inventory-Lab/MakeUp.csv";
        String line;
        String csvSplitBy = ",";

        //We use a try with resources block to create a new BufferedReader
        // and catch any exceptions that can occur. If there are problems
        // retrieving the file, the catch block will handle the exception
        try(BufferedReader br = new BufferedReader(new FileReader("MakeUp.csv"))){
            nextSku = Integer.parseInt(br.readLine());
            //Begin setting the state of the service by reading in the
            // first line. If you remember the first line represents the
            // nextId value.

            while ((line = br.readLine()) != null){
                //split line with comma
                String [] makeup = line.split(csvSplitBy);

                //For every line read in from the CSV file, the program with
                // split the string values by a ','. Then parsed into the
                // proper data type if necessary.
                int sku = Integer.parseInt(makeup[0]);
                String name = makeup[1];
                String brand = makeup[2];
                String type = makeup [3];
                String color = makeup [4];
                int qty = Integer.parseInt(makeup[5]);
                double price = Double.parseDouble(makeup[6]);

                //Finally, create a new item using the CSV data to set the
                // initial state and add it to the inventory.

                inventory.add(new MakeUp(sku, name, brand, type, color, qty, price));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}


