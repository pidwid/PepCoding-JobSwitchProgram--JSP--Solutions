import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), m = sc.nextInt();
    int[][] mat = new int[n][m];
    for (int k = 0; k < n; k++) {
      for (int l = 0; l < m; l++) {
        mat[k][l] = sc.nextInt();
      }
    }
    //Recursive
    int max = 0;
    for (int i = 0; i < mat.length; i++) {
          max = Math.max(max, goldMine(mat, i, 0, new int[n][m]));
    }
    System.out.print(max);
        
    //goldMineTabLR(mat, n, m);
    //goldMineTabRL(mat, n, m);
  }
  
    public static int goldMine(int[][] mat, int sr, int sc, int[][] dp) {
        if(sr < 0 || sr >= mat.length) return Integer.MIN_VALUE;
        if(sc == mat[0].length - 1) return mat[sr][sc];
        if(dp[sr][sc] != 0) return dp[sr][sc];
        
        int f1 = goldMine(mat, sr - 1, sc + 1, dp);
        int f2 = goldMine(mat, sr, sc + 1, dp);
        int f3 = goldMine(mat, sr + 1, sc + 1, dp);
        int ans = Math.max(f1, Math.max(f2, f3)) + mat[sr][sc];
        dp[sr][sc] = ans;
        return ans;
      }
      
    

    // MY CODE {from left to right}
    public static void goldMineTabLR(int[][] mat, int n, int m) { 
      int max = 0;

      int[][] res = new int[n][m];
      for (int j = 0; j < m - 1; j++) {
        for (int i = 0; i < n; i++) {
          int curr = res[i][j] == 0 ? mat[i][j] : res[i][j];
          res[i][j + 1] = Math.max(curr + mat[i][j + 1], res[i][j + 1]);
          if (i != 0){
              res[i - 1][j + 1] = Math.max(curr + mat[i - 1][j + 1], res[i - 1][j + 1]);
          }
          if (i != n - 1){
              res[i + 1][j + 1] = Math.max(curr + mat[i + 1][j + 1], res[i + 1][j + 1]);
          }
        }
        for (int o = 0, p = m - 1; o < n; o++) {
          if (res[o][p] > max) max = res[o][p];
        }
      }
      System.out.println(max);
    }


    // {from right to left}
    public static void goldMineTabRL(int[][] mat, int n, int m) { 
      int max = 0;
      int[][] dp = new int[n][m];
      for (int j = m - 1; j >= 0; j--) {
        for (int i = n - 1; i >= 0; i--) {
          if (j == m - 1) dp[i][j] = mat[i][j];
          else if (i == 0) {
            dp[i][j] = mat[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
          }  else if (i == n - 1) {
            dp[i][j] = mat[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
          } else {
            dp[i][j] = mat[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
          }

        }
      }
      for (int i = 1; i < dp.length; i++) {
        if (dp[i][0] > max) max = dp[i][0];
      }
      System.out.println(max);
    }
}