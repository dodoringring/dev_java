package dev_java.ch03.table;

import java.util.Vector;

public class Vector3 {

  public static void main(String[] args) {
    //객체는 생성되었으나 방은 없다
    Vector<Integer> v=new Vector<>();
    //그러니까 0
    System.out.println(v.size());//0
    //방이 비어있니?
    System.out.println(v.isEmpty());//true
    boolean isExist=v.add(1);//벡터에 값 넣기
    System.out.println(v.get(0));//값 가져오기 1
    System.out.println(isExist);//true
    System.out.println(v.isEmpty());//false

    System.out.println(v.contains(1));//flase->true
    v.add(1,2);//,앞의 칸에 두번째 숫자를 넣었다
    System.out.println(v.contains(2));
    System.out.println(v.remove(1));//1번째 칸의 2를 없앴다.
    boolean isOk =v.remove(new Integer(1)); //인터저라는 객체를 만들어 넣은것임
    System.out.println(v.size());
  }
  
}
