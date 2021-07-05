// Sort 01
import java.io.*;
import java.util.*;

public class Main {

  public static void sort01(int[] arr){
    int i = 0, j = 0;
    while(i < arr.length && j < arr.length){
        if(arr[i] == 0){
            swap(arr, i, j);
            i++;
            j++;
        }else i++;
    }
    
  }
  
  /** My Solution
   public static void sort01(int[] arr){
    int start = 0, end = arr.length - 1;
    while(start < end){
        if(arr[end] == 1 && start < end) end--;
        if(arr[start] == 0 && start < end) start++;
        if(arr[start] == 1 && arr[end] == 0){
             swap(arr, start, end);
             start++;
             end--;
        }
    }
    
  }
   */

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    sort01(arr);
    print(arr);
  }

}