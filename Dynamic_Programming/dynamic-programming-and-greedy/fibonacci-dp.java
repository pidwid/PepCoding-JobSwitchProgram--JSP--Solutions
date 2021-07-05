// Fibonacci DP
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.print(fib(n, new HashMap<>() ));
    
 }
 
 public static int fib(int n, HashMap<Integer, Integer> memo){
     if(n == 0 || n == 1) return n;
     if(memo.containsKey(n)) return memo.get(n);
        int x =  fib(n-1, memo) + fib(n - 2, memo);
        memo.put(n, x);
        return x;
 }

}