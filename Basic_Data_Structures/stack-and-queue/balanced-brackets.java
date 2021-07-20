// Balanced Brackets

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new Stack<>();
        for(Character ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else if(st.isEmpty() && (ch == '}' || ch == ')' || ch == ']')){
                System.out.println(false);
                return;
            }
            else if(ch == '}' && st.peek() == '{') st.pop();
            else if(ch == ')' && st.peek() == '(') st.pop();
            else if(ch == ']' && st.peek() == '[') st.pop();
            else continue;
        }
        
        if(st.isEmpty()) System.out.println(true);
        else  System.out.println(false);
    }

}