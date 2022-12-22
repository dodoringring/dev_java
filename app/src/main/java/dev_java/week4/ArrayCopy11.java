package dev_java.week4;

import java.util.Arrays;

public class ArrayCopy11 {
  public static void main(String[] args) {
    ArrayCopy1 a1 = new ArrayCopy1();//깊은복사
    System.out.println(Arrays.toString(a1.fruit2));
    System.out.println(Arrays.toString(a1.fruit));
    a1.fruit2=new String[]{"파인애플","키위"};//재정의
    System.out.println(a1.fruit2[1]);//nullexception
    
  }
}
