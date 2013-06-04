package edu.neetu.questions;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/4/13
 * Time: 12:06 PM
 */
public class Question11 {

    public static int sum = 0;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = new Integer(scanner.next());

        sum = sumOfDigits(number);

        System.out.println("The sum of the numbers is: " + sum);
    }

    private static int sumOfDigits(int number) {

       if (number == 0)
           return sum;

       else {
           sum = sum + (number % 10);
           number = number / 10;
           sumOfDigits(number);
       }

     return sum;

    }
}
