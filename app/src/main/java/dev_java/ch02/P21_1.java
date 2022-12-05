package dev_java.ch02;

public class P21_1 {

  public static void main(String[] args) {
    int i =1;
    switch(i){//조건에 따라 실행문을 진행할 수 있는 틀을 제공하는 예약어
      case 0: 
      ++i;//실행문1
      
      case 1: //i가 1이므로 여기로온다.
      ++i; //i=2 실행문2
      break; //switch문 탈출

      default:
      ++i; //i=3
    }//end of switch
    //insert here--i는 얼마일까요?
    System.out.println(i);
  }
  
}
