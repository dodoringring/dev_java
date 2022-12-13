package dev_java.ch03.Practice;

class S1{
  static int i;//0. 전변의 성격. 글로벌하게 사용이 가능하다. 인스턴스화 없이 사용이 가능하다. 복제본 만들지 마라.
  static void m(){

  }
}
class S2{
  void n(){
    S1.i=500;
  }
}
public class StaticTest {

  public static void main(String[] args) {
    // insert here
    S1.i=10; //선언이 먼저다. 스태틱 전변이다. 타입+다트연산자로 할수있다. 인스턴스화 필요없다.
    S1 s1 = new S1();
    s1.i=100;//틀린거는 아니지만 쓰지 말아줄래...?
    System.out.println(S1.i);//100
    System.out.println(s1.i);//100 둘다 100이다. 왜? 스태틱은 원본이다. 하나를 바꾸면 원본을 바꾸는거다.
    S2 s2 = new S2();
    s2.n();//메소드 뒤에 ;이면 메소드 호출이다. n메소드 호출했니? 네. 경유했다.
    System.out.println("n()호출 후======>"+S1.i);//0? 10? 100? 500? 500이다.

  }
  
}
