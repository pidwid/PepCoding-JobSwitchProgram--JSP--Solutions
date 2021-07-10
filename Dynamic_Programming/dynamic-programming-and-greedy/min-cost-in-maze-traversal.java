

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt(), m = sc.nextInt();
       int[][] arr = new int[n][m];
       for(int i = 0; i < n; i++){
           for(int j = 0; j < m; j++){
               arr[i][j] = sc.nextInt();
           }
       }
       int[][] dp = new int[n][m];
       //System.out.print(minCost(arr, 0, 0, dp));
       System.out.print(minCostTab(arr, n, m, dp));
    }
    
    public static int minCost(int[][] arr, int sr, int sc, int[][] dp){
        if(sr >= arr.length || sc >= arr[0].length) return Integer.MAX_VALUE;
        if(sr == arr.length - 1 && sc == arr[0].length - 1) return arr[sr][sc];
        if(dp[sr][sc] != 0) return dp[sr][sc];
        int f1 = minCost(arr, sr, sc + 1, dp);
        int f2 = minCost(arr, sr + 1, sc, dp);
        int ans = Math.min(f1, f2) + arr[sr][sc];
        dp[sr][sc] = ans;
        return ans;
    }
    
    public static int minCostTab(int[][] mat,int n,int m, int[][] dp){
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                int prev = mat[i][j];
                if(i == n-1 && j == m-1) dp[i][j] = prev;
                else if(i == n - 1) dp[i][j] = dp[i][j + 1] + prev;
                else if(j == m - 1) dp[i][j] = dp[i + 1][j] + prev;
                else dp[i][j] = prev + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        
        return dp[0][0];
    }

}

