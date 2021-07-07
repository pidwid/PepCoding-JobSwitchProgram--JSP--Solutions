// Sort Dates
import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(String[] arr) {
     countSort(arr, 1000000, 100, 99); //day
     countSort(arr, 10000, 100, 99); //month
     countSort(arr, 1, 10000, 3000); //year {assuming year <= 3000}
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    int n = arr.length;
    String[] finalarr = new String[n];
   int[] farr = new int[range]; // 0-9 digit Freq arr
   
   // create freq array
   for(int i = 0; i < n; i++){
       farr[Integer.parseInt(arr[i], 10) / div % mod]++; 
   }
   // convert freq array to psum array
   for(int i = 1; i < farr.length; i++){
        farr[i] += farr[i - 1];
   }
   for(int i = n-1; i >= 0; i--){
       int curr_idx = farr[Integer.parseInt(arr[i], 10) / div % mod] - 1;
       finalarr[curr_idx] = arr[i];
       farr[Integer.parseInt(arr[i], 10) / div % mod]--;

   }
   for(int i = 0; i < n; i++){
       arr[i] = finalarr[i];
   }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}