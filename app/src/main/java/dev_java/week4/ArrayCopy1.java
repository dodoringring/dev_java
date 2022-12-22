package dev_java.week4;

import java.util.Arrays;

public class ArrayCopy1 {
  String fruit[]={"사과","딸기","바나나"};
  String fruit2[];
  public ArrayCopy1(){
  }
  
  public ArrayCopy1(String[] arr){
    fruit2=fruit;//이것이 얕은 복사이다.
    fruit2[1]="키위";
    System.out.println(Arrays.toString(fruit));
    System.out.println(Arrays.toString(fruit2));
  
  }
 
}
