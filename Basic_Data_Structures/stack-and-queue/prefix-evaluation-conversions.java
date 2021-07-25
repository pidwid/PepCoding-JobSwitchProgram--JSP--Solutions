// Postfix Evaluations Conversions

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    solvePost(exp);
    
 }

 public static void solvePost(String str){
    Stack<Integer> opSt = new Stack<>();
    Stack<String> convInfixSt = new Stack<>();
    Stack<String> convPreSt = new Stack<>();
    
    for(char ch : str.toCharArray()){
        if(ch >= '0' && ch <= '9'){
             opSt.push(ch - '0');
             convInfixSt.push(ch + "");
             convPreSt.push(ch + "");
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            int op2 = opSt.pop();
            int op1 = opSt.pop();
            String inOp2 = convInfixSt.pop();
            String inOp1 = convInfixSt.pop();
            String preOp2 = convPreSt.pop();
            String preOp1 = convPreSt.pop();
            // solve the current
            opSt.push(solve(ch, op1, op2));
            convInfixSt.push("(" + inOp1 + ch + inOp2 + ")");
            convPreSt.push(ch + preOp1 + preOp2);
        }else continue;
    }
    System.out.println(opSt.peek());
    System.out.println(convInfixSt.peek());
    System.out.println(convPreSt.peek());
 }
 
 public static int solve(char optr, int op1, int op2){
     if(optr == '+') return op1 + op2;
     else if(optr == '-') return op1 - op2;
     else if(optr == '*') return op1 * op2;
     else return op1 / op2;
 }
 
 public static int precedence(char ch){
     if(ch == '*' || ch == '/') return 2;
     else if(ch == '+' || ch == '-') return 1;
     else return 0;
 }
}