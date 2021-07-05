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
        displayArrReverse(a, n-1);
    }

    public static void displayArrReverse(int[] arr, int idx){
        if(idx < 0) return;
        System.out.println(arr[idx]);
        displayArrReverse(arr, idx-1);
        return;
    }

}