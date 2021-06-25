package DP_theory_freecodecamp.tabulation;


/**
 * https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> Write a function 'canConstruct' that accepts a target String and 
 * an array of strings.
 * -> It should return a boolean indicating whether or not the 'target'
 * can be constructed by concatenating elemets of the 'workbank' array.
 * -> You may reuse the elements of the array multiple times.
 */

public class CanConstruct {


    public static boolean canConstruct(String target, String[] wordbank) {
        return false;
    }


    public static void main(String[] args){
        String[] arr = {"bo", "rd", "ate", "t", "ska","sk", "boar"};
        String[] arr1 = {"cat", "dog", "rat"}; 
        String[] arr2 = {"ab", "abc", "cd", "def", "abcd", "ef"};
        String[] arr3 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
        System.out.println(canConstruct("skateboard", arr)); // false
        System.out.println(canConstruct("", arr1)); //true
        System.out.println(canConstruct("abcdef", arr2)); //true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3)); //false

    }

}
