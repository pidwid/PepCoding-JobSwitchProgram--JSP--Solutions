import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(), os = n/2, is = -1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= os; j++) {
            System.out.print("	");
        }
        System.out.print("*	");
        for (int l = 1; l <= is; l++) {
            System.out.print("	");
        }
        if(is != -1) System.out.print("*	");
      System.out.println("");
      if(i <= n/2){
          os--;
          is += 2;
      }else{
          os++;
          is -= 2;
      }
    }
  }
}