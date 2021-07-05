// Merge two sorted array
import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
      int alen = a.length, blen = b.length;
     int[] res = new int[alen + blen];
     int i = 0, j = 0, idx = 0;
     while(i < alen && j < blen){
        if(a[i] < b[j]) res[idx++] = a[i++];
        else res[idx++] = b[j++];
     }
     while(j < blen) res[idx++] = b[j++];
     while(i < alen) res[idx++] = a[i++];
    
    return res;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}