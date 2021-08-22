// K Largest Elements

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      
      /** SHORTCUT nlogn
      Arrays.sort(arr);
    
      for(int i = n - k; i < n; i++){
        System.out.println(arr[i]);
      }
        */
        
      // using default priority queue
      // priorty given to minimum element
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      /** 
       // BruteForce nlogn
      for (int i = 0; i < n; i++) {
         pq.add(arr[i]);
      }
      while(pq.size() > 0){
          if(pq.size() > k) pq.remove();
          else {
              int a = pq.remove();
              System.out.println(a);
          }
      }
      */
      
      // Team Selection  nlogk
      for(int i = 0; i < n; i++){
          if(i < k) pq.add(arr[i]);
          else{
             if(arr[i] > pq.peek()){
                 pq.remove();
                 pq.add(arr[i]);
             }
          }
      }
      while(pq.size() > 0) System.out.println(pq.remove());
      
  }
}
    
  