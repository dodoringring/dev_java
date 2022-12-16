package dev_java.ch03.table;

import java.util.Vector;

public class Vector4 {
  public static void main(String[] args) {
    String fruits[]= {"키위", "포도", "사과"};
    Vector<String> vfruits =new Vector<>();
    for(int i=0;i<fruits.length;i++){
    vfruits.add(i,fruits[i]);
    }
    vfruits.add(1,"토마토");
    for(int i=0; i<vfruits.size();i++){
    System.out.println(vfruits.get(i));
    }

    // for(int i=0;i<vfruits.size();i++){
    //   if(i==3){
    //   vfruits.remove()
    //   }

    // }
    vfruits.remove(2);
    System.out.println(vfruits);
  }
  
}
