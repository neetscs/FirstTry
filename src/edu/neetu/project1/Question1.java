package edu.neetu.project1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/26/13
 * Time: 1:55 PM
 */
public class Question1 {
    public static void main(String[] args){
        Scanner acceptInput = new Scanner(System.in);

        String enterName;

        System.out.print("Enter Your name: ");
        enterName = acceptInput.next();

        System.out.println("Your name is: "+enterName.toUpperCase());

    }
}
