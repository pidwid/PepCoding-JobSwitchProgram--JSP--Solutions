import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int k = 0; k < n; k++){
            for(int l = 0; l < m; l++){
                mat[k][l] = sc.nextInt();
            }
        }
        int max = 0;
        /** MY CODE {from left to right}
        int[][] res = new int[n][m];
        for(int j = 0; j < m - 1; j++){    
            for(int i = 0; i < n; i++){
                int curr = res[i][j] == 0 ? mat[i][j] : res[i][j];
                res[i][j + 1] = Math.max(curr + mat[i][j + 1], res[i][j + 1]);
                //System.out.println( i + "," + (j+1) +" -> " + res[i][j + 1]);
                if(i != 0){
                    res[i-1][j + 1] = Math.max(curr + mat[i-1][j + 1], res[i - 1][j + 1]);
                   // System.out.println( (i-1) + "," + (j+1) +" -> "+ res[i-1][j+1]);
                }
                if(i != n-1){
                    res[i+1][j + 1] = Math.max(curr + mat[i+1][j + 1], res[i + 1][j + 1]);
                    //System.out.println( (i+1) + "," + (j+1) +" -> "+ res[i+1][j+1]);
                }
                
                //System.out.println( "AFTER i->"+ i + " j->" + j + " $ " + res[i][j]);
            }
            for(int o = 0, p = m-1; o < n; o++){
                if(res[o][p] > max) max = res[o][p];
            }
        }
        */
        
        // start {from right to left}
        int[][] dp = new int[n][m];
        for(int j = m-1; j >= 0; j--){    
            for(int i = n-1; i >= 0; i--){
                if(j == m-1) dp[i][j] = mat[i][j];
                else if(i == 0){
                    dp[i][j] = mat[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }else if(i == n-1){
                    dp[i][j] = mat[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }else{
                    dp[i][j] = mat[i][j] + Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
                }
                
            }
        }    
        for(int i = 1; i < dp.length; i++){
            if(dp[i][0] > max) max = dp[i][0];
        }
        // end
        System.out.print(max);
    }
}