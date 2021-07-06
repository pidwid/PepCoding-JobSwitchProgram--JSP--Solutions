import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int st = 1, sp = n/2;
    for (int i = 1; i <= n; i++) {
      for(int j = 1; j <= sp; j++){
          System.out.print("	");
      }
      for(int k = 1; k <= st; k++){
          System.out.print("*	");
      }
      System.out.println("");
      if(i <= n/2){
          sp--;
          st += 2;
      }else{
          sp++;
          st -= 2;
      }
      
    }
  }
}