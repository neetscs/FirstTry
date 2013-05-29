package edu.neetu.questions;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/29/13
 * Time: 11:08 AM
 */
public class Question8 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        float hours = 3, minutes = 15;
        float angle = 0;
        float noOfMinutes = 0;

        //Calculate the number of minutes, noOfMinutes between hour hand and minute hand

        //If the hour hand is at 12
        if (hours == 12)
            noOfMinutes = minutes * 5;

        //If the minute hand is at 12
        else if (minutes == 0)
            noOfMinutes = hours * 5;

        //Other conditions
        else
            noOfMinutes = (Math.abs((minutes/5) - hours)) * 5;

        //formula: noOfMinutes * 6 - (minutes/60 * 360/12)
        angle = Math.abs(noOfMinutes * 6 - ((minutes * 30) / 60));

        System.out.println(" The angle is: "+angle);
    }
}
