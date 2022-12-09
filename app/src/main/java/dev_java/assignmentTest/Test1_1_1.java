package dev_java.assignmentTest;

import java.util.Scanner;

public class Test1_1_1 {

  public void count() {
    System.out.println("count호출");// 로그에 출력할 값
    Scanner s = new Scanner(System.in);
    boolean isOk = false;
    while (!isOk) {
      System.out.print("문자열을 입력해주세요. : ");
      String str = s.nextLine();
      if ("exit".equals(str)) {
        break; // 반드시 브레이크
      } else {
        System.out.println(str.length() + "글자입니다.");
      }
    } // end of while
    s.close();
    System.out.println(("프로그램을 종료합니다."));
  }// end of count()

  public static void main(String[] args) {
    Test1_1_1 t1 = new Test1_1_1();
    t1.count();
  }

}
