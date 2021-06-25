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
        String[] arr2 = {"ab", "abc", "cd", "def", "abcd", "ef", "c"};
        String[] arr3 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
        String[] arr4 = {"purp", "p", "ur", "le", "purpl"};
        System.out.println(allConstruct("skateboard", arr, new HashMap<>())); // []
        System.out.println(allConstruct("", arr1, new HashMap<>())); // [[]]
        System.out.println(allConstruct("abcdef", arr2, new HashMap<>())); // [[ab,cd,ef], [abc, def], [abcd,ef], [ab,c,def]]
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3, new HashMap<>())); //[]
        System.out.println(allConstruct("purple", arr4, new HashMap<>())); //[]
        
        // System.out.println(allConstruct("skateboard", arr)); // []
        // System.out.println(allConstruct("", arr1)); // [[]]
        // System.out.println(allConstruct("abcdef", arr2)); // [[ab,cd,ef], [abc, def], [abcd,ef]]
        // System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3)); //[]

    }
    // this does not really works with memo or arraylist, as it will check for target and its result, but for same target we have more than 1 result
    // Ex: for 'ef' in 3rd call we have [abcd, ef] && [ab,cd,ef] so it add both prefixes to both
    public static ArrayList<ArrayList<String>> allConstruct(String target, String[] wordbank, HashMap<String, ArrayList<ArrayList<String>>> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.length() == 0){
            ArrayList<ArrayList<String>> ar =new ArrayList<>();
            ar.add(new ArrayList<>());
            return ar;
        }
        ArrayList<ArrayList<String>> res  = new ArrayList<>();
        
        for(String word: wordbank){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());
                ArrayList<ArrayList<String>> suffixWays = allConstruct(suffix, wordbank, memo);
                for(ArrayList<String> targetWay: suffixWays){
                    targetWay.add(0, word);
                    res.add(targetWay);
                } 
            }
           
        }
        memo.put(target, res);
        return res;

    }

    

    /** NO DP
    public static ArrayList<ArrayList<String>> allConstruct(String target, String[] wordbank) {
        if(target.length() == 0){ 
            ArrayList<ArrayList<String>> ar =new ArrayList<>();
            ar.add(new ArrayList<>());
            return ar;
        }
        ArrayList<ArrayList<String>> res  = new ArrayList<>();
        
        for(String word: wordbank){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());
                ArrayList<ArrayList<String>> suffixWays = allConstruct(suffix, wordbank);
                if(suffixWays.size() > 0){
                    for(ArrayList<String> targetWay: suffixWays){
                        targetWay.add(0, word);
                        res.add(targetWay);
                    }
                } 
            }
        }
        return res;

    }
     */
    
}
