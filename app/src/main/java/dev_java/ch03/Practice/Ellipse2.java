package dev_java.ch03.Practice;
//접근제한자 private > friendly(같은 클래스 친구들만 쓸수있다) > protected(상속관계의 아빠는 쓰기 가능) > public
//static - 변수앞에,메소드앞에, 클래스앞에
//final-변수앞에(상수)-메소드앞에(오버라이딩 불가)-클래스 앞에(상속안됨- 자손못가짐)

import java.util.Scanner;

public class Ellipse2 {
  //선언부- 전역변수는 초기화를 생략 가능하다. 왜냐하면 생성자가 해 주니까.
  double area=0.0;
  final double PI=3.14; // final재정의가 불가능하다. PI=2.5;//불가능하다. 

  //리턴타입을 결정할 수 있나요? 네- 메인에서 면적 출력할거니?
    //파라미터의 갯수와 타입도 선택 할 수 있니? 네
  double 면적구하기(int i1,int i2){//메인에서 출력할 때 double로 리턴타입을 결정. 메소드에서출력하려면 void로 리턴타입 결정.
    area=i1*i2*PI;//Int*double은 더블이 이긴다. 자동 형전환
    return 0.0;
    // return 3;//자동형전환
    // return (float)3.5; //강제 형전환
  }

  //자바에서는 같은 이름의 메소드를 중복 선언할 수 있다.
  //단, 파라미터의 갯수가 다르거나 타입이 달라야 한다.-메소드 오버로딩
  double 면적구하기(){
    return 0.0;
  }
  public static void main(String[] args) {
    Ellipse2 e2=new Ellipse2();
    
    int r1=0, r2=0;//반지름 2개 담을 변수 선언
    
    Scanner s = new Scanner(System.in);//인스턴스화-메모리에 로딩-메소드나 변수 누린다.
    System.out.print("첫번째 반지름 입력하세요");
    String user1=s.nextLine(); //호출. 구현이면 {}
    System.out.println("사용자가 입력한 첫번째 반지름은 ==="+user1);
    System.out.println("두번째 반지름을 입력하세요");
    String user2=s.nextLine();
    int i1=Integer.parseInt(user1); //첫번째 반지름을 원시형으로 바꿈 왜? 곱셈해야되니까.
    int i2=Integer.parseInt(user2); //두번째 반지름을 원시형으로 바꿈 왜? 곱셈해야되니까.
    
    e2.면적구하기(i1,i2);//파라미터로 값을 넘겨준다******
    System.out.println("타원형의 면적은"+e2.area+"입니다."); //Ellipse.area는 안된다.  area가 스태틱이 아니니까. 스태틱=공유=하나
    
  }
    
  }
  

