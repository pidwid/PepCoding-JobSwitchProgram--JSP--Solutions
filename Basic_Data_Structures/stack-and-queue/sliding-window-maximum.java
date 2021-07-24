// Sliding Window Maximum

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
    int k = Integer.parseInt(br.readLine());
    
    /** Stack
    Stack<Integer> st = new Stack<>();
    int[] ngr = new int[n];
    for(int i = n-1; i >= 0; i--){  
        // pop all smaller
        while(!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
        if(st.isEmpty()) ngr[i] = arr.length;
        else ngr[i] = st.peek();
        // push curr index
        st.push(i);
    }
    for(int i = 0, j = 0; i <= n - k; i++){
        int window = i+k;
        if(j < i) j = i;
        while(ngr[j] < window) j = ngr[j];
        System.out.println(arr[j]);
    }
    */
    
    // doubly ended queue
    Deque<Integer> dq = new ArrayDeque<>();
    // get max ele of first k values
    for(int i = 0; i < k; i++){
        // pop all smaller
        while(!dq.isEmpty() && arr[dq.getLast()] < arr[i]) dq.removeLast();
        dq.addLast(i);
    }
    System.out.println(arr[dq.getFirst()]);
    for(int i = k; i < n; i++){
        while(!dq.isEmpty() && arr[dq.getLast()] < arr[i]) dq.removeLast();
        dq.addLast(i);
        // dq in range
        if(dq.getFirst() <= i - k) dq.removeFirst();
        System.out.println(arr[dq.getFirst()]);
    }
 }
}