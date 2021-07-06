import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int sp = 1, st = n/2;
    for (int i = 1; i <= n; i++) {
      for(int j = 0; j <= st; j++){
          System.out.print("*	");
      }
      for(int k = 1; k <= sp; k++){
          System.out.print("	");
      }
      for(int j = 0; j <= st; j++){
          System.out.print("*	");
      }
      System.out.println("");
      if(i <= n/2){
          st--;
          sp += 2;
      }else{
          st++;
          sp -= 2;
      }
      
    }
  }
}