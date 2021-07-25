// Postfix Evaluations Conversions

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    solvePre(exp);
    
 }

 public static void solvePre(String str){
    Stack<Integer> opSt = new Stack<>();
    Stack<String> convInfixSt = new Stack<>();
    Stack<String> convPostSt = new Stack<>();
    
    for(int i = str.length() -1; i >=0 ; i--){
        char ch = str.charAt(i);
        if(ch >= '0' && ch <= '9'){
             opSt.push(ch - '0');
             convInfixSt.push(ch + "");
             convPostSt.push(ch + "");
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            int op1 = opSt.pop();
            int op2 = opSt.pop();
            String inOp1 = convInfixSt.pop();
            String inOp2 = convInfixSt.pop();
            String postOp1 = convPostSt.pop();
            String postOp2 = convPostSt.pop();
            // solve the current
            opSt.push(solve(ch, op1, op2));
            convInfixSt.push("(" + inOp1 + ch + inOp2 + ")");
            convPostSt.push(postOp1 + postOp2 + ch);
        }else continue;
    }
    System.out.println(opSt.peek());
    System.out.println(convInfixSt.peek());
    System.out.println(convPostSt.peek());
 }
 
 public static int solve(char optr, int op1, int op2){
     if(optr == '+') return op1 + op2;
     else if(optr == '-') return op1 - op2;
     else if(optr == '*') return op1 * op2;
     else return op1 / op2;
 }
 
}