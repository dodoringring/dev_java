package dev_java.week2;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
//@ : 어노테이션
public class RepeatedTest1 {
  @Test
  @DispalyName("두 수 비교 테스트")
  void methodb(){
    assertEquals(2,1+2);
  }




  @RepeatedTest(15)

  void methodA(){
    Random r = new Random();
    int i = r.nextInt(10);
    System.out.println(i);
  }

  
}
