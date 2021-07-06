// Radix Sort
import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr, int max) {
    // write code here 
    int exp = 1;
    while(exp <= max){
        countSort(arr, exp);
        exp *= 10;
    }
  }

  public static void countSort(int[] arr, int exp) {
    int n = arr.length;
    int[] finalarr = new int[n];
   int[] farr = new int[10]; // 0-9 digit Freq arr
   
   // create freq array
   for(int i = 0; i < n; i++){
       farr[arr[i] / exp % 10]++; 
   }
   // convert freq array to psum array
   for(int i = 1; i < farr.length; i++){
        farr[i] += farr[i - 1];
   }
   for(int i = n-1; i >= 0; i--){
       int curr_idx = farr[arr[i] / exp % 10] - 1;
       finalarr[curr_idx] = arr[i];
       farr[arr[i] / exp % 10]--;

   }
   for(int i = 0; i < n; i++){
       arr[i] = finalarr[i];
   }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      if(arr[i] > max) max = arr[i];
    }
    radixSort(arr, max);
    print(arr);
  }

}