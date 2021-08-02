package Utils;

import Models.*;
import Services.HairProductsServices;
import Services.MakeUpServices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtils {
    private static final char DEFAULT_SEPARATOR = ',';
    //Create a final variable to hold the comma separator
    // since we do not need this value to change

    public static void writeLine(FileWriter w, List<String> values)throws IOException {
        //To make this method reusable we will pass a Writer object representing the
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
        //Finally, append the string to the CSV file
    }

    public static void writeFiles() throws IOException {
        HairProductsServices.csvHairFileSaver();
        MakeUpServices.csvMakeUpFileSaver();
    }

//    public static void writeMFiles() throws IOException{
//        MakeUpServices.csvMakeUpFileSaver();
//    }

    public static void loadFiles()  {
        HairProductsServices.loadHData();
        MakeUpServices.loadMUData();
    }

//    public static void loadMFiles()  {
//
//    }





}

