// Highest Frequency Character

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        char maxc = ' ';
        for(Character c: s.toCharArray()){
            if(map.containsKey(c)){
                int a = map.get(c);
                map.put(c, a+1);
                if(a+1 > max){
                    max = a;
                    maxc = c;
                }
            }else{
                map.put(c, 1);
                if(1 > max){
                    max = 1;
                    maxc = c;
                }
            }
        }
        System.out.print(maxc);
    }

}