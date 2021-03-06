// Shortest Path In Weights Dijkstra

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   static class Pair implements Comparable<Pair>{
       int v;
       int wsf;
       String psf;
       Pair(int v, int wsf, String psf){
           this.v = v;
           this.wsf = wsf;
           this.psf = psf;
       }
       public int compareTo(Pair n){
           return this.wsf - n.wsf;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" "   );
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      
      PriorityQueue<Pair> q = new PriorityQueue<>();
      boolean[] visited = new boolean[vtces];
      q.add(new Pair(src, 0, src + ""));
      
     while(q.size() > 0){
         Pair rem = q.remove();
         if(visited[rem.v] == false){
             visited[rem.v] = true;
             System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
             for(Edge e : graph[rem.v]){
                 if(visited[e.nbr] == false){
                     q.add(new Pair(e.nbr, rem.wsf + e.wt, rem.psf + e.nbr));
                 }
             }
         }
     }
      
   }
}











