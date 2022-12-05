package dev_java.Homework;//생성자 개념 이해해보기!!!!

public class WhileTest1_5 {
  int i;//default 0
  int hap;//지변 아니라 전역변수
  //디폴트 생성자라고 부른다-디폴트 생성자는 파라미터를 결정해줄필요없다 생략하면 
  //JVM이 대신 생성해주어 전변들을 초기화 시킨다.
  public WhileTest1_5(){//클래스 이름이랑 똑같은 메소드 : 생성자
    System.out.println("디폴트 생성자 호출 성공"); //초기화가 안되어있음 i,hap 출력가능
  //0 0
  }
  public WhileTest1_5(int i, int hap){
    System.out.println("파라미터가 두개인 생성자 호출 성공");//1,0이 출력된다. 두개세개이든 얼마든지 생성자 만들기 가능. 초기화 가능
    //타입 다르거나 갯수 
    this.i=i; //왜 디스? 그냥....?
    this.hap=hap;//몰르겠어요ㅠ
  }
  public static void main(String[] args) {//변수이름이 바뀐건 영향이 없다. 파라미터의 변수 형태가 다른것만...?
    WhileTest1_5 mi = new WhileTest1_5();//8번 생성자가 호출되는 것이다.-메소드 오버로딩 메카니즘 따른다.
    WhileTest1_5 m2 = new WhileTest1_5(1,0);
    
  }
  
}
