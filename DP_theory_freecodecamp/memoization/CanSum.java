package DP_theory_freecodecamp.memoization;

/**
 *  -> Write a func that takes in a targetSum val and an array of numbers as aguments,
 *  -> it should retuen a boolean stating wheather it is possible to create the targetSum
 *  using elements of the array.
 *  -> You cna use an elements of arrays as many times as needed.
 *  -> all input numbers are non-negative.
 */ 
public class CanSum {

    public static void main(String[] args) {
        int[] arr = {3,4,5,7}; //true
        int[] arr1 = {2,4}; //false
        int[] arr2 = {7,14}; //false
        System.out.println(canSum(7, arr));
        System.out.println(canSum(7, arr1));
        System.out.println(canSum(300, arr2));
    }

    public static boolean canSum(int targetSum, int[] arr){
        if(targetSum == 0) return true;
        else if(targetSum < 0) return false; 
        for(int i : arr){
            int rem = targetSum - i;
            if(canSum(rem, arr)) return true;        
        }
        return false;
    }
    
}
