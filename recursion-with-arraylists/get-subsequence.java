// Get Subsequence

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        char ch = str.charAt(0);
        String res = str.substring(1);
        ArrayList<String> rres = gss(res);
        ArrayList<String> mres =  new ArrayList<>();
        for(String s: rres) mres.add("" + s);
        for(String s: rres) mres.add(ch + s);
        return mres;
    }

}