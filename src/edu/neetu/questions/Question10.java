package edu.neetu.questions;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/3/13
 * Time: 11:48 AM
 */
public class Question10 {
    public static void main(String[] args){

        String[] array1 = {"a", "c", "x", "y", "z"};
        String[] array2 = {"a", "b", "c", "d", "x", "y"};

        int array1Pointer = 0, array2Pointer = 0, count = 0, startPointer = 0;
        int targetLength = 0;

        targetLength = (array1.length + array2.length)/2;

        while ( startPointer <= targetLength ){
            if( array1[array1Pointer].compareToIgnoreCase(array2[array2Pointer]) > 0) {
               array2Pointer++;
            }
            else {
                if( array1[array1Pointer].compareToIgnoreCase(array2[array2Pointer]) == 0 ) {
                count++;
                array1Pointer++;
                array2Pointer++;
            }
            else
                array1Pointer++;
            }
         startPointer++;
        }
         System.out.println(count);
    }
}
