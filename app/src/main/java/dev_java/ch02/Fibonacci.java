package dev_java.ch02;

public class Fibonacci {
  void action() {
    int a1 = 1;
    int a2 = 1;
    int a3 = 0;// 그냥 초기화 값.
    System.out.print(a1 + " " + a2 + " ");// 줄바꿈 없이 옆으로
    for (int i = 0; i < 8; i++) {
      a3 = a2 + a1;
      System.out.print(a3 + " ");
      a1 = a2;// 두번째 수를 세번째 수로
      a2 = a3;// 현재의 수를 세번째 수로
    }
  }

  public static void main(String[] args) {
    // insert here-action 메소드를 호출하시오.
    Fibonacci fibo = new Fibonacci();
    fibo.action();

  }
}
