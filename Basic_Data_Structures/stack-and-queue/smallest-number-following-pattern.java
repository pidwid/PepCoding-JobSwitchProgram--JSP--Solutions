// smallest number following pattern

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Stack<Integer> st = new Stack<>();
    int n = 1;
    for(char ch: str.toCharArray()){
        if(ch == 'd') st.push(n++);
        if(ch == 'i'){
            st.push(n++);
            while(!st.isEmpty()) System.out.print(st.pop());
        }
    }
    st.push(n++);
    while(!st.isEmpty()) System.out.print(st.pop());
 }
}