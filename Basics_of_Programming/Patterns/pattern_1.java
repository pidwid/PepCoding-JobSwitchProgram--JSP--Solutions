import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    for(int i = 1; i <= n; i++){
        StringBuilder r = new StringBuilder();
        for(int j = 1; j <= i; j++){
            r.append("*	");
        }
        System.out.println(r.toString());
    }
    return;
  }
}