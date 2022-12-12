package dev_java.view.week3;

public class Mian {
  int i = 1;
  //메인클래스에서 서브클래스에 있는 변수를 사용하고싶다.
  
  

  public static void main(String[] args) {
    Sub s = new Sub();
    System.out.println(s.j);//전역변수만 .변수 이런형태 가능
    s.account();

  }
  
}
