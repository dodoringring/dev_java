package dev_java.ch01;

public class Method1 {
  // 파라미터 자리에는 비워두거나 원시형을 쓰거나 참조형도 올 수 있다.
  // 파라미터 자리는 호춛하는 곳에서 결정이 된다.
  // 파라미터 자리에 변수는 언제 초기화가 될까요?
  // 메소드 호출은 어디서 하지? 메인 메소드 안에서 해야 호출된다.
  // 메소드의 파라미터 자리는 오직 선언만 가능함.-초기화는 불가능 하다. -불법이다.
  void m(int i) {// 파라미터 자리에는 사용자가 입력한 값이 담김
    // void m(int i=5)안됨
    i = 5;// 가능
    System.out.println(i);
  }

  double m1(double d) {
    return 3.5;
  }

  void m() {

  }

  public static void main(String[] args) {
    Method1 method1 = new Method1(); // 내안에 static이 있더라도 non-static부를때는 인스턴스화 해야된다.
    // // Method
    // int i = 1;

    // method1.m(3.0);//3.0가능 3.0000001 안됨
    // 자바에서는 같은 이름의 메소드를 중복 정의 할 수 있다.
    // 단, 파라미터의 갯수가 다르거나 또는 타임이 다르면 인정해줄게
    method1.m(5);// 메소드 호출

  }

}
