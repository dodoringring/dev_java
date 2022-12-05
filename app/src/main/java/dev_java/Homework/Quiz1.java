package dev_java.Homework;

public class Quiz1 {
  // 문제 1
  // 1부터 10까지의 합을 구하는 프로그램을 작성하시오.

  public static void main(String[] args) {
    // 합을 담을 변수 선언
    // 1씩 세는 변수 선언
    int tot = 0; // 지역 변수니까 초기화를 해야한다.
    // 0으로 초기화 하는 이유는 답에 영향을 주면 안되니까
    int cnt;
    cnt = 1;
    // for(초기화;조건식;증감연산자){}

    for (; cnt <= 10; cnt = cnt + 1) {
      tot = tot + cnt; // 1
      System.out.println("tot:" + tot + ",cnt:" + cnt);

    }

  }

}
