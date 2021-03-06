package DP_theory_freecodecamp.tabulation;

/** "COMBINATORIC PROBLEM"
 * * https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> write a func that takes targetSum and an array of numbers as argument,
 * -> it should return an array containing combination of elements that adds up to
 * exactly the targetSum, else return empty array.
 * -> if multiple combinations are possible then return any one of them.
 */

 import java.util.*;

public class HowSum {

    public static ArrayList<Integer> howSum(int targetSum, int[] numbers) {
        ArrayList<Integer>[] narr = new ArrayList[targetSum + 1];
        //int[][] res = new int[targetSum + 1][targetSum + 1];
        narr[0] = new ArrayList<>();
        for(int i = 0; i <= targetSum; i++)
            if(narr[i] != null) 
                for(int el : numbers)
                    if(i + el <= targetSum) {
                        narr[i + el] = new ArrayList<>();
                        narr[i + el].addAll(narr[i]);
                        narr[i + el].add(el);
                    }
        return narr[targetSum];
    }


    public static void main(String[] args){
        int[] arr = {3,4,5,7}; //[4,3]
        int[] arr1 = {2,4}; //null
        int[] arr4 = {2,3}; //null
        int[] arr2 = {7,14}; //null
        int[] arr3 = {2}; //[2,2,2,...]
        System.out.println(howSum(7, arr));
        System.out.println(howSum(7, arr1));
        System.out.println(howSum(3000, arr2));
        System.out.println(howSum(50, arr3));
        System.out.println(howSum(7, arr4));
    }
}
