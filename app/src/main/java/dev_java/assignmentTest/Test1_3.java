package dev_java.assignmentTest;

public class Test1_3 {

  public static void main(String[] args) {
    int[] arr = new int[4];

    for (int i = 0; i< arr.length; i++){ //i<=4 i=0,1,2,3,4
      arr[i]+=(10+i);//arr[i]=arr[i]+(10+i)
  
      System.out.println(arr[i]);
    }
  }

  } 
  

