package DP_theory_freecodecamp.memoization;


/** "OPTIMIZATION PROBLEM"
* https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> write a func that takes targetSum and an array of numbers as argument,
 * -> it should return an array containing "shortest" combination of elements that adds up to
 * exactly the targetSum, else return empty array.
 * -> if multiple combinations are possible then return any one of them.
 */

import java.util.*;

public class BestSum {
    public static void main(String[] args){
        int[] arr = {3,4,5,7}; //[7]
        int[] arr1 = {2,4}; //null
        int[] arr2 = {7,14}; //null
        int[] arr3 = {2,3,5,25}; //[25,25]
        System.out.println(bestSum(7, arr, new HashMap<>()));
        System.out.println(bestSum(7, arr1, new HashMap<>()));
        System.out.println(bestSum(3000, arr2, new HashMap<>()));
        System.out.println(bestSum(50, arr3, new HashMap<>()));
    }

    public static ArrayList<Integer> bestSum(int targetSum, int[] numbers, Map<Integer, ArrayList<Integer>> memo) {
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        ArrayList<Integer> shortest = null;
        for(int num: numbers){
            int rem = targetSum - num;
            ArrayList<Integer> res = bestSum(rem, numbers, memo);
            if(res != null){
                ArrayList<Integer> remRes = new ArrayList<>(res);
                remRes.add(num);
                if(shortest == null || remRes.size() < shortest.size()) shortest = remRes;
                
            }
        }

        memo.put(targetSum, shortest);
        return shortest;
    }

    /** NO DP
    public static ArrayList<Integer> bestSum(int targetSum, int[] numbers) {
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;
        ArrayList<Integer> shortest = null;
        for(int num: numbers){
            int rem = targetSum - num;
            ArrayList<Integer> res = bestSum(rem, numbers);
            if(res != null){
                ArrayList<Integer> remRes = new ArrayList<>(res);
                remRes.add(num);
                if(shortest == null || remRes.size() < shortest.size()) shortest = remRes;
                
            }
        }
        return shortest;
    }
    */
}
