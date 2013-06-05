package edu.neetu.questions;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/30/13
 * Time: 11:23 AM
 */
public class Question9 {

    private static TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
    private static HashMap<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        int lineCounter = 0;

        String dataFileName = "/question_9/data_file.txt";
        String indexFileName = "/question_9/index_file.txt";

        Scanner indexFileScanner, dataFileScanner;
        InputStream indexFile = Question9.class.getResourceAsStream(indexFileName);
        InputStream dataFile = Question9.class.getResourceAsStream(dataFileName);


        indexFileScanner = new Scanner(indexFile);
        while (indexFileScanner.hasNext()){
            String eachIndex = indexFileScanner.next();
            int colonLocation = eachIndex.indexOf(":");
            int lineNumber = new Integer(eachIndex.substring(0, colonLocation));
            int wordNumber = new Integer(eachIndex.substring(colonLocation + 1));

            //Adding the line number and word number from index file to a tree map
            addLineAndWordNumberToMap(lineNumber, wordNumber);
        }

        dataFileScanner = new Scanner(dataFile);

        Set<Map.Entry<Integer, ArrayList<Integer>>> treeMapSet = treeMap.entrySet();

        for (Map.Entry<Integer, ArrayList<Integer>> mapEntry : treeMapSet) {
            Integer lineNumber = mapEntry.getKey();
            ArrayList<Integer> wordNumList = mapEntry.getValue();

            while (lineCounter < lineNumber) {
                if (lineCounter == lineNumber - 1)
                    //find the all the words corresponding to the line number.
                    findWord(dataFileScanner, wordNumList, lineNumber);
                dataFileScanner.nextLine();
                lineCounter++;
            }
        }
        indexFile = Question9.class.getResourceAsStream(indexFileName);
        indexFileScanner = new Scanner(indexFile);
        String eachEntryInIndexFile;

        while(indexFileScanner.hasNext()){
            eachEntryInIndexFile = indexFileScanner.next();
            //Print all the words corresponding to a line number and word number from index file
            if(hashMap.containsKey(eachEntryInIndexFile)){
                System.out.print(hashMap.get(eachEntryInIndexFile) + " ");
            }
        }
    }

    private static void findWord(Scanner dataFileScanner, ArrayList<Integer> wordNumList, int lineNumber) {
        int wordCounter = 0;
        String wordInDataFile;
        for (Integer wordToBeScannedPosition : wordNumList){

            while (wordCounter < wordToBeScannedPosition) {
                wordInDataFile = dataFileScanner.next();
                if (wordCounter == (wordToBeScannedPosition - 1)){
                    hashMap.put(String.valueOf(lineNumber) + ":" + String.valueOf(wordToBeScannedPosition), wordInDataFile);
                }
                wordCounter++;
            }
        }
    }

    private static void addLineAndWordNumberToMap(int lineNumber, int wordNumber) {

        ArrayList<Integer> wordNumberArray ;

        if(treeMap.containsKey(lineNumber))
            wordNumberArray = treeMap.get(lineNumber);
        else
            wordNumberArray = new ArrayList<>();

        wordNumberArray.add(wordNumber);
        Collections.sort(wordNumberArray);
        treeMap.put(lineNumber, wordNumberArray);
    }
}
