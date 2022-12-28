package dev_java.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//List-java.util.List(interface)-ArrayList, Vector입니다.
//결론-그래서 m메소드가 m2메소드보다 더 다양하다
public class MyB {
  void m(List<String> myNames){
    System.out.println("===========[[List<String>]]==========");
    for(String s:myNames){
      System.out.println(s);
    }
  }
  void m2(Vector<String> myNames){
    System.out.println("===========[[Vector<String>]]==========");
    for(String s:myNames){
      System.out.println(s);
    }
  }
  //JVM에서 제공하는 List에 대해서 구현체 클래스가 여러가지 있다.
  //생성부와 선언부의 타입이 서로 다를수 있다. -권장사항
  //권장하는 이유는 2가지 선택지가 있다.
  public static void main(String[] args) {
    MyB myB= new MyB();
    List<String> nickNames3=new Vector<>();
    nickNames3.add("사자");
    nickNames3.add("호랑이");
    nickNames3.add("표범");
    ArrayList <String> nickNames= new ArrayList<>();
    nickNames.add("토마토");//0
    nickNames.add("키위");//1
    nickNames.add("사과");//2

    Vector<String> nickNames2= new Vector<>();
    nickNames2.add("바나나");
    nickNames2.add("포도");
    nickNames2.add("딸기");
    myB.m(nickNames3);//9번이 호출된다.왜 15번은 안돼?-범위(=Scope. List보다 타입이 더 구체적이다. )가 작으니까
    myB.m(nickNames);
    // myB.m2(nickNames);
    myB.m(nickNames2);
    myB.m2(nickNames2);
  }
}
