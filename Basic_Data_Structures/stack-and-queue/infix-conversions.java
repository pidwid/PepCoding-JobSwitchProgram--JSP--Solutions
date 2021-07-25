// Infix Conversions

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    InfixConv(exp);
    
 }
 public static void InfixConv(String str){
        Stack<Character> optrSt = new Stack<>();
        Stack<String> preSt = new Stack<>();
        Stack<String> postSt = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                preSt.push(ch + "");
                postSt.push(ch + ""); 
            }
            else if(ch == '(') optrSt.push(ch);
            else if(ch == ')'){
                while(optrSt.peek() != '('){
                    char optr = optrSt.pop();
                    String preOp2 = preSt.pop();
                    String preOp1 = preSt.pop();
                    preSt.push(optr + preOp1 + preOp2);
                    String postOp2 = postSt.pop();
                    String postOp1 = postSt.pop();
                    postSt.push(postOp1 + postOp2 + optr);
                }
                // pop the '('
                optrSt.pop();
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(!optrSt.isEmpty() && precedence(optrSt.peek()) >= precedence(ch)){
                    char optr = optrSt.pop();
                    String preOp2 = preSt.pop();
                    String preOp1 = preSt.pop();
                    preSt.push(optr + preOp1 + preOp2);
                    String postOp2 = postSt.pop();
                    String postOp1 = postSt.pop();
                    postSt.push(postOp1 + postOp2 + optr);
                }
                // push the current operator
                optrSt.push(ch);
            }else continue;
        }
        // solve till stack is Empty
        while(!optrSt.isEmpty()){
            char optr = optrSt.pop();
            String preOp2 = preSt.pop();
            String preOp1 = preSt.pop();
            preSt.push(optr + preOp1 + preOp2);
            String postOp2 = postSt.pop();
            String postOp1 = postSt.pop();
            postSt.push(postOp1 + postOp2 + optr);
        }
        System.out.println(postSt.peek());
        System.out.println(preSt.peek());
        
     }
 
 public static int precedence(char ch){
     if(ch == '*' || ch == '/') return 2;
     else if(ch == '+' || ch == '-') return 1;
     else return 0;
 }
}