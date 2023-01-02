package dev_java.assignmentTest.Dec;
//자바 같은이름 메소드 중복선언
//메소드 오버로딩-이것과 관계 생성자 컨셉
//메소드 오버라이딩-문제와 상관없다
//무조건 파라미터 개수가 달라야한다
//접근제한자가 있고없고는 영향이 없다
//리턴타입이 있고 없고는 영향이 없다
//예외를 던지는것은 영향이 없다
//파라미터의 변수 이름이 다른것은 영향이 없다
//


public class Test2_1 {

  public void methodA(){}
  // public void methodA(){retrun 1;}
  public void methodA(int a){}
  public void methodA(int b){}
  //나를 호출한 곳에서 예외처리를 받으세요
  public void methodA(int a) throws Exception{}


  public void test(){}//오류이다. 아래에 같은 이름의 파라미터가 없는 메소드가있다. 리턴타입이 있고 없고는 메소드 오버로딩에 상관이 없다.
  public void test(String str){}//오류이다. 같은 String 타입의 파라미터 하나를 가지는 같은 이름의 메소드가 있다.
  public void test(int i){}//오류이다. 같은 int타입의 파라미터를 가지는 test메소드가 있다. 접근제한자가 달라도 오버로딩 안된다.
  public void test(String s){}//오류이다. 같은 String 타입의 파라미터 하나를 가지는 같은 이름의 메소드가 있다.
  public void test(char ch){}
  public void test(String str, int i){}
  public void test(int i, String str){}
  private void test(int i){}//오류이다. 같은 int타입의 파라미터를 가지는 test메소드가 있다. 접근제한자가 달라도 오버로딩 안된다.
  public void test(){return 0;}//오류이다. 위에 같은 이름의 파라미터가 없는 메소드가있다.리턴타입이 있고 없고는 메소드 오버로딩에 상관이 없다

  
}
