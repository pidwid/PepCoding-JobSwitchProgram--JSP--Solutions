import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= n - i; j++){
                sb.append("	");
            }
            for(int k = 1; k <= i; k++){
                sb.append("*	");
            }
            System.out.println(sb.toString());
        }
    }
}