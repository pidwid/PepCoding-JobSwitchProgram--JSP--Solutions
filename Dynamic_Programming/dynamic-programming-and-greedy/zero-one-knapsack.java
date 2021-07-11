// Zero One Knapsack

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int profit[] = new int[n];
        int wght[] = new int[n];
        for(int i = 0; i < n; i++) profit[i] = sc.nextInt();
        for(int i = 0; i < n; i++) wght[i] = sc.nextInt();
        int cap = sc.nextInt();
        //System.out.println(zeroOneTab(n, profit, wght, cap));
        System.out.println(zeroOneMemo( profit, wght,0, cap, new Integer[n+1][cap+1]));
        
    }
    // Memo
    public static int zeroOneMemo(int[] profit, int[] wght,int idx, int cap, Integer[][] dp){
        if(cap < 0) return Integer.MIN_VALUE; // return invalid
        if(idx == wght.length) return 0;  // No elements left, so no profit
        if(dp[idx][cap] != null) return dp[idx][cap];
        int f1 = 0 + zeroOneMemo(profit, wght,idx+1, cap, dp);
        int f2 = profit[idx] + zeroOneMemo(profit, wght,idx+1, cap - wght[idx], dp);
        int ans = Math.max(f1, f2);
        dp[idx][cap] = ans;
        return ans;
    }
    
    // Tabulation
    public static int zeroOneTab(int n, int[] profit, int[] wght, int cap){
        int[][] dp = new int[n+1][cap + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= cap; j++){
                dp[i][j] = dp[i-1][j];
                if(j - wght[i-1] >= 0){
                   dp[i][j] = Math.max(dp[i][j], dp[i-1][j - wght[i-1]] + profit[i-1]); 
                }
                
            }
        }
        
        return dp[n][cap];
    }
}
