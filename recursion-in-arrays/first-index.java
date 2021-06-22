import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.print(firstIndex(a, 0, x));
    }
    public static int firstIndex(int[] arr, int idx, int x){
        if(idx >= arr.length) return -1;
        return arr[idx] == x ? idx : firstIndex(arr, idx+1, x);
    }

}