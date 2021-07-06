import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(), sp = n/2, st = 1, num = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sp; j++){
            System.out.print("	");
        }
        int poi = num;
        for (int j = 1; j <= st; j++){
            System.out.print(poi +  "	");
            if(j <= st/2) poi++;
            else poi--;
        }
        if(i <= n/2){
            st+=2;
            sp--;
            num++;
        }else{
            sp++;
            st-=2;
            num--;
        }
        System.out.println( );
    }
  }
}