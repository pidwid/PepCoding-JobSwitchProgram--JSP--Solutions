import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print(power(sc.nextInt(), sc.nextInt()));
    }

    public static int power(int x, int n){
        if(n <= 0){
            return 1;
        }
        return x * power(x, n-1);
    }

}