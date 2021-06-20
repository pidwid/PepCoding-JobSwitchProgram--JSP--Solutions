// Ring Rotate

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int rows=scn.nextInt();
        int cols=scn.nextInt();
        int [][]arr=new int [rows][cols];
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        int s=scn.nextInt();
        int r = scn.nextInt();
        shellRotate(arr,s,r);
        display(arr);
        
    } 
    public static void shellRotate(int [][]arr,int s,int r){
        int [] la=fill1Dfrom2D(arr,s);
        rotate1D(la,r);
        fill2Dfrom1D(arr,la,s);
        
        
    }
    public static int [] fill1Dfrom2D(int[][]arr,int s){
        int minr=s-1;
        int minc=s-1;
        int maxr=arr.length-s;
        int maxc=arr[0].length-s;
        int size=(2*(maxr-minr))+(2*(maxc-minc));
        int [] a=new int[size];
        int count=0;
        for(int i =minr;i<=maxr;i++){
            a[count]=arr[i][minc];
            count++;
        }
        minc++;
        for(int j =minc;j<=maxc;j++){
            a[count]=arr[maxr][j];
            count++;
        }
        maxr--;
        for(int i=maxr;i>=minr;i--){
            a[count]=arr[i][maxc];
            count++;
        }
        maxc--;
        for(int j=maxc;j>=minc;j--){
            a[count]=arr[minr][j];
            count++;
        }
        return a;
        
    }
    public static void rotate1D(int[]la,int r){
        r=r%la.length;
        if(r<0){
            r=r+la.length;
        }
        reverse(la,0,la.length-r-1);
        reverse(la,la.length-r,la.length-1);
        reverse(la,0,la.length-1);
        
        
    }
    public static void reverse(int[]la,int left,int right){
        while(left<right){
            int temp=la[left];
            la[left]=la[right];
            la[right]=temp;
            // la[left]=la[left]+la[right];
            // la[right]=la[left]-la[right];
            // la[left]=la[left]-la[right];
            left++;
            right--;
            
        }
        
    }
    public static void fill2Dfrom1D(int[][]arr,int[]la,int s){
        int minr=s-1;
        int minc=s-1;
        int maxr=arr.length-s;
        int maxc=arr[0].length-s;
        int count=0;
        for(int i =minr;i<=maxr;i++){
            arr[i][minc]=la[count];
            count++;
        }
        minc++;
        for(int j =minc;j<=maxc;j++){
            arr[maxr][j]=la[count];
            count++;
        }
        maxr--;
        for(int i=maxr;i>=minr;i--){
            arr[i][maxc]=la[count];
            count++;
        }
        maxc--;
        for(int j=maxc;j>=minc;j--){
            arr[minr][j]=la[count];
            count++;
        }
        
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}