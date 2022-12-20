package dev_java.week4;

import lombok.Data;

@Data
class CarVO {
  private int speed;
  private String carColor;
  private int wheelNum;
  //직관적이다.
  //insert here
  //전역변수가 갖는 스피드의 값은 무엇무엇무엇이다? 다른이유는 ~때문이다.
  CarVO(){}
  CarVO(int speed){//new CarVO(30);호출했다면?
    this.speed=speed;
  }
  
  CarVO(int speed, String carColor){//new CarVO(50,"검정색"); 으로 생성하면?
    this.speed=speed;
    this.carColor=carColor;
  }
  
  CarVO(int speed, String carColor,int wheelNum){
    this.speed=speed;
    this.carColor=carColor;
    this.wheelNum=wheelNum;
  }
  @Override
  public String toString(){//여러 타입 친구들을 스트링 타입으로 보내주는 메소드. 이 자체를 실행 콘솔에 찍어준다.
    return "내자동차는 "+carColor+"이고, 바퀴수는 "+wheelNum+"이고, 현재속도는 "+speed+"입니다.";
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public String getCarColor() {
    return this.carColor;
  }

  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }

  public int getWheelNum() {
    return this.wheelNum;
  }

  public void setWheelNum(int wheelNum) {
    this.wheelNum = wheelNum;
  }




}

public class CarVOMain{
  public static void main(String[] args) {
    // new CarVO(50,"검정색");
    CarVO cvo1=new CarVO();
    CarVO cvo2=new CarVO(50,"검정색");
    CarVO cvo3=new CarVO(50,"검정색",4);
    CarVOMain carVOMain=new CarVOMain();
    System.out.println(carVOMain);
    System.out.println(cvo1);
    System.out.println(cvo2);
    System.out.println(cvo3);
  }
  
}
