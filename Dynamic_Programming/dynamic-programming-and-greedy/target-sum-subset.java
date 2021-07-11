//Target Sum Subsets 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int tar = sc.nextInt();
        
        // System.out.println(targetSum(arr, tar, 0));
        Boolean[][] dp = new Boolean[n][tar+1];
        //System.out.println(targetSumMemo(arr, tar, 0, dp));
        System.out.println(targetSumTab(arr, tar));
    }
    
    // Normal Recursion
    public static boolean targetSum(int[] arr, int tar, int idx){
        if(idx == arr.length) return tar == 0;
               
        // not taking current element
        boolean f1 = targetSum(arr, tar, idx+1);
        // taking current element, and passing updated target
        boolean f2 = targetSum(arr, tar - arr[idx], idx+1);
        
        boolean ans = f1 || f2;
        return ans;
    }
    
    // Memoization
    public static boolean targetSumMemo(int[] arr, int tar, int idx, Boolean[][] dp){
         // for negative tar, tar == 0 will always be negative
        if(idx == arr.length || tar < 0) return tar == 0;
        
        if(dp[idx][tar] != null) return dp[idx][tar];
        // not taking current element
        boolean f1 = targetSumMemo(arr, tar, idx+1, dp);
        // taking current element, and passing updated target
        boolean f2 = targetSumMemo(arr, tar - arr[idx], idx+1, dp);
        boolean ans = f1 || f2;
        dp[idx][tar] = ans;
        return ans;
    }
    
    // tabulation
    public static boolean targetSumTab(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for(int idx = 0; idx <= arr.length; idx++){
            for(int tar = 0; tar <= target; tar++){
                if(idx == 0 && tar == 0) dp[idx][tar] = true;
                else if(idx == 0) dp[idx][tar] = false;
                else if(tar == 0) dp[idx][tar] = true;
                else{
                    if(dp[idx - 1][tar]) dp[idx][tar] = true;
                    else if(tar - arr[idx-1] >= 0 && dp[idx - 1][tar - arr[idx-1]]){
                        dp[idx][tar] = true;
                    }
                    else dp[idx][tar] = false; 
                }
            }
        }
        return dp[arr.length][target];
    }
    
}