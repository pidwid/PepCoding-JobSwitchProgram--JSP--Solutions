// Infix evaluation
import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    System.out.print(solveInfix(exp));
    
 }
 public static int solveInfix(String str){
    Stack<Character> optrSt = new Stack<>();
    Stack<Integer> opSt = new Stack<>();
    for(char ch : str.toCharArray()){
        if(ch >= '0' && ch <= '9') opSt.push(ch - '0');
        else if(ch == '(') optrSt.push(ch);
        else if(ch == ')'){
            while(optrSt.peek() != '('){
                char optr = optrSt.pop();
                int op2 = opSt.pop();
                int op1 = opSt.pop();
                int res = solve(optr, op1, op2);
                opSt.push(res);
            }
            // pop the '('
            optrSt.pop();
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(!optrSt.isEmpty() && precedence(optrSt.peek()) >= precedence(ch)){
                char optr = optrSt.pop();
                int op2 = opSt.pop();
                int op1 = opSt.pop();
                // solve the current
                opSt.push(solve(optr, op1, op2));
            }
            // push the current operator
            optrSt.push(ch);
        }else continue;
    }
    // solve till stack is Empty
    while(!optrSt.isEmpty()){
            char optr = optrSt.pop();
            int op2 = opSt.pop();
            int op1 = opSt.pop();
            int res = solve(optr, op1, op2);
            opSt.push(res);
        }
    return opSt.peek();
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