package dev_java.ch03;

public class Array1 extends Object{ //상속-extends Object 생략 가능. 재사용, 확장, 오버라이딩... 재정의 해서 쓴다.

  public static void main(String[] args) {
    //선언과 생성을 나눠서 할 수 있다.
    //이른 주입인가 아니면 게으른 주입인가?
    //게으른 인스턴스화는 선언과 생성을 분리함
    //이른 인스턴스 화는 선언부에 선언과 생성을 한번에 하는 것이다. 한문장으로
    int i[]; //배열 생성
    //int j[3]=new int[3]// 이른 인스턴스화
    i=new int[3];//초기화
    //초기화가 안됐다. 아직  0 0 0(디폴트값)
    //객체배열 null,null,null
    System.out.println(i[0]);

    try{//예외가 발생할 가능성이 있는 코드를 감싼다. try-catch로
      //문법에러는  Exception과는 상관이 없다.-런타임 에러
    System.out.println(i[3]);
    }catch(ArrayIndexOutOfBoundsException e){
      System.out.println("인덱스가 범위를 넘었다.");
    }
  }
  
}
