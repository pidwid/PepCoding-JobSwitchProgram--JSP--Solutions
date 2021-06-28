package DP_theory_freecodecamp.tabulation;

/**  
 * * https://www.youtube.com/watch?v=oBt53YbR9Kk   
     * you are a traveler on a 2d grid, 
     * you can only travel to right or down
     * begin from top-left and finish in bottom right
     * return number of ways this can be achieved.
    */


public class GridTraveler {

    public static long gridTraveler(int row, int col){
        long[][] mat = new long[row+1][col+1];
        mat[1][1] = 1;
        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= col; j++){
                long current = mat[i][j];
                if(i + 1 <= row) mat[i+1][j] += current;
                if(j + 1 <= col)mat[i][j+1] += current;
            } 
        }
        return mat[row][col];
    }

    public static void main(String[] args) {

        System.out.println(gridTraveler(3,3)); // ans = 3 --> {rrd, drr, rdr}
        System.out.println(gridTraveler(18,18)); // 
    }
}
