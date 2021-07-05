import java.io.*;
import java.util.*;

public class Main {
    static int rowsize = -1, colsize = -1;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        rowsize = n;
        colsize = m;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr, 0, 0, "", new boolean[n][m]);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] vis) {
        if(sr < 0 || sc < 0 || sr ==  rowsize || sc == colsize || maze[sr][sc] == 1 || vis[sr][sc] == true) return;
        if(sr ==  rowsize - 1 && sc == colsize - 1) {
            System.out.println(asf);
            return;
        }
        vis[sr][sc] = true;
        floodfill(maze, sr - 1, sc, asf + 't', vis); //top
        floodfill(maze, sr, sc - 1, asf + 'l',vis); //left
        floodfill(maze, sr + 1, sc, asf + 'd',vis); //down
        floodfill(maze, sr, sc + 1, asf + 'r',vis); //right
        vis[sr][sc] = false;
    }
}
