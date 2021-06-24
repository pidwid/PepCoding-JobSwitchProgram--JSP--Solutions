package DP_theory_freecodecamp.memoization;

/**
 * https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> Write a function 'countConstruct' that accepts a target String and 
 * an array of strings.
 * -> It should return 'number of ways' that the 'target'
 * can be constructed by concatenating elemets of the 'workbank' array.
 * -> You may reuse the elements of the array multiple times.
 */

import java.util.*;

public class CountConstruct {

    public static void main(String[] args){
        String[] arr = {"bo", "rd", "ate", "t", "ska","sk", "boar"};
        String[] arr1 = {"cat", "dog", "rat"}; 
        String[] arr2 = {"ab", "abc", "cd", "def", "abcd", "ef"};
        String[] arr3 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
        System.out.println(countConstruct("skateboard", arr, new HashMap<>())); // 0
        System.out.println(countConstruct("", arr1, new HashMap<>())); //1
        System.out.println(countConstruct("abcdef", arr2, new HashMap<>())); //3
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3, new HashMap<>())); //0

    }

    public static int countConstruct(String target, String[] wordbank, HashMap<String, Integer> memo) {
        if(target.length() == 0) return 1;
        if(memo.containsKey(target)) return memo.get(target);
        int count = 0;
        for(String s: wordbank){
            if(target.startsWith(s)){
                String suffix = target.substring(s.length());
                count += countConstruct(suffix, wordbank, memo);
            }
        }
        memo.put(target, count);
        return count;

    }
    /** NO DP
    public static int countConstruct(String target, String[] wordbank) {
        if(target.length() == 0) return 1;
        int count = 0;
        for(String s: wordbank){
            if(target.startsWith(s)){
                String suffix = target.substring(s.length());
                count += countConstruct(suffix, wordbank);
            }
        }
        return count;

    }
     */
    
}
