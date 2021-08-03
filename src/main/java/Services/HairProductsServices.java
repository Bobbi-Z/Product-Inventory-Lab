package Services;

import Models.HairProducts;
import Utils.CSVUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HairProductsServices {

    private static int nextSku = 1000;

    public static List<HairProducts> inventory = new ArrayList<>();

    public static HairProducts create(String name, String brand, String use, String typesOfHair, int qty, double price) throws IOException {

        HairProducts createdHairProducts = new HairProducts(nextSku++, name, brand, use, typesOfHair, qty, price);
        inventory.add(createdHairProducts);
        writeJSON();
       // csvHairFileSaver();
        return createdHairProducts;
    }

    public static HairProducts findHairProduct(int sku)  {
        for (HairProducts hairProducts : inventory) {
            if (hairProducts.getSku() == sku) {
                return hairProducts;
            }
        }
        return null;
    }

    public static List<HairProducts> findAll() {
        return inventory;
    }

    public static boolean delete(int sku) {
        for (HairProducts element : inventory) {
            if (element.getSku() == sku) {
                inventory.remove(element);
                return true;
            }
        }
        return false;
    }

    public static void csvHairFileSaver() throws IOException {

      File csvHFile = new File ("/Users/bobbi/Dev/Product-Inventory-Lab/Hair.csv");
        FileWriter outPut = new FileWriter(csvHFile);
        CSVWriter writer = new CSVWriter(outPut, ',', CSVWriter.NO_QUOTE_CHARACTER, ' ', CSVWriter.DEFAULT_LINE_END);
        //Create a FileWriter object and pass the location of the file to write to

//        CSVUtils.writeLine(writer, new ArrayList<>(Arrays.asList(String.valueOf(nextSku))));
//        //First we save the nextId value, so it can be read back in when loading the data

        for (HairProducts createdHairProducts : inventory) {
            List<String> list = new ArrayList<>();
            //Create an ArrayList of string representations of the object data
            list.add(String.valueOf(createdHairProducts.getSku()));
            list.add(createdHairProducts.getName());
            list.add(createdHairProducts.getBrand());
            list.add(createdHairProducts.getUse());
            list.add(createdHairProducts.getTypeOfHair());
            list.add(String.valueOf(createdHairProducts.getQty()));
            list.add(String.valueOf(createdHairProducts.getPrice()));



            CSVUtils.writeLine(writer, list);
            //Use the CSVUtils.writeLine to save the data to file
        }

        writer.flush();
        writer.close();
        //Flush and close connection to the file
    }

    public static void loadHData(){
        //Set up some values to be used later
       String csvHFile = "/Users/bobbi/Dev/Product-Inventory-Lab/Hair.csv";
        String line;
        String csvSplitBy = ",";

        //We use a try with resources block to create a new BufferedReader
        // and catch any exceptions that can occur. If there are problems
        // retrieving the file, the catch block will handle the exception
        try(BufferedReader br = new BufferedReader(new FileReader(csvHFile))){
           // nextSku = Integer.parseInt(br.readLine());
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

            //Finally, create a new item using the CSV data to set the
            // initial state and add it to the inventory.


            inventory.add(new HairProducts(sku, name, brand, use, typeOfHair, qty, price));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readJSON()  {
        ObjectMapper hairObjectMapper = new ObjectMapper();
        try {
            inventory = hairObjectMapper.readValue(new File("hairproduct.json"), new TypeReference<List<HairProducts>>(){});
        } catch (IOException ignored) {

        }
    }

    public static void writeJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("hairproduct.json"), inventory);

    }

    public static void updateJSON(HairProducts h, int sku) throws IOException {
        sku = h.getSku();
        ObjectMapper old = new ObjectMapper();
        File importedJSON = new File("hairproduct.json");
       // ObjectReader findOld = new ObjectReader(old, importedJSON);



    }
}