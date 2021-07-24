// Largest Area Histogram
import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    } 

    Stack<Integer> st = new Stack<>();
    int[] nsr = new int[n], nsl = new int[n];
    // nsr
    for(int i = n-1; i >= 0; i--){
        // pop all bigger element
        while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
        // update ans
        if(st.isEmpty()) nsr[i] = arr.length;
        else nsr[i] = st.peek();
        // push current index
        st.push(i);
    }
    // renew stack
    st = new Stack<>();
    
    // nsl
    for(int i = 0; i < n; i++){
        // pop all bigger element
        while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
        // update ans
        if(st.isEmpty()) nsl[i] = -1;
        else nsl[i] = st.peek();
        // push current index
        st.push(i);
    }
    // answer
    int ans = 0;
    for(int i = 0; i < n; i++){
        ans = Math.max(ans, arr[i] * (nsr[i] - nsl[i] - 1));
    }
    System.out.print(ans);  
 }
}