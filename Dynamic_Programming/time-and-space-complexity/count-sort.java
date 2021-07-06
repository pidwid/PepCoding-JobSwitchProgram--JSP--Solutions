// Count Sort
// use for sorting short range of numbers
// ex: ranklist of JEE students
import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   int n = arr.length;
   int flen = max - min + 1;
   int[] farr = new int[flen]; // frequesncy array
   
   // create freq array
   for(int i = 0; i < n; i++){
       farr[arr[i] - min]++; 
   }
   // convert freq array to psum array
   for(int i = 1; i < farr.length; i++){
        farr[i] += farr[i - 1];
   }
   int[] finalarr = new int[n];
   for(int i = n-1; i >= 0; i--){
       int curr_idx = farr[arr[i] - min];
       finalarr[curr_idx - 1] = arr[i];
       farr[arr[i] - min]--;

   }
   for(int i = 0; i < n; i++){
       arr[i] = finalarr[i];
   }
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}