package dev_java.ch03.table;

import java.util.Vector;

public class Vector5 {
  public static void main(String[] args) {
    String fruits[]={"키위","포도","사과","토마토","메론","파인애플","바나나","복숭아"};
    String myFruits[]={"포도","메론","복숭아","사과","키위"};
    //좋아하는 과일만 골라서 벡터에 담아주세요
    Vector<String> vfruit = new Vector<>();
    for(int i=0;i<fruits.length;i++){
    for(int j=0;j<myFruits.length;j++){
      if(fruits[i].equals(myFruits[j])){
        vfruit.add(fruits[i]);
      }
    
    }

      

    }//end of for
    //구매한 과일 출력하시오.
    System.out.println("내가 좋아하는 과일은 ");
    for(String f:vfruit){
      System.out.println(f);
    }
  }//end of main
}
