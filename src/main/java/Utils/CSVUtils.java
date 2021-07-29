package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtils {
    private static final char DEFAULT_SEPARATOR = ',';
    //Create a final variable to hold the comma seperator
    // since we do not need this value to change

    public static void writeLine(Writer w, List<String> values)throws IOException {
        //To make this method reusable we will pass an Writer object representing the
        // file to write to. The next parameter is a list of String objects that will
        // represent the data of the object to write to CSV format. Now, wherever we want
        // to write some values to CSV we can call this method and pass the values to the
        // file and the data as a List
        boolean first = true;
        StringBuilder sb = new StringBuilder();

        for (String value : values){
            //Now use a StringBuilder to create the CSV string
            if (!first){
                sb.append(DEFAULT_SEPARATOR);
            }
            sb.append(value);
            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
        //Finally append the string to the CSV file
    }
    String csvFile = "/Users/batman/Desktop/Sneaker.csv";
    FileWriter writer = new FileWriter(csvFile);
    //Create a FileWriter object and pass the location of the file to write to

    CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));
    //First we save the nextId value so it can be read back in we loading the data

    for (Sneaker s : inventory){
        List<String> list = new ArrayList<>();
        //Create an ArrayList of string representations of the object data
        list.add(String.valueOf(s.getId()));
        list.add(s.getName());
        list.add(s.getBrand());
        list.add(s.getSport());
        list.add(String.valueOf(s.getQty()));
        list.add(String.valueOf(s.getPrice()));

        CSVUtils.writeLine(writer, list);
        //Use the CSVUtils.writeLine to save the data to file
    }

    writer.flush();
    writer.close();
    //Flush and close connection to the file

}

