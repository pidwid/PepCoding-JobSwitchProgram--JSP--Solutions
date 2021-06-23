package DP_theory_freecodecamp.memoization;
//normal 
// n = 1,2,3,4,5,6,7
// fib = 1,1,2,3,5,8,13,21,34
/** 
public class Fibonacci { 
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(7));
    }
    public static int fib(int n){
        if(n <= 2) return 1;
        return fib(n-1) + fib(n-2);
    }
}
*/

import java.util.*;

// memoization
public class Fibonacci {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(fib(6, map));
        System.out.println(fib(50, map));
    }
    public static int fib(int n, Map<Integer, Integer> map){
        if(n <= 2) return 1;
        if(map.containsKey(n)) return map.get(n);
        else {
            int res = fib(n-1, map) + fib(n-2, map);
            map.put(n, res);
            return res;
        }
    }
}