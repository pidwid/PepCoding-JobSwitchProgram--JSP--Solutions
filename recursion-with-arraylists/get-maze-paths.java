import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        System.out.print(getMazePaths(1,1,n,m));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> nopath = new ArrayList<>();
            nopath.add("");
            return nopath;
        }
        ArrayList<String> hpath = new ArrayList<>();
        ArrayList<String> vpath = new ArrayList<>();
        if(sc < dc) hpath = getMazePaths(sr, sc + 1, dr, dc);
        if(sr < dr) vpath = getMazePaths(sr + 1, sc, dr, dc);
        ArrayList<String> tpath = new ArrayList<>(); 
        for(String s : hpath) tpath.add("h" + s);
        for(String s : vpath) tpath.add("v" + s);
        return tpath;
    }

}