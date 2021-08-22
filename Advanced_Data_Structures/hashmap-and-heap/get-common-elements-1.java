// Get Common Elements - 1

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
     Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < a; i++){
            map.put(sc.nextInt(), 1);
        }
        int b = sc.nextInt();
        int[] ar = new int[b];
        for(int i = 0; i < b; i++){
            ar[i] = sc.nextInt();
            
            if(map.containsKey(ar[i]) && map.get(ar[i]) == 1){
                System.out.println(ar[i]);
                map.put(ar[i], 0);
            }
        }
        
 }

}