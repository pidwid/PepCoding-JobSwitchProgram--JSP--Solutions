// Diameter Of Generic Tree

import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  static int diameter = 0;
    public static int height(Node node) {
        int maxht = -1, smht = -1;
        for (Node child : node.children) {
            int hofc = height(child);
            if(hofc > maxht){
                smht = maxht;
                maxht = hofc;
            }else if(hofc > smht) smht = hofc;
        }
    diameter = Math.max(diameter, maxht + smht + 2);
    return maxht + 1;
  }
  
  public static class Pair{
      int ht;
      int diameter;
  }
  
  public static Pair height2(Node node){
      Pair mp = new Pair();
      int maxht = -1, smht = -1;
      for (Node child : node.children) {
          Pair cp = height2(child);
          mp.diameter = Math.max(cp.diameter, mp.diameter);
            if(cp.ht > maxht){
                smht = maxht;
                maxht = cp.ht;
            }else if(cp.ht > smht) smht = cp.ht;
      }
      mp.diameter = Math.max(maxht + smht + 2, mp.diameter);
      mp.ht = 1 + maxht;
      return mp;
  }
  
  

  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    // height(root);
    // System.out.print(diameter);
    Pair res = height2(root);
    System.out.print(res.diameter);
  }

}