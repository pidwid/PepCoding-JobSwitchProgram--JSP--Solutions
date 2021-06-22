import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print(power(sc.nextInt(), sc.nextInt()));
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int res = power(x, n/2) * power(x, n/2);
        if(n%2 != 0)return x * res;
        else return res;
    }

}