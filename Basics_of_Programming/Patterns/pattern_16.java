import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    for(int i = 1; i <= n; i++){
        int num =1;
        for(int j = 1; j < n*2; j++){
            if(num <= i)System.out.print(num + "	");
            else System.out.print("	");
            if(j < n) num++;
            else num--;
        }
        System.out.println();
    }

 }
}