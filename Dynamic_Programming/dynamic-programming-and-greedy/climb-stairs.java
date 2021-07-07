// Climb Stairs
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getCount(n, new int[n+1]));
        System.out.println(getCountTab(n));
    }
    
    public static int getCount(int n, int[] dp){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(dp[n] != 0) return dp[n];
        int n1 = getCount(n - 1, dp);
        int n2 = getCount(n - 2, dp);
        int n3 = getCount(n - 3, dp);
        int res = n1+n2+n3;
        dp[n] = res;
        return res;
    }
    
        public static int getCountTab(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        if(n < 0) return 0;
        
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i - 1];
            if(i - 2 >= 0) dp[i] += dp[i - 2];
            if(i - 3 >= 0) dp[i] += dp[i - 3];
        }
        return dp[n];
    }

}