package dev_java.ch02;

public class DoWhile {

  public static void main(String[] args) {
    int i=1;
    //while문은 조건을 만족하지 않으면 단 한번도 실행 기회가 없다.
    while(i>3){//1이 3보다 크니?아니-->false
      System.out.println("while실행문 출력됨");
    }
    System.out.println("요기");
    //i값을 1로 초기화 한것은 동일한 조건에서 테스트 하기 위함이다.
    i=1;
    do{//do-while문은 조건을 나중에 따진다. 무조건 한번은 실행이 된다.

    }while(i>3);//조건문 i가 3보다 크다. 안크면 다시 do문 반복
  }
  
}
