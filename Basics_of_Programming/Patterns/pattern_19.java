import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(j == n/2+1 || i == n/2+1) System.out.print("*	");
            else if(i == 1 && !(j < n && j > n/2+1) || i == n && !(j > 1 && j < n/2+1)) System.out.print("*	"); 
            else if((i > 1 && i < n) && ((j == 1 && i >n/2) || (j == n && i <=n/2))) System.out.print("*	");
            else System.out.print("	");
        }
        System.out.println();
    }
    return;

 }
}