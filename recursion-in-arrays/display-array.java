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
        displayArr(a, n-1);
    }

    public static void displayArr(int[] arr, int idx){
        if(idx < 0) return;
        displayArr(arr, idx-1);
        System.out.println(arr[idx]);
        return;
    }

}