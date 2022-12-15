package dev_java.ch03.table;

import java.util.Vector;//

public class Vector2 {

  public static void main(String[] args) {
    
    Vector <String> v=new Vector<>();
    v.add("사과");
    v.add("토마토");
    v.add(1,"바나나");//끼워 넣기가 가능하다
    for(int i=0; i<v.size();i++){
    System.out.println(v.get(i));//벡터는 get으로 정보를 가져와
    }
    
  }
  
}
