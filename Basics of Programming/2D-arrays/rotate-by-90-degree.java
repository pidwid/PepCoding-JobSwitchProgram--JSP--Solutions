// Rotate by 90 degree

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        //display(arr);
        
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n/2; j++) {
              //System.out.print(i + "" + j + " --> " + i + "" + (n - 1 - j) +  "\t");
              int temp = arr[i][j];
              arr[i][j] = arr[i][n - 1 - j];
              arr[i][n - 1 - j] = temp;
          }
          //System.out.println();
        }
        display(arr);
        
        
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}