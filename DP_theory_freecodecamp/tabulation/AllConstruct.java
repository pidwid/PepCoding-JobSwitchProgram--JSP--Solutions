package DP_theory_freecodecamp.tabulation;

/**
 * https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> Write a function 'allConstruct' that accepts a target String and 
 * an array of strings.
 * -> It should return a 2D array of 'all the ways' that the 'target'
 * can be constructed by concatenating elemets of the 'workbank' array.
 * -> Each element of 2D array should represent one combonation to get 'target'.
 * -> You may reuse the elements of the array multiple times.
 */

import java.util.*;

public class AllConstruct {

    public static ArrayList<ArrayList<String>> allConstruct(String target, String[] wordbank) {
        
        ArrayList<ArrayList<String>> res  = new ArrayList<>();
        return res;

    }



    public static void main(String[] args){
        String[] arr = {"bo", "rd", "ate", "t", "ska","sk", "boar"};
        String[] arr1 = {"cat", "dog", "rat"}; 
        String[] arr2 = {"ab", "abc", "cd", "def", "abcd", "ef", "c"};
        String[] arr3 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
        String[] arr4 = {"purp", "p", "ur", "le", "purpl"};
        
        System.out.println(allConstruct("skateboard", arr)); // []
        System.out.println(allConstruct("", arr1)); // [[]]
        System.out.println(allConstruct("abcdef", arr2)); // [[ab,cd,ef], [abc, def], [abcd,ef]]
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3)); //[]
        System.out.println(allConstruct("purple", arr4));
    }

    
}
