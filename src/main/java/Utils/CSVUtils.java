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

}

