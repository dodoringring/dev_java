package dev_java.assignmentTest.Dec;

import java.util.Arrays;

public class Test2_4 {

  
  public static void main(String[] args) {

    for(int i=2;i<=9;i+=2){
      System.out.println(2+"*"+i+"="+(2*i));
    }
    

    // int[] arr={2,4,6,8};
    int[] arr2= new int[4];
    for(int i =2; i<10; i+=2){
      arr2[(i/2)-1]=i;
      for(int j:arr2){
        System.out.println(2+"*"+j+"="+(2*j));
      }
    }

  }
  
}
