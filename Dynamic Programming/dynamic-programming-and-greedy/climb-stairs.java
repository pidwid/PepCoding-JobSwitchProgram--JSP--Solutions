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
    
    public static int getCount(int n, int[] x){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(x[n] > 0) return x[n];
        int count = 0;
        int n1 = getCount(n - 1, x);
        int n2 = getCount(n - 2, x);
        int n3 = getCount(n - 3, x);
        count += n1 + n2 + n3;
        x[n] = count;
        return count;
    }
    
    
    public static int getCountTab(int n){
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = dp[i - 1];                
            }else if(i == 2){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }
    

}