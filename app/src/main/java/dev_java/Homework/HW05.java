package dev_java.Homework;
// 2022년 12월 5일 숙제 피보나치 수열의 규칙을 만족하는 프로그램을 작성하고

// a1에서 a10번째 항까지 출력되도록 해보시오.

public class HW05 {
  // 0,1,1,2,3,5,8,13,21,34,55

  public static void main(String[] args) {
    int a = 0;
    int b = 1;
    int c = 1;

    for (int i = 1; i <= 10; i++) {

      System.out.println(c);
      c = a + b;
      a = b;
      b = c;
    }
  }

}
