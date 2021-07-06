import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int st = 1, sp = 0;
        for(int i = 0; i < n; i++){
            for(int k = 1; k <= sp; k++){
                System.out.print("	");
            }
            for(int j = 1; j <= st; j++){
                System.out.print("*	");
            }
            System.out.println("");
            sp++;
        }

    }
}