// Unbounded Knapsack
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];
        int wght[] = new int[n];
        for(int i = 0; i < n; i++) prices[i] = sc.nextInt();
        for(int i = 0; i < n; i++) wght[i] = sc.nextInt();
        int cap = sc.nextInt();
        
        System.out.println(unboundKnapTab(prices, wght, cap));
    }
    
    
    
    public static int unboundKnapTab(int[] prices, int[] weight, int cap){
         int[] dp = new int[cap + 1];
         for(int i = 0; i < prices.length; i++){
             for(int j = weight[i]; j < dp.length; j++){
                 dp[j] = Math.max(dp[j], prices[i] + dp[j - weight[i]]);
             }
         }
         return dp[cap];
    }
}
