package DP_theory_freecodecamp.memoization;

import java.util.HashMap;

/**
 * https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> Write a function 'canConstruct' that accepts a target String and 
 * an array of strings.
 * -> It should return a boolean indicating whether or not the 'target'
 * can be constructed by concatenating elemets of the 'workbank' array.
 * -> You may reuse the elements of the array multiple times.
 */

public class CanConstruct {
    public static void main(String[] args){
        String[] arr = {"bo", "rd", "ate", "t", "ska","sk", "boar"};
        String[] arr1 = {"cat", "dog", "rat"}; 
        String[] arr2 = {"ab", "abc", "cd", "def", "abcd", "ef"};
        String[] arr3 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
        System.out.println(canConstruct("skateboard", arr, new HashMap<>())); // false
        System.out.println(canConstruct("", arr1, new HashMap<>())); //true
        System.out.println(canConstruct("abcdef", arr2, new HashMap<>())); //true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3, new HashMap<>())); //false

    }

    public static boolean canConstruct(String target, String[] wordbank, HashMap<String, Boolean> memo) {
        if(target.length() == 0) return true;
        if(memo.containsKey(target)) return memo.get(target);
        for(String s: wordbank){
            if(target.startsWith(s)){
                String suffix = target.substring(s.length());
                if(canConstruct(suffix, wordbank, memo)) {
                    memo.put(suffix, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;

    }

    /** NO DP 
    public static boolean canConstruct(String target, String[] wordbank) {
        if(target.length() == 0) return true;
        for(String s: wordbank){
            if(target.startsWith(s)){
                String suffix = target.substring(s.length());
                if(canConstruct(suffix, wordbank)) return true;
            }
        }
        return false;

    }
    */
}
