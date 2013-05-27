package edu.neetu.questions;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/27/13
 * Time: 12:52 PM
 */
public class Question5 {
    public static void main(String[] args){

        int start = 1, end = 100;

        while (start <= end){

            if (start % 3 == 0 && start % 5 == 0)
                System.out.println("FizzBuzz");

            else if (start % 5 == 0)
                System.out.println("Buzz");

            else if (start % 3 == 0)
                System.out.println("Fizz");

            else
                System.out.println(start);

            start++;

        }
    }
}
