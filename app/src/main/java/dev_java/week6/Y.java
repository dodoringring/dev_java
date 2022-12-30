package dev_java.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Y {
  public static void main(String[] args) {
    List<Integer> list=new ArrayList<>();
    Vector<Integer> vlist=new Vector();
    Integer[] is =new Integer[3];
    is[0]=1;
    is[1]=2;
    is[2]=3;
    //인터페이스 List에는 copyInto가 없어 벡터만 있어
    list.copyInto(is);//안됨
    vlist.copyInto(is);
    
  }
}
