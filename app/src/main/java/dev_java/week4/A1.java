package dev_java.week4;

import java.util.Vector;

public class A1 {
  int ival=1;
  public static void main(String[] args) {
    A1 a1=new A1();
    a1.ival=10;
    System.out.println(a1);
    Vector<Integer> v =new Vector();
    v.add(a1.ival);
    a1=null;//객체 초기화하면 다음라인 넘어갈때 캔디데이트 상태가 됨
    a1=new A1();
    v.add(a1.ival);
    a1.ival=20;
    System.out.println(a1);
    //insert here ival을 10으로 다시 출력하고싶다...어떻게?
    System.out.println(v.get(0));
  }
  
}
