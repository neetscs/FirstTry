package edu.neetu.questions;

import sun.nio.cs.ext.MacThai;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/3/13
 * Time: 11:48 AM
 */
public class Question10 {
    public static void main(String[] args){

        String[] array1 = {"a", "c", "x", "z"};
        String[] array2 = {"a", "b", "c", "d", "z", "z", "z"};

        int array1IDX = 0, array2IDX = 0, count = 0;

        while ( array1IDX < array1.length && array2IDX < array2.length ){

            if( array1[array1IDX].compareToIgnoreCase(array2[array2IDX]) > 0) {
               array2IDX++;
            }
            else if( array1[array1IDX].compareToIgnoreCase(array2[array2IDX]) == 0 ) {
                count++;
                array1IDX++;
                array2IDX++;
            }
            else {
                array1IDX++;
            }
        }
         System.out.println(count);
    }
}
