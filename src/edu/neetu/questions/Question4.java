package edu.neetu.questions;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/27/13
 * Time: 11:01 AM
 */
public class Question4 {

    public static void main(String[] args){

        boolean hasNotFoundPeriod = true;
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter a sentence: ");

        while (hasNotFoundPeriod) {
            String userInput = scanner.next();
            if(userInput.endsWith("."))
                hasNotFoundPeriod = false;

            boolean foundPalindrome = isPalindrome(userInput);

            if (foundPalindrome)
                System.out.println(userInput.replace(".", ""));
        }


    }


    private static boolean isPalindrome(String userInput) {
        userInput = userInput.toLowerCase();
        int lengthPalindrome = userInput.length();
        boolean isPalindrome = true;
        boolean hasPeriod = userInput.endsWith(".");
        int start = 0, end = lengthPalindrome - 1;

        if (hasPeriod){
            // skip the last "." char
            end--;
        }

        while (start < end) {

            if(userInput.charAt(start) != userInput.charAt(end)) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        return isPalindrome;
    }
}
