// Climb Stairs With Variable Jumps
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
        System.out.println(variableClimb(n, arr));
        
        
    }
    
    public static int variableClimb(int n, int[] arr){
        int[] res = new int[n + 1];
        res[n] = 1;
        for(int i = n-1; i >= 0; i--){
            int count = 0;
            for(int j = 1; j <= arr[i]; j++){
                if(i + j <= n) count += res[i + j];
            }
            res[i] = count;
        }
        
        
        return res[0];
        
    }

}