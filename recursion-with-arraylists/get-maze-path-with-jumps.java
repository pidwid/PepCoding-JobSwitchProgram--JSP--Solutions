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
            ArrayList<String> path = new ArrayList<>();
            path.add("");
            return path;
        }
        
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        ArrayList<String> dpaths = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();
        for(int i = 1; i < dc ; i++){
            if(sc < dc) {
                hpaths = getMazePaths(sr, sc + i, dr, dc);
                for(String path: hpaths) paths.add("h" + i + path);   
            }
        }
        for(int i = 1; i < dr ; i++){
            if(sr < dr){
                vpaths = getMazePaths(sr + i, sc, dr, dc);
                for(String path: vpaths) paths.add("v" + i + path);
            }
        }
        for(int i = 1; i < dc && i < dr ; i++){
             if(sc < dc && sr < dr) {
                dpaths = getMazePaths(sr + i, sc + i, dr, dc);
                for(String path: dpaths) paths.add("d" + i + path);
             }
        }
        return paths;
    }

}


/**
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
            ArrayList<String> path = new ArrayList<>();
            path.add("");
            return path;
        }
        
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        ArrayList<String> dpaths = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();
        for(int i = 1; i <= dc - sc ; i++){
            hpaths = getMazePaths(sr, sc + i, dr, dc);
            for(String path: hpaths) paths.add("h" + i + path);   

        }
        for(int i = 1; i <= dr - sr ; i++){
            vpaths = getMazePaths(sr + i, sc, dr, dc);
            for(String path: vpaths) paths.add("v" + i + path);
        }
        for(int i = 1; i <= dc - sc && i <= dr - sr ; i++){
            dpaths = getMazePaths(sr + i, sc + i, dr, dc);
            for(String path: dpaths) paths.add("d" + i + path);
        }
        return paths;
    }

}
 */