package DP_theory_freecodecamp.tabulation;


/** "OPTIMIZATION PROBLEM"
* https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> write a func that takes targetSum and an array of numbers as argument,
 * -> it should return an array containing "shortest" combination of elements that adds up to
 * exactly the targetSum, else return empty array.
 * -> if multiple combinations are possible then return any one of them.
 */

import java.util.*;

public class BestSum {

    public static ArrayList<Integer> bestSum(int targetSum, int[] numbers) {
        ArrayList<Integer> shortest = null;
        return shortest;
    }


    public static void main(String[] args){
        int[] arr = {3,4,5,7}; //[7]
        int[] arr1 = {2,4}; //null
        int[] arr2 = {7,14}; //null
        int[] arr3 = {2,3,5,25}; //[25,25]
        System.out.println(bestSum(7, arr));
        System.out.println(bestSum(7, arr1));
        System.out.println(bestSum(3000, arr2));
        System.out.println(bestSum(50, arr3));
    }
}
