// Number Of Islands

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      boolean[][] visited = new boolean[arr.length][arr[0].length];
      int count = 0;
      for(int i = 0; i < arr.length; i++){
          for(int j = 0; j < arr[0].length; j++){
              if(!visited[i][j] && arr[i][j] == 0){
                  drawIsland(arr, i, j, visited);
                  count++;
              }
          }
      }
      System.out.print(count);
   }
   
   public static void drawIsland(int[][] arr, int i, int j, boolean[][] visited){
       if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] || arr[i][j] == 1){
           return;
       }
       visited[i][j] = true;
       drawIsland(arr, i + 1, j, visited);
       drawIsland(arr, i - 1, j, visited);
       drawIsland(arr, i, j + 1, visited);
       drawIsland(arr, i, j - 1, visited);
   }

}