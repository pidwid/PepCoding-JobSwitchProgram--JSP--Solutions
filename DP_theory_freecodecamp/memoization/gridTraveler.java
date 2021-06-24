package DP_theory_freecodecamp.memoization;

/**  
 * * https://www.youtube.com/watch?v=oBt53YbR9Kk   
     * you are a traveler on a 2d grid, 
     * you can only travel to right or down
     * begin from top-left and finish in bottom right
     * return number of ways this can be achieved.
    */

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {
    public static void main(String[] args) {
        System.out.println(gridTraveler(18,18, new HashMap<String, Integer>())); // ans = 3 --> {rrd, drr, rdr}
    }

    public static int gridTraveler(int row, int col, Map<String, Integer> memo){
        if(row == 0 || col == 0) return 0;
        if(row == 1 && col == 1){
            return 1;
        }
        String val = row + "," + col, rval = col + "," + row;
        if(memo.containsKey(val)) return memo.get(val);
        else if(memo.containsKey(rval)) return memo.get(rval);
        memo.put(row+","+col, gridTraveler(row - 1, col, memo) + gridTraveler(row, col - 1, memo));
        return memo.get(row+","+col);
    }

    //no DP
    /**
        public static int gTraveler(int row, int col){
        if(row == 0 || col == 0) return 0;
        if(row == 1 && col == 1){
            return 1;
        }
        return gTraveler(row - 1, col) + gTraveler(row, col - 1);
    }
     */
}
