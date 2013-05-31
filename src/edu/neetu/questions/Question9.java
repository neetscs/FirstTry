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
    private static HashMap<String, String> hashMap = new HashMap();

    public static void main(String[] args) {

        int lineCounter = 0;

        String dataFileName = "data_file.txt";
        String indexFileName = "index_file.txt";

        Scanner indexFileScanner, dataFileScanner;

        File indexFile = new File(indexFileName);
        File dataFile = new File(dataFileName);

        try{

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
            Iterator<Map.Entry<Integer, ArrayList<Integer>>> treeMapIterator = treeMapSet.iterator();

            while (treeMapIterator.hasNext()){
                Map.Entry<Integer, ArrayList<Integer>> mapEntry = treeMapIterator.next();
                Integer lineNumber = mapEntry.getKey();
                ArrayList<Integer> wordNumList = mapEntry.getValue();

                while (lineCounter < lineNumber){
                    if (lineCounter == lineNumber - 1)
                        //find the all the words corresponding to the line number.
                        findWord(dataFileScanner, wordNumList, lineNumber);
                    dataFileScanner.nextLine();
                    lineCounter++;
                }
            }

            indexFileScanner = new Scanner(indexFile);

            String eachEntryInIndexFile;

            while(indexFileScanner.hasNext()){
                eachEntryInIndexFile = indexFileScanner.next();
                //Print all the words corresponding to a line number and word number from index file
                printWord(eachEntryInIndexFile);
            }
        }

        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

    }

    private static void printWord(String eachIndex) {
        Set hashMapSet = hashMap.entrySet();
        Iterator hashMapIterator = hashMapSet.iterator();

        while (hashMapIterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry) hashMapIterator.next();
            String keyInHashMap = (String) mapEntry.getKey();
            String foundWord = (String) mapEntry.getValue();

            if(eachIndex.equals(keyInHashMap)){
                System.out.println(foundWord);
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
            wordNumberArray = new ArrayList<Integer>();

        wordNumberArray.add(wordNumber);
        Collections.sort(wordNumberArray);
        treeMap.put(lineNumber, wordNumberArray);
    }
}
