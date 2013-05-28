package edu.neetu.questions;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/28/13
 * Time: 11:12 AM
 */
public class Question7 {
    
    public static void main(String[] args){

        int x1 = 4, y1 = 4, height1 = 4, width1 = 4, x2 = 9, y2 = 3, height2 = 1, width2 = 1;
        int w1 = y1 - height1, z1 = x1 + width1, w2 = y2 - height2, z2 = x2 + width2;

        boolean isOverlap1 = checkEachOverlap(z1, x2, z2, x1);

        boolean isoverlap2 = checkEachOverlap(w1, y2, w2, y1);


        if (isOverlap1 && isoverlap2)
            System.out.println("The rectangles overlap.");

        else
            System.out.println("The rectangles do not overlap.");



    }

    private static boolean checkEachOverlap(int coordinate1, int coordinate2, int coordinate3, int coordinate4) {
        if (coordinate1 > coordinate2 || coordinate3 < coordinate4)
            return true;

        return false;
    }
}
