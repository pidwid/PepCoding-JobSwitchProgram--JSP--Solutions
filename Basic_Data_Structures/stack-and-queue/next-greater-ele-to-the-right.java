//Next greater element to the right

import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }
 public static int[] solve(int[] arr) {
    int[] ans = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
        // pop all smaller element
        while (st.size() > 0 && st.peek() < arr[i]) st.pop();
        
        // update ans
        if(st.size() == 0) ans[i] = -1;
        else ans[i] = st.peek();
        
        // push current element
        st.push(arr[i]);
    }
    return ans;
  }
  

/**
 Left to right sol

   public static int[] solve(int[] arr) {
    int[] ans = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    st.push(0);
    for (int i = 1; i < arr.length; i++) {
        // pop all smaller element
        while (st.size() > 0 && arr[st.peek()] < arr[i]){
            ans[st.pop()] = arr[i];
        }
        st.push(i);
    }
    while(!st.isEmpty()){
        ans[st.pop()] = -1;
    }
    return ans;
  }

 */

// My Sol {In place}
/**
 public static int[] solve(int[] arr){
    Stack<Integer> st = new Stack<>();
    for(int i = arr.length - 1; i >= 0; i--){
        if(st.isEmpty()){
            st.push(arr[i]);
            arr[i] = -1;
        }
        else if(st.peek() < arr[i]){
            while(!st.isEmpty() && st.peek() < arr[i]) st.pop();
            if(st.isEmpty()){
                st.push(arr[i]);
                arr[i] = -1;
            }else{
                int temp = arr[i];
                arr[i] = st.peek();
                st.push(temp);
            }
        }else{
            int temp = arr[i];
                arr[i] = st.peek();
                st.push(temp);
        }
        
    }
   return arr;
 }
 */
}