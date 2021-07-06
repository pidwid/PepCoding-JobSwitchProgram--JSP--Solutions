import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(), sp = 0, st = n;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= sp; j++){
            System.out.print("	");        
        }
        for(int k = 1; k <= st; k++){
            if(i <= n/2 && st < n && st > 1) {
                if(k == 1 || k == st)System.out.print("*	");
                else System.out.print("	");
            }
            else System.out.print("*	");        
        }
        System.out.println();
        if(i <= n/2){
            st-=2;
            sp++;
        }else{
            st+=2;
            sp--;
        }
    }

 }
}