package DP_theory_freecodecamp.memoization;


/** "DICISION PROBLEM"
 *  https://www.youtube.com/watch?v=oBt53YbR9Kk
 *  -> Write a func that takes in a targetSum val and an array of numbers as aguments,
 *  -> it should retuen a boolean stating wheather it is possible to create the targetSum
 *  using elements of the array.
 *  -> You cna use an elements of arrays as many times as needed.
 *  -> all input numbers are non-negative.
 */

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static void main(String[] args) {
        int[] arr = {3,4,5,7}; //true
        int[] arr1 = {2,4}; //false
        int[] arr2 = {7,14}; //false
        System.out.println(canSum(7, arr, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(7, arr1,new HashMap<Integer, Boolean>()));
        System.out.println(canSum(300, arr2, new HashMap<Integer, Boolean>()));
    }

    public static boolean canSum(int targetSum, int[] arr, Map<Integer, Boolean> memo){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return true;
        else if(targetSum < 0) return false; 
        for(int i : arr){
            int rem = targetSum - i;
            if(canSum(rem, arr, memo)){
                memo.put(rem, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }


    /** No DP
     public static boolean canSum(int targetSum, int[] arr){
        if(targetSum == 0) return true;
        else if(targetSum < 0) return false; 
        for(int i : arr){
            int rem = targetSum - i;
            if(canSum(rem, arr)) return true;        
        }
        return false;
    }
     */
    
}
