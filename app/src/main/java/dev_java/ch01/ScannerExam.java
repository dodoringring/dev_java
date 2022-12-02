package dev_java.ch01;
//java.lang패키지 외 클래스들은 모두 import문을 추가해야된다. 클래스 생성안됨
//-하지않으면 컴파일 에러
import java.util.Scanner;

public class ScannerExam {

  public static void main(String[] args) {
    System.out.println("0부터 9까지의 숫자를 입력하세요.");
  //   java.Scanner scanner=new java.util.Scanner(System.in);
  //생성자이든 메소드이든 파라미터의 갯수 혹은 타입은 반드시 지킨다.
  Scanner scanner = new Scanner(System.in);//생성부의 파라미터 자리는 시스템의 입력장치정보
  String user = scanner.nextLine();
  scanner.close();// 스캐너 썼으면 닫아주세요^^

  //wrapper 원시형 타입을 객체처럼 쓸수있게 해준다.
  int i_user=Integer.parseInt(user);

  System.out.println(user+1);
  System.out.println(i_user+1);


  }
  
}
