package edu.neetu.questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/30/13
 * Time: 11:23 AM
 */
public class Question9 {

    private static TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap();

    public static void main(String[] args) {

        String dataFileName = "data_file.txt";
        String indexFileName = "index_file.txt";

        try{
            File indexFile = new File(indexFileName);
            Scanner indexFileScanner =  new Scanner(indexFile);
            while (indexFileScanner.hasNext()){
                String eachIndex = indexFileScanner.next();
                int colonLocation = eachIndex.indexOf(":");
                int lineNumber = new Integer(eachIndex.substring(0, colonLocation));
                int wordNumber = new Integer(eachIndex.substring(colonLocation + 1));

                addWordNumberToMap(lineNumber, wordNumber);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    private static void addWordNumberToMap(int lineNumber, int wordNumber) {

        ArrayList<Integer> wordNumberArray ;

        if(treeMap.containsKey(lineNumber))
            wordNumberArray = treeMap.get(lineNumber);
        else
            wordNumberArray = new ArrayList<Integer>();

        wordNumberArray.add(wordNumber);
        treeMap.put(lineNumber, wordNumberArray);
    }
}
