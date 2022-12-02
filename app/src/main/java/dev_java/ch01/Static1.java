package dev_java.ch01;

public class Static1 {
  static{
    System.out.println("static 블록호출");
  }
  //메인 쓰레드라고 한다
  //메인은 엔트리 포인트이다
  //메인은 개발자가 호출하는 메소드가 아니다
  //시스템이 자동으로 호출해준다--콜백메소드
  //메인 메소드에 코딩 하는것은 좋지 않다.-초보다
  //메인 메소드에 작성한 코드는 재사용성이 없다.
  //클래스 안에 메인 메소드는 없어도 된다. 단, 실행은 불가하다.
  
  public static void main(String[] args) {
    System.out.println("main 호출");
  }
}
