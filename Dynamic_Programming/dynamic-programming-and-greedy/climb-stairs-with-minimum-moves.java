// Climb Stairs With Minimum Moves
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minClimb(n, arr));
    }
    
    public static int minClimb(int n, int[] arr){
        Integer[] res = new Integer[n + 1];
        res[n] = 0;
        for(int i = n-1; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j<= arr[i]; j++){
                if(i + j <= n){
                    if(res[i + j] < min) min = res[i + j] + 1;
                }
            }
            res[i] = min;
        }
        return res[0];
    }

}