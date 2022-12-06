package dev_java.ch02;
/*3가지 타입
부서번호,사원번호 관리
양의 정수로 하기
야구숫자게임을 위한 밑작업
*/
public class DeptList {//클래스는 대문자시작 camel표기법


  public static void main(String[] args) {//메소드 선언의 위치는 중요하지않다.
    //선언부에 원시형, 참조형 둘다 변수올수있다.
//전변이다.
//초기화의 세가지 방법
    int deptnos[];//배열의 선언이다. NullpointException 발생한다. 메모리에 클래스가 없어서-->new를 써야된다.
    // deptnos= new int[3];//배열의 선언
    deptnos= new int []{0,0,1};//3칸 만들어 진곳에 0,0,1을 넣은 것이다
  // deptnos= {0,0,0};//new 생략가능
    System.out.println(deptnos[0]);//칸은 무조건 0부터 시작한다
    System.out.println(deptnos[1]);
    System.out.println(deptnos[2]);//세칸

    for(int i : deptnos){//콜론? 
      System.out.println(i);
    }
    for(int i=0; i<3; i++){
    System.out.println(deptnos[i]);
    }
//함수는 리턴값이 있다. 
    int com=(int)(Math.random()*10);//Math세트 계산하는 애들. 그중하나가 랜덤메소드. 기본 형태는 double이다. 0.0~1.0 에서 랜덤으로 하나 뽑는다. int로 바꾼다 캐스팅 해준다.
    // int로 캐스팅 한 상태
    com=(int)(Math.random()*10);
    double com2=(Math.random()*10);
    System.out.println(com+","+com2);

    
  }
  
}
