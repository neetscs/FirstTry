package edu.neetu.project1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/26/13
 * Time: 2:15 PM
 */
public class Question2 {

    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter you full name: ");
        System.out.flush();

        String fullName = scanner.nextLine();
        String[] nameParts = fullName.split(" ");

        System.out.println("Your name is: ");

        for (String namePart : nameParts) {
            System.out.print(capitalize(namePart) + " ");
        }
    }

    private static String capitalize(String name) {
        String firstLetter = name.substring(0, 1);
        String convertedLetter = firstLetter.toUpperCase();
        String nextLetters = name.substring(1,name.length());
        return convertedLetter.concat(nextLetters);
    }
}
