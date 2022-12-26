package dev_java.design;
//단독으로 인스턴스화 불가능하다.- 구현체 클래스가 있어야한다.
//QuackBehavior qb =new MuteQuack();
//QuackBehavior qb =new Quack();
//QuackBehavior qb =new Squeak();


public interface QuackBehavior {
  // int i;//변수 선언 안된다.
  // final int j;
  // static int k;
  // static final int y;
  // public QuackBehavior(){}// 안된다.
  //메소드 선언시 인터페이스는 abstract예약어를 생략 할 수 있다.
  //인터페이스는 추상만 가능하니까.
  public abstract void quack();
  
}
