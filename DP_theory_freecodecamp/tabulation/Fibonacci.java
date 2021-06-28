package DP_theory_freecodecamp.tabulation;

    // n = 1,2,3,4,5,6,7
    // fib = 1,1,2,3,5,8,13,21,34

public class Fibonacci {
    public static long fib(int n){
      long[] arr = new long[n+1];
      arr[0] = 0;
      arr[1] = 1;
      for(int i = 2; i<= n; i++) arr[i] = arr[i - 1] + arr[i - 2];
      return arr[n];
    }



    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib(50));
    }

}