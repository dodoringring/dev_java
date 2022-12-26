package dev_java.design;

public class Quack implements QuackBehavior {

  @Override
  public void quack() {
    //삑삑인지 무음인지 꽥꽥인지는 언제 누가 어디에서 결정할 수 있을까?
    //언제? 해당 기능이 요청될 때
    //누가? 구현하고자하는 객체가 무엇인가에 따라서 Duck myDuck=new WoodDuck();
    //누가? 구현하고자하는 객체가 무엇인가에 따라서 Duck myDuck=new MallardDuck();
    //누가? 구현하고자하는 객체가 무엇인가에 따라서 Duck myDuck=new RubberDuck();
    System.out.println("꽥꽥");
    
  }
  
}
