// Coin Change Permutations
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int amt = sc.nextInt();
        
        //System.out.print(coinChangeMemo(arr, amt, new Integer[amt + 1]));
         System.out.print(coinChangeTab(arr, amt));
    }
    
    
    public static int coinChangeMemo(int[] arr, int amt, Integer[] dp){
        if(amt == 0) return 1;
        if(amt < 0) return 0;
        if(dp[amt] != null) return dp[amt];
        int val = 0;
        for(int i = 0; i < arr.length; i++){
            val += coinChangeMemo(arr, amt - arr[i], dp);
        }
        dp[amt] = val;
        return val;
    }
    
        public static int coinChangeTab(int[] arr, int amt){
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for(int j = 1; j < dp.length; j++){    
            for(int coin : arr){
                if((j - coin) >= 0) dp[j] += dp[j - coin];
            }
        }
        return dp[amt];
    }
}