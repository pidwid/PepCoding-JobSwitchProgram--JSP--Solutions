// Duplicate Brackets

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new Stack<>();
        for(Character ch : str.toCharArray()){
            if(ch != ')') st.push(ch);
            else{
                if(st.peek() == '(') {
                    System.out.println(true);
                    return;
                }
                while(st.peek() != '(') st.pop();
                st.pop();
            }
        }
        
        System.out.println(false);
        return;
    }

}