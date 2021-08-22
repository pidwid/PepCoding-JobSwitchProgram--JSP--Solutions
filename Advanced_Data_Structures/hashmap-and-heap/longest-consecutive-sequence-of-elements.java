// Longest Consecutive Sequence Of Elements

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    HashMap<Integer, Boolean> map = new HashMap<>();
    int[] ar = new int[a];
    for(int i = 0; i < a; i++){
        ar[i] = sc.nextInt(); 
        map.put(ar[i], true);
    }
    
    for(int i = 0; i < a; i++){
        int val = ar[i];
        if(map.containsKey(val - 1)){
            map.put(val, false);
        }
    }
    int max = Integer.MIN_VALUE, num = -1; 
    for(int val: map.keySet()){
        if(map.get(val) == true){
            boolean exist = true;
            int curr = val, locMax = 0;
            while(exist){
                if(map.containsKey(curr)){
                    locMax++;
                    curr++;
                }else exist = false;
            }
            if(locMax > max){
                max = locMax;
                num = val;
            }
        }
        
    }
    for(int i = 0; i < max; i++) System.out.println(num++);
    
    
 }

}