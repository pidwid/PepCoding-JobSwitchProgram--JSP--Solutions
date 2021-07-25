// Celebrity Problem

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++) st.push(i);
        while(st.size() > 1){
            int i = st.pop(), j = st.pop();
            if(arr[i][j] == 1){
                // if i knows j -> i is not a celebrity
                st.push(j);
            }else{
                // if i does not know j -> j is not a celebrity
                st.push(i);
            }
        }
        int poten = st.pop();
        for(int i = 0; i < arr.length; i++){
            if(i != poten && (arr[i][poten] == 0 || arr[poten][i] == 1)){
                System.out.println("none");
                return;
            }
        }
        System.out.println(poten);
    }

}