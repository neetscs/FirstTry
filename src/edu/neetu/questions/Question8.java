package edu.neetu.questions;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/29/13
 * Time: 11:08 AM
 */
public class Question8 {

    private static final int MINUTE_UNITS_PER_HOUR = 5, TOTAL_DEGREES_PER_HOUR = 360, DEGREE_COVERED_BY_ONE_MINUTE = 6, TOTAL_NO_OF_MINUTES = 60, TOTAL_NO_OF_HOURS = 12;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        float hours = 2, minutes = 20;
        float angle = 0;

        //To find the total number of minutes between the hour hand and the minute hand.
        float noOfMinutes = Math.abs(minutes - (MINUTE_UNITS_PER_HOUR * hours));

        //to find the angle between the hour hand and minute hand.
        angle = Math.abs((noOfMinutes * DEGREE_COVERED_BY_ONE_MINUTE) - ((minutes / TOTAL_NO_OF_MINUTES) * ( TOTAL_DEGREES_PER_HOUR / TOTAL_NO_OF_HOURS)));

        System.out.println(" The angle is: "+angle);
    }
}
