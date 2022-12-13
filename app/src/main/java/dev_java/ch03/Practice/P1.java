package dev_java.ch03.Practice;
/*
 * 연습문제 1
다음은 타원의 면적을 구하는 공식입니다. 작은 반지름과 큰 반지름을 입력받아서 타원의 면적을 구하세요.
  반지름은 정수이고, pi는 3.1416입니다.
  계산은 소수점 2자리 까지 합니다.
  공식)  타원면적 =  pi * r1 * r2 
  3.14로 계산
  출력) 반지름(2개) : 10 20
  타원의 면적 : 628.32
  integerParseInt 써서 해보자
  변수 세개 필요하다 반지름 두개랑 면적
 */

import java.util.Scanner;

public class P1 {

  public static void main(String[] args) {
    int r1 = 10;
    int r2 = 20;
    double area = 0.0;

    Scanner s = new Scanner(System.in);
    String user1=s.nextLine();
    String user2=s.nextLine(); //인트로 바꿔야 곱하기 할 수 있다. 형전환
    Integer.parseInt(user1, user2); //parseInt는 공통적으로 다 쓰는 기능이다. 스태틱이다.소유주 + 다트연산자를 써준다.
    // Static int parseInt(String s) 이게 원형이다.


  }
  
}
