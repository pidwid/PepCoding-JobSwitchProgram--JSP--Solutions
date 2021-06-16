// Get Kpc

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(getKPC(str));
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char fchar = str.charAt(0);
        String rstr = str.substring(1);
        ArrayList<String> rres = getKPC(rstr);
        ArrayList<String> mres = new ArrayList<>();
        int x = Integer.parseInt(String.valueOf(fchar));
        String code = codes[x];
        for(int i = 0; i < code.length(); i++){
            for(String s: rres) mres.add(code.charAt(i) + s);
        }
        
        return mres;
    }

}