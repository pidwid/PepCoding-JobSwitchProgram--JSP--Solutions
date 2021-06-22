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
        System.out.print(lastIndex(a, n-1, x));
    }
    public static int lastIndex(int[] arr, int idx, int x){
        if(idx <= 0) return -1;
        //return x == arr[idx] ? idx : lastIndex(arr, idx-1, x); 
    }

}
