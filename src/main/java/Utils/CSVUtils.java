package Utils;

import Models.*;
import Services.HairProductsServices;
import Services.MakeUpServices;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
   // private static final char DEFAULT_SEPARATOR = ',';
    //Create a final variable to hold the comma separator
    // since we do not need this value to change

    public static void writeLine(CSVWriter w, List<String> values) {
        //To make this method reusable we will pass a Writer object representing the
        // file to write to. The next parameter is a list of String objects that will
        // represent the data of the object to write to CSV format. Now, wherever we want
        // to write some values to CSV we can call this method and pass the values to the
        // file and the data as a List

        String [] wtf = values.toArray(new String[0]);
        w.writeNext(wtf);
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

