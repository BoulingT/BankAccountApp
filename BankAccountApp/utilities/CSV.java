package utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
public class CSV {
    //this methid reads data from csv file and return as a list
    public static List<String[]> read(File f){
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;

        try{
        BufferedReader br = new BufferedReader(new FileReader(f));
         while ((dataRow = br.readLine()) != null){
            String[] dataRecords = dataRow.split(",");
            data .add(dataRecords);
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    return data;
    }   
}