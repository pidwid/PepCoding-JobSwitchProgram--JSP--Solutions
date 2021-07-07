// Fibonacci DP
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(fib(n, new HashMap<>() ));
    System.out.println(fibTab(n));
    
 }
 
 public static int fib(int n, HashMap<Integer, Integer> memo){
     if(n == 0 || n == 1) return n;
     if(memo.containsKey(n)) return memo.get(n);
     else {
        int x =  fib(n-1, memo) + fib(n - 2, memo);
        memo.put(n, x);
         return x;
     }
 }
 
  public static int fibTab(int n){
     int[] res = new int[n + 1];
     res[0] = 0;
     res[1] = 1;
     for(int i = 2; i <= n; i++) res[i] = res[i - 1] + res[i - 2];
     
     return res[n];
 }

}