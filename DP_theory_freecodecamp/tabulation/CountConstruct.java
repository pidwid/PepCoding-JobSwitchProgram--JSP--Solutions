package DP_theory_freecodecamp.tabulation;

/**
 * https://www.youtube.com/watch?v=oBt53YbR9Kk
 * -> Write a function 'countConstruct' that accepts a target String and 
 * an array of strings.
 * -> It should return 'number of ways' that the 'target'
 * can be constructed by concatenating elemets of the 'workbank' array.
 * -> You may reuse the elements of the array multiple times.
 */


public class CountConstruct {

    public static int countConstruct(String target, String[] wordbank) {
        int count = 0;
        return count;

    }

    public static void main(String[] args){
        String[] arr = {"bo", "rd", "ate", "t", "ska","sk", "boar"};
        String[] arr1 = {"cat", "dog", "rat"}; 
        String[] arr2 = {"ab", "abc", "cd", "def", "abcd", "ef"};
        String[] arr3 = {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
        System.out.println(countConstruct("skateboard", arr)); // 0
        System.out.println(countConstruct("", arr1)); //1
        System.out.println(countConstruct("abcdef", arr2)); //3
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", arr3)); //0

    }

}
