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

        int result = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = new Integer(scanner.next());

        result = sumOfDigits(number);

        System.out.println("The sum of the numbers is: " + result);
    }

    private static int sumOfDigits(int number) {

       if (number == 0)
           return 0;

       else
           return (number % 10) + sumOfDigits(number/10);
    }
}
