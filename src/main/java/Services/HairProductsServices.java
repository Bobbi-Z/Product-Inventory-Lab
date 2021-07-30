package Services;

import Models.HairProducts;
import Utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HairProductsServices {

    private static int nextSku = 1000;

    public static ArrayList<HairProducts> inventory = new ArrayList<>();

    public HairProducts create(String name, String brand, String use, String typesOfHair, int qty, double price) {
        HairProducts createdHairProducts = new HairProducts(nextSku++, name, brand, use, typesOfHair, qty, price);

        inventory.add(createdHairProducts);
        return createdHairProducts;
    }

    public HairProducts findHairProduct(int sku) {

        for (int index = 0; index < inventory.size(); index++) {
            if (inventory.get(index).getSku() == sku) {
                return inventory.get(index);

            }
        }
        return null;
    }

    public ArrayList<HairProducts> findAll() {
        return inventory;
    }

    public boolean delete(int sku) {
        for (HairProducts element : inventory) {
            if (element.getSku() == sku) {
                inventory.remove(element);
                return true;
            }
        }
        return false;
    }

    public static void csvHairFileSaver() throws IOException {

        String csvHFile = "/Users/bobbi/Desktop/HairProduct.csv";
        FileWriter writer = new FileWriter(csvHFile);
        //Create a FileWriter object and pass the location of the file to write to

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextSku))));
        //First we save the nextId value so it can be read back in we loading the data

        for (HairProducts hProd : inventory) {
            List<String> list = new ArrayList<>();
            //Create an ArrayList of string representations of the object data
            list.add(String.valueOf(hProd.getSku()));
            list.add(hProd.getName());
            list.add(hProd.getBrand());
            list.add(hProd.getUse());
            list.add(hProd.getTypeOfHair());
            list.add(String.valueOf(hProd.getQty()));
            list.add(String.valueOf(hProd.getPrice()));


            CSVUtils.writeLine(writer, list);
            //Use the CSVUtils.writeLine to save the data to file
        }

        writer.flush();
        writer.close();
        //Flush and close connection to the file
    }

    private void loadHData(){
        //Set up some values to be used later
        String csvHFile = "/Users/bobbi/Desktop/HairProduct.csv";
        String line = "";
        String csvSplitBy = ",";

        //We use a try with resources block to create a new BufferedReader
        // and catch any exceptions that can occur. If there are problems
        // retrieving the file, the catch block will handle the exception
        try(BufferedReader br = new BufferedReader(new FileReader(csvHFile))){
            nextSku = Integer.parseInt(br.readLine());
            //Begin setting the state of the service by reading in the
            // first line. If you remember the first line represents the
            // nextId value.

            while ((line = br.readLine()) != null){
            //split line with comma
            String [] hair = line.split(csvSplitBy);

            //For every line read in from the CSV file, the program with
            // split the string values by a ','. Then parsed into the
            // proper data type if necessary.
            int sku = Integer.parseInt(hair[0]);
            String name = hair[1];
            String brand = hair[2];
            String use = hair [3];
            String typeOfHair = hair [4];
            int qty = Integer.parseInt(hair[5]);
            double price = Double.parseDouble(hair[6]);

            //Finally create a new item using the CSV data to set the
            // initial state and add it to the inventory.

            inventory.add(new HairProducts(sku, name, brand, use, typeOfHair, qty, price));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}