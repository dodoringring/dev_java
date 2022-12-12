package dev_java.view.week3;

public class Main_2 {
  int i = 1;
  //메인클래스에서 서브클래스에 있는 변수를 사용하고싶다.
  boolean isOk[]=null;//배열은 안정해졌으면 무조건 널이다
  //디폴트 생성자는 생략이 가능하다. 
  // 그러나 지금은 isOk배열의 생성을 위해서 getisOk()를 경유하도록 해야지 nullpointException을 피할 수 있다.
  public Main_2(){//생성자가 없어서 만들어줌?? 클래스와 이름이 같고 반환 타입이 없으면 생성자이다.
    System.out.println("Main_2()디폴트 생성자 호출 성공");
    getisOk();//배열을 리턴하는 메소드를 갖고옴
  }
  //선언과 동시에 인스턴스화응 하지 않는 경우 게으른 인스턴스화라고 한다.
  //선언과 생성을 동시에 하지 않고 메소드를 통해서 객체 주입을 받을 수 있음
  //이럴 경우 메소드 안에서 if문을 사용해 널체크를 할 수 있어 싱글톤 패턴으로 객체를 주입
  //주입 받을 수 있어 현업에서 선호하는 객체 주입 방법 중 하나입니다.
  boolean[] getisOk(){//배열을 리턴하는 메소드
    isOk=new boolean[]{ true, false, true};
    return isOk;
  }
  

  public static void main(String[] args) {
    Sub s = new Sub();
    System.out.println(s.j);//전역변수만 .변수 이런형태 가능
    s.account();

  }
  
}
