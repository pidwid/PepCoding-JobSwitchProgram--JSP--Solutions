package DP_theory_freecodecamp.memoization;

import java.util.HashMap;
import java.util.Map;

/**  you are a traveler on a 2d grid, 
        you can only travel to right or down
        begin from top-left and finish in bottom right
        return number of ways this can be achieved.
       */
public class gridTraveler {
    public static void main(String[] args) {
        System.out.println(gTraveler(18,18, new HashMap<String, Integer>())); // ans = 3 --> {rrd, drr, rdr}
    }

    public static int gTraveler(int row, int col, Map<String, Integer> memo){
        if(row == 0 || col == 0) return 0;
        if(row == 1 && col == 1){
            return 1;
        }
        String val = row + "," + col, rval = col + "," + row;
        if(memo.containsKey(val)) return memo.get(val);
        else if(memo.containsKey(rval)) return memo.get(rval);
        memo.put(row+","+col, gTraveler(row - 1, col, memo) + gTraveler(row, col - 1, memo));
        return memo.get(row+","+col);
    }
}
