import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int[][] res = new int[n][m];
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                int prev = mat[i][j];
                if(i == n-1 && j == m-1) res[i][j] = prev;
                else if(i == n - 1) res[i][j] = res[i][j + 1] + prev;
                else if(j == m - 1) res[i][j] = res[i + 1][j] + prev;
                else res[i][j] = prev + Math.min(res[i + 1][j], res[i][j + 1]);
            }
        }
        
        System.out.println(res[0][0]);
    }

}