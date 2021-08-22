// Get Common Elements - 2

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < a; i++){
        int val = sc.nextInt();
        if(map.containsKey(val)) map.put(val, map.get(val) + 1);
        else map.put(val, 1);
    }
    int b = sc.nextInt();
    int[] ar = new int[b];
    for(int i = 0; i < b; i++){
        ar[i] = sc.nextInt();
    }
    
    for(int i = 0; i < b; i++){
        int val = ar[i];
        if(map.containsKey(val) && map.get(val) > 0){
            System.out.println(val);   
            map.put(val, map.get(val) - 1);
        }
    }
 }

}