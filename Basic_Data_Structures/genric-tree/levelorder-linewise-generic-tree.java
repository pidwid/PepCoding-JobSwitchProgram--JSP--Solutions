// Levelorder Linewise (generic Tree)

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

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewise(Node node){
        Queue<Node> q = new ArrayDeque<>(), cq = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0){
            node = q.remove();
            System.out.print(node.data + " ");
            for(Node child: node.children) cq.add(child);
            if(q.size() == 0) {
                q = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
  }

  public static void levelOrderLinewise2(Node node){
    Queue<Node> q = new ArrayDeque<>();
    q.add(node);
    Node n = new Node();
    n.data = -1;
    q.add(n);
    while(q.size() > 0){
        node = q.remove();
        if(node.data != -1){
          System.out.print(node.data + " ");
          for(Node child: node.children) q.add(child);
        }else{
          if(q.size() > 0) {
            q.add(n);
            System.out.println();
          }
        }
    }
}

public static void levelOrderLinewise3(Node node){
  Queue<Node> q = new ArrayDeque<>();
  q.add(node);
  while(q.size() > 0){
      int cici = q.size(); // count of children
      for(int i = 0; i < cici; i++){
        node = q.remove();
        System.out.print(node.data + " ");
        for(Node child: node.children) q.add(child);
      }
        System.out.println();
  }
}

private static class Pair{
  Node node;
  int level;

  Pair(Node node, int level){
    this.node = node;
    this.level = level;
  }
}

public static void levelOrderLinewise4(Node node){
  Queue<Pair> q = new ArrayDeque<>();
  q.add(new Pair(node, 0));
  int level = 0;
  while(q.size() > 0){
    Pair p = q.remove();
    if(p.level > level){
      level = p.level;
      System.out.println();
    }
    System.out.print(node.data + " ");
    for(Node child: node.children) q.add(new Pair(child, p.level + 1));
  }
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
    levelOrderLinewise(root);
  }

}