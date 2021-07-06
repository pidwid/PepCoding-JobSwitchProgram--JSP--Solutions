import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = n; i >= 1; i--){
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= n - i; j++){
                System.out.print("	");
            }
            for(int k = 1; k <= i; k++){
                System.out.print("*	");
            }
            System.out.println();
        }
    }
}