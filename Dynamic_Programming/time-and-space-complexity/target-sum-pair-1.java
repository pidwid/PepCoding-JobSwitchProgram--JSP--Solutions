// Target sum pair
import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target){
        //write your code here
        Arrays.sort(arr); // T(nlogn) sort
        int l = 0, r = arr.length - 1;
        while(l < r){
            int small = arr[l], big = arr[r];
            if(small + big > target) r--;
            else if(small + big < target) l++;
            else{
                System.out.println(small + ", "+ big);
                l++;
                r--;
            }
        }

  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}