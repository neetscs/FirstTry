package edu.neetu.questions;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/28/13
 * Time: 11:12 AM
 */
public class Question7 {
    
    public static void main(String[] args){

        int x1 =10, y1 = 10, height1 = 4, width1 = 4, x2 = 10, y2 = 11, height2 = 3, width2 = 3;

        if (((x1 + width1) < x2) || ((x2 + width2) < x1) || ((y1 < y2 - height2) || (y2 < y1 - height1)))
            System.out.println("The rectangles do not overlap");

        else
            System.out.println("The rectangles overlap");

    }
}
