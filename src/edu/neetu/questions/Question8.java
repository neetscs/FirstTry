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
        int hours = 2, minutes = 20;
        int angle = 0;
        int noOfMinutes = 0;

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
        angle = noOfMinutes * 6 - ((minutes * 30) / 60);

        System.out.println(" The angle is: "+angle);
    }
}
