package dev_java.assignmentTest;

public class Money {
  public Money(){//디폴트 생성자가 자동으로 생성되지 않기때문에 
    //Run에서 사용하려면 디폴트 생성자를 만들어야한다.
  }

  public static final String UNIT="원";
  private int money;

  public int getMoney() {
    return this.money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public Money(int money){//파라미터 있는 생성자
    this.money=money;
  }

  public static String getUnit(){
    return UNIT;
  }

  public void print(){
    System.out.println(money + UNIT +"이 있습니다.");
  }
  
}
