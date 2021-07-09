// Climb Stairs With Variable Jumps

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        //System.out.println(getCount(0, arr, new int[n+1]));
        System.out.println(getCountTabTop(n, arr));
    }
    // memoization
    public static int getCount(int idx, int[] arr, int[] dp){
        if(idx > arr.length) return 0;
        if(idx == arr.length) return 1;
        if(dp[idx] != 0) return dp[idx];
        int res = 0;
        for(int i = 1; i <= arr[idx]; i++){
            res += getCount(idx + i, arr, dp);
        }
        dp[idx] = res;
        return res;
    }
    // Bpttom Up
    public static int getCountTab(int n, int[] arr){
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--){
            int jump = arr[i];
            for(int j = 1; j <= jump; j++){
                if(i + j <= n)dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }
    
    // Top Down
    public static int getCountTabTop(int n, int[] arr){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){ 
            for(int j = i-1; j >= 0; j--){
                if(arr[j] >= i - j) dp[i] += dp[j];
                //System.out.println(" i - j --> " + (i - j)+ "i ->" +i + "j ->" + j);
            }
            //System.out.println(i + "-> i = " + dp[i]);
        }
        return dp[n];
    }

}