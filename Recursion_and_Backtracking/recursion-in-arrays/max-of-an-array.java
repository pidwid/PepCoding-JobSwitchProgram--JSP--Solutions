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
        maxOfArray(a, n-1);
    }
    static int max = 0;
    public static void maxOfArray(int[] arr, int idx){
        if(idx < 0) {
            System.out.println(max);
            return;
        }
        if(arr[idx] > max) max = arr[idx];
        maxOfArray(arr, idx-1);
        return;
        
    }

}