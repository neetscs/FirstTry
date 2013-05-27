package edu.neetu.questions;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/26/13
 * Time: 3:50 PM
 */
public class Question3 {
    private static final String[] VOWELS = new String[] {"a", "e", "i", "o", "u"};


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        boolean hasNotFoundPeriod = true;
        while (hasNotFoundPeriod){
            String firstWord = scanner.next();

            if(firstWord.endsWith("."))
                hasNotFoundPeriod = false;
            String convertedWord = convertPigLatin(firstWord);

            System.out.print(convertedWord + " ");


        }
    }


    private static String convertPigLatin(String mainWord) {
        int vowelLocation = 0;

        for (String vowel : VOWELS) {
            vowelLocation = mainWord.indexOf(vowel);
            if (vowelLocation != -1) {
                  break;
            }

        }
        if(vowelLocation == -1)
            return mainWord.concat("ay");

        String consonants = mainWord.substring(0, vowelLocation);

        String remainingLetters = mainWord.substring(vowelLocation, mainWord.length());
        char lastChar = remainingLetters.charAt(remainingLetters.length() - 1);
        if (lastChar < 'A' || lastChar > 'z') {
            remainingLetters = remainingLetters.substring(0, remainingLetters.length() - 1);
            return remainingLetters.concat(consonants.concat("ay".concat(String.valueOf(lastChar))));

        }
        return remainingLetters.concat(consonants.concat("ay"));

    }
}
