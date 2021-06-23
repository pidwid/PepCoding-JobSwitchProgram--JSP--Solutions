import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printSS(str, "");
    }

    public static void printSS(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char fchar = str.charAt(0);
        String rstr = str.substring(1);
        printSS(rstr, ans + fchar);
        printSS(rstr, ans + "");
        
        
    }

}