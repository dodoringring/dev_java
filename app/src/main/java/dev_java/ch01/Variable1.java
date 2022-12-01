package dev_java.ch01;

public class Variable1 { // 클래스 안에는 변수와 메소드를 선언할 수 있다.
  int x;

  void methodA() {
    // 나는 파라미터가 없는 메소드입니다.-소통은 없다. 듣지않겠다.
    // 나는 반환형이 없다. void(<->retrun)
    // 반환형이 없으면 값을 돌려받을 수 없나요? 없다.
    int i;// 지역변수
    i = 1;// 지역변수는 초기화(=뭐다)를 생략할 수 없다.
    x = i;// 전역변수를 사용해서 지역변수를 넣어줌-->밖에서 사용할 수 있다.
    System.out.println("i" + i);

  }

  public static void main(String[] args) {
    // insert here
    // System.out.println(x);//non-static타입이므로 절대 쓸수없다. 같은 static만 됨.
    // // 할려면 인스턴스화 아님 스테틱 붙여주기

    Variable1 variable1 = new Variable1();// variable이 클래스 급이다???
    System.out.println(variable1.x);// 순서 중요 인스턴스화 선언이 사용보다 앞에 와야한다.
    // 인스턴스변수.전역변수 가능. 지역변수 노가능
    variable1.methodA();// 메인에서 안불러주면 그냥메소드는 사용못함.
    System.out.println("x는" + variable1);

  }

}
