import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    printEncodings(sc.nextLine(), "");
  }
  static char[] code = {'-','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
  public static void printEncodings(String str, String asf) {
    if (str.length() == 0) {
      System.out.println(asf);
      return;
    }
    
    char fchar = str.charAt(0);
    if(fchar == '0') return;
    String rstr = str.substring(1);
    printEncodings(rstr, asf + code[(fchar - '0')]);
    if (str.length() > 1) {
      String tstr = str.substring(0, 2);
      String trstr = str.substring(2);
      if (Integer.parseInt(tstr) < 26) printEncodings(trstr, asf + code[Integer.parseInt(tstr)]);
    }

  }

}