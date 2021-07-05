import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);
           System.out.print(factorial(sc.nextInt()));
    }

    public static int factorial(int n){
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

}