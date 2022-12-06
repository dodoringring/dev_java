package dev_java.week2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTest2 {
  @DisplayName("0부터 9사이의 숫자 채번하기")
  @RepeatedTest(10)//반복된 테스트 하기 위해 사용되는 이노테이션
  void methodA(){
    int com=(int)(Math.random()*10);//Math세트 계산하는 애들. 그중하나가 랜덤메소드. 기본 형태는 double이다. 0.0~1.0 에서 랜덤으로 하나 뽑는다. int로 바꾼다 캐스팅 해준다.
    // int로 캐스팅 한 상태
    com=(int)(Math.random()*10);
    double com2=(Math.random()*10);
    System.out.println(com+","+com2);
  }
  
}
