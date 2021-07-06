import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(), sp = n/2, st = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sp; j++){
            System.out.print("	");
        }
        for (int j = 1; j <= st; j++){
            if(j > st/2) System.out.print("*	");
            else if(i == n/2 + 1) System.out.print("*	");
            else System.out.print("	");
        }
        if(i <= n/2){
            st+=2;
            sp--;
        }else{
            sp++;
            st-=2;
        }
        System.out.println( );
    }
  }
}