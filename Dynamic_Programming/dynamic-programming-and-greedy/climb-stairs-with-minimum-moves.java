import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        //System.out.println(minClimb(0, arr, new int[n+1]));
        //System.out.println(minClimbTab(n, arr));
        //System.out.println(minClimbTabTop(n, arr));
        System.out.println(minClimbOpt(n, arr));
    }
    // Not working
    public static int minClimb(int idx, int[] arr, int[] dp){
        if(idx >= arr.length) return 0;
        if(idx == arr.length) return 1;
        if(dp[idx] != 0) return dp[idx];
        int min = Integer.MAX_VALUE;
        for(int jump = 1;  idx - 1 >= 0 && jump <= arr[idx - 1]; jump++){
            if(idx + jump <= arr.length) min =  Math.min(minClimb(idx + jump, arr, dp), min);
        }
        dp[idx] = min;
        return min;
    }
    
    // Bottom Up  
    public static int minClimbTab(int n, int[] arr){
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j<= arr[i]; j++){
                if(i + j <= n) if(dp[i + j] < min) min = dp[i + j] + 1;
            }
            dp[i] = min;
        }
        return dp[0];
    }
    
    // Top Down
    public static int minClimbTabTop(int n, int[] arr){
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){ 
            int min = Integer.MAX_VALUE;
            for(int j = i-1; j >= 0; j--){
                if(arr[j] >= i - j){
                    if(dp[j] < min) min = dp[j];
                }
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
    
    // Optimized  O(n) soln
    public static int minClimbOpt(int n, int[] arr){
        int steps = 0;
        for(int i = 0; i < n;){
            if(arr[i] == 0) break;
            int max = 0, maxIdx = 0;
            for(int jump = 1; jump <= arr[i]; jump++){
                int j = i + jump;
                if(j == n - 1){
                    steps++;
                    return steps;
                }
                if(j + arr[j] >= max){
                    max = j + arr[j];
                    maxIdx = j;
                }
            }
            i = maxIdx;
            steps++;
        }
        return Integer.MAX_VALUE;
    }


}