package DP_theory_freecodecamp.tabulation;

import javax.swing.plaf.TreeUI;

/** "DICISION PROBLEM"
 *  https://www.youtube.com/watch?v=oBt53YbR9Kk
 *  -> Write a func that takes in a targetSum val and an array of numbers as aguments,
 *  -> it should retuen a boolean stating wheather it is possible to create the targetSum
 *  using elements of the array.
 *  -> You cna use an elements of arrays as many times as needed.
 *  -> all input numbers are non-negative.
 */


public class CanSum {

    public static boolean canSum(int targetSum, int[] arr){
        boolean[] barr = new boolean[targetSum + 1];
        barr[0] = true;
        for(int i = 0; i <= targetSum; i++){
            if(barr[i]) for(int el : arr) if(i + el <= targetSum) barr[i + el] = true;
        }
        return barr[targetSum];
    }



    public static void main(String[] args) {
        int[] arr = {3,4,5,7}; //true
        int[] arr1 = {2,4}; //false
        int[] arr2 = {7,14}; //false
        System.out.println(canSum(7, arr));
        System.out.println(canSum(7, arr1));
        System.out.println(canSum(300, arr2));
    }
}
