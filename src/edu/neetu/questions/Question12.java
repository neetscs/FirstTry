package edu.neetu.questions;

import com.sun.javafx.tools.packager.bundlers.IOUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/4/13
 * Time: 2:57 PM
 */
public class Question12 {

    public static void main(String[] args){

        String jsonFileName = "sample_data.json";
        String jsonFileContents = readJsonFile(jsonFileName);
        System.out.println(jsonFileContents);
        JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsonFileContents);

        int size = jsonArray.getJSONObject(0).getJSONArray("trends").size();
        int start = 0;

        while (start < size){
            System.out.println(jsonArray.getJSONObject(0).getJSONArray("trends").getJSONObject(start).get("name"));
            start++;
        }

    }

    private static String readJsonFile(String jsonFileName) {
        File jsonFile = new File(jsonFileName);
        try{
            StringBuffer scannerContent = new StringBuffer() ;
            Scanner jsonScanner = new Scanner(jsonFile);
            while (jsonScanner.hasNext()){

                scannerContent.append(jsonScanner.nextLine());
            }
            return scannerContent.toString();
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    return null;
    }
}
