package DP_theory_freecodecamp.memoization;

/** "COMBINATORIC PROBLEM"
 * * https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> write a func that takes targetSum and an array of numbers as argument,
 * -> it should return an array containing combination of elements that adds up to
 * exactly the targetSum, else return empty array.
 * -> if multiple combinations are possible then return any one of them.
 */

 import java.util.*;

public class HowSum {
    public static void main(String[] args){
        int[] arr = {3,4,5,7}; //[4,3]
        int[] arr1 = {2,4}; //null
        int[] arr2 = {7,14}; //null
        int[] arr3 = {2}; //[2,2,2,...]
        System.out.println(howSum(7, arr, new HashMap<>()));
        System.out.println(howSum(7, arr1, new HashMap<>()));
        System.out.println(howSum(3000, arr2, new HashMap<>()));
        System.out.println(howSum(50, arr3, new HashMap<>()));
    }

    public static ArrayList<Integer> howSum(int targetSum, int[] numbers, Map<Integer, ArrayList<Integer>> memo) {
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        for(int num: numbers){
            int rem = targetSum - num;
            ArrayList<Integer> res = howSum(rem, numbers, memo);
            if(res != null){
                ArrayList<Integer> remRes = new ArrayList<>(res);
                remRes.add(num);
                memo.put(targetSum, remRes);
                return remRes;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    /** NO DP
    public static ArrayList<Integer> howSum(int targetSum, int[] numbers) {
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;
        for(int num: numbers){
            int rem = targetSum - num;
            ArrayList<Integer> res = howSum(rem, numbers);
            if(res != null){
                ArrayList<Integer> remRes = new ArrayList<>(res);
                remRes.add(num);
                return remRes;
            }
        }
        return null;
    }
     */
    
}
