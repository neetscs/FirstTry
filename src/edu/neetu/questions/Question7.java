package edu.neetu.questions;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 5/28/13
 * Time: 11:12 AM
 */
public class Question7 {
    
    public static void main(String[] args){
        
        int x1 = 4, y1 = 4, height1 = 4, width1 = 4, x2 = 3, y2 = 3, height2 = 1, width2 = 1;
        

        boolean isOverlap1 = checkOverlap(x1, x2, width1, y1, y2, height1);
        boolean isOverlap2 = checkOverlap(x2, x1, width2, y2, y1, height2);
        boolean isOverlap3 = checkOverlap(x2, x1, height1, y2, y1, width1);
        boolean isOverlap4 = checkOverlap(x1, x2, height2, y2, y1, width2);


        if (isOverlap1 || isOverlap2 || isOverlap3 || isOverlap4)
            System.out.println("The rectangles overlap.");

        else
            System.out.println("The rectangles do not overlap.");



    }

    private static boolean checkOverlap(int xCoordinate1, int xCoordinate2, int xCoordinate3, int yCoordinate1, int yCoordinate2, int yCoordinate3 ) {

        if ((xCoordinate1 <= xCoordinate2 && xCoordinate2 <= xCoordinate3) || (yCoordinate1 <= yCoordinate2 && yCoordinate2 <= yCoordinate3))
                return true;


        return false;

    }
}
