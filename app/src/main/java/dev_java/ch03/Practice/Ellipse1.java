package dev_java.ch03.Practice;
//접근제한자 private > friendly(같은 클래스 친구들만 쓸수있다) > protected(상속관계의 아빠는 쓰기 가능) > public
//static - 변수앞에,메소드앞에, 클래스앞에
//final-변수앞에(상수)-메소드앞에(오버라이딩 불가)-클래스 앞에(상속안됨- 자손못가짐)

import java.util.Scanner;

public class Ellipse1 {
  public static void main(String[] args) {
    int r1=0, r2=0;//반지름 2개 담을 변수 선언
    double area=0.0;
    final double PI=3.14; // final재정의가 불가능하다. PI=2.5;//불가능하다. 
    // new다음에 오는 클래스가 생성됨-이때 생성자 호출됨(마치 메소드처럼)
    Scanner s = new Scanner(System.in);//인스턴스화-메모리에 로딩-메소드나 변수 누린다.
    System.out.print("첫번째 반지름 입력하세요");
    String user1=s.nextLine(); //호출. 구현이면 {}
    System.out.println("사용자가 입력한 첫번째 반지름은 ==="+user1);
    System.out.println("두번째 반지름을 입력하세요");
    String user2=s.nextLine();
    int i1=Integer.parseInt(user1); //첫번째 반지름을 원시형으로 바꿈 왜? 곱셈해야되니까.
    int i2=Integer.parseInt(user2); //두번째 반지름을 원시형으로 바꿈 왜? 곱셈해야되니까.
    area=i1*i2*PI;//Int*double은 더블이 이긴다. 자동 형전환
    System.out.println("타원형의 면적은"+area+"입니다.");
    
  }
    
  }
  

