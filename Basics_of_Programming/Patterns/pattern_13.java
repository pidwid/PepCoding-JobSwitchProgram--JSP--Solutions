import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    for (int i = 0; i < n; i++) {
        int iCj = 1;
        for(int j = 0; j <= i; j++){
            // we have to calculate iCj
            // mCk+1 = (nCk*(n-k)) / k+1
            System.out.print(iCj + "	");
            int iCjp1 = iCj*(i-j)/(j+1);
            iCj = iCjp1;
        }
        System.out.println();
    }
  }
}