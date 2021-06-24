package DP_theory_freecodecamp.memoization;

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

    public static void main(String[] args){
        String[] arr = {"bo", "rd", "ate", "t", "ska","sk", "boar"};
        String[] arr1 = {"cat", "dog", "rat"}; 
        String[] arr2 = {"ab", "abc", "cd", "def", "abcd", "ef"};
        String[] arr3 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
        System.out.println(allConstruct("skateboard", arr)); // false
        System.out.println(allConstruct("", arr1)); //true
        System.out.println(allConstruct("abcdef", arr2)); //true
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3)); //false

    }

    public static ArrayList<String> allConstruct(String target, String[] wordbank) {
        if(target.length() == 0) return true;
        for(String s: wordbank){
            if(target.startsWith(s)){
                String suffix = target.substring(s.length());
                if(allConstruct(suffix, wordbank)) return true;
            }
        }
        return false;

    }
    
}
