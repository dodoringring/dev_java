package dev_java.ch03.table;

import java.util.Arrays;
//깊은 복사의 경우 객체의 실제 값을 새로운 객체로 복사
//얕은 복사의 경우 객체의 주소 값만을 복사 하는 것
//
public class ArrayCopy1 {
  void deepCopy2(){
    int[]org ={1,2,3,4,5};
    int[]cop=Arrays.copyOf(org,2);//부분 카피
    cop[1]=5;
    for(int e:org){
      System.out.println(e);
    }
    for(int e:cop){
      System.out.println(e);
    }
    
    }


  void deepCopy(){
  int[]org ={1,2,3};
  int[] cop=org.clone();//통으로 카피
  cop[2]=5;
  for(int e:org){
    System.out.println(e);
  }
  for(int e:cop){
    System.out.println(e);
  }
  
  }
  public static void main(String[] args) {
    ArrayCopy1 ac1=new ArrayCopy1();
    ac1.deepCopy2();
  //   int[] org={1,2,3};
  //   int[] org_copy=org;
  //   org_copy[2]=5;

  //   for(int e:org){
  //   System.out.println(e);
  // }
  // for(int e:org){
  //   System.out.println(e);
  // }
  }
  
}
/*
 * 배열복사
 * 얕은 복사
 * 
 * 깊은 복사
 * 
 */