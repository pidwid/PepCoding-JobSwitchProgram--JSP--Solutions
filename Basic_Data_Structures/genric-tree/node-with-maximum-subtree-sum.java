// Node With Maximum Subtree Sum

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
  
  static Node ans;
  static int max;
  public static int sum(Node node){
      int sum = node.data;
      for(Node child: node.children){
          sum += sum(child);
      }
      if(sum > max){
          max = sum;
          ans = node;
      }
    System.out.print(ans.data + "@" + max);
      return sum;
  }
  
  public static class Pair{
      int sum;
      Node node;
      int maxSubTreeSum;
  } 
  
  public static Pair sumSubtree(Node node){
      Pair mp = new Pair();
      mp.sum = node.data;
      for(Node child: node.children){
          Pair cp = sumSubtree(child);
          mp.sum += cp.sum;
          if(cp.maxSubTreeSum > mp.maxSubTreeSum){
              mp.maxSubTreeSum = cp.maxSubTreeSum;
              mp.node = cp.node;
          }
      }
      if(mp.sum > mp.maxSubTreeSum){
          mp.maxSubTreeSum = mp.sum;
          mp.node = node;
      }
      
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
    // sum(root);
    Pair rp = sumSubtree(root);
    System.out.println(rp.node.data + "@" + rp.maxSubTreeSum);
  }

}