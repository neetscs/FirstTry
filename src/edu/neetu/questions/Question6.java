package edu.neetu.questions;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/27/13
 * Time: 5:38 PM
 */
public class Question6 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        String fullSentence = scanner.nextLine();


        char[] characters = fullSentence.toCharArray();

        // Phase 1: Reverse the entire string
        reverseChars(characters, 0, characters.length - 1);

        // Phase 2: Reverse each word in the string from Phase 1
        // characters = [!, e, r, e, h, t, , i, H]
        int beginIdx = 0, endIdx = 0;

        while (endIdx < characters.length) {
            // find the start of the next word
            while (beginIdx < characters.length && (characters[beginIdx] < 'A' || characters[beginIdx] > 'z')) {
                beginIdx++;
            }

            // find the end of the word
            endIdx = beginIdx;
            while (endIdx < characters.length && characters[endIdx] != ' ') {
                endIdx++;
            }

            reverseChars(characters, beginIdx, endIdx == characters.length - 1 ? endIdx : endIdx - 1);
            // characters = [!, t, h, e, r, e, , H, i]

            beginIdx = endIdx;
        }

        System.out.println(new String(characters));
    }

    private static void reverseChars(char[] characters, int startIdx, int endIdx) {
        while (startIdx < endIdx){
            char tempChar = characters[startIdx];
            characters[startIdx] = characters[endIdx];
            characters[endIdx] = tempChar;

            startIdx++;
            endIdx--;
        }
    }
}