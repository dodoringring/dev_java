package dev_java.network3;

public class MySonata extends Mycar {//추상 클래스에대한 구현체 클래스가 되려면 반드시 부모의 메소드를 재정의 해야된다.

  MySonata(){
    System.out.println("MySonata 호출 성공");
  }

  @Override//원형을 고치면 안된다. 선언문을 고치면 안됨.
  public void display() {
    System.out.println("나는 2023년형 소나타입니다.");
  }
  public static void main(String[] args) {
    MySonata ms=new MySonata();//상속관계 클래스있다면 부모의 생성자가 먼저 호출이된다. 부모에게 미리 선언되어있는 메소드를 아들이 재정의 해서 쓴다.

  }
}
