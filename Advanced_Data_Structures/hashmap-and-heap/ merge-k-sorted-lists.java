// Merge K Sorted Lists

import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair>{
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
        int val, li, di;
        public Pair(int val, int li, int di){
            this.val = val;
            this.li = li;
            this.di = di;
        }
    }
    
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i = 0; i < lists.size(); i++){
          ArrayList<Integer> list  = lists.get(i);
          Pair temp = new Pair(list.get(0), i, 0);
          pq.add(temp);
      } 
      while(pq.size() > 0){
          Pair np = pq.remove();
          rv.add(np.val);
          if(lists.get(np.li).size() > np.di + 1){
              pq.add(new Pair(lists.get(np.li).get(np.di+1), np.li, np.di+1));
          }
      }

      return rv;
   }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}