package edu.neetu.questions;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/4/13
 * Time: 12:06 PM
 */
public class Question11 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter a number: ");
        int number = new Integer(scanner.next());

        while( number != 0){
            sum = sum + (number % 10);
            number = number / 10;
        }

        System.out.println("The sum of the numbers is: " + sum);
    }
}
