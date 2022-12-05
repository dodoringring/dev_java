package dev_java.ch02;

public class For1{

  public static void main(String[] args) {
    for(int i=1; i<=3; i++){ //1. 선언 및 초기화 2.조건문 3. 증감연산자
      System.out.println(i);
    }
    
    int i=0; //0부터 4바퀴
    while(i<=3){
      System.out.println(i);
      //while문은 무한 루프 빠지지 않게 주의! 반드시 증감 연산자가 있는지 반드시 확인할것
      i++;
      // ++i;
    }
  }


}