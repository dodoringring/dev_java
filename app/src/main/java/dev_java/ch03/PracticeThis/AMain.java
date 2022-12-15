package dev_java.ch03.PracticeThis;

class A{
  int i=1;
  AMain aMain = null;

  public A(){
  }

  public A(AMain aMain){
    System.out.println("A(AMain aMain)호출 성공");
    this.aMain=aMain; //초기화 해서 null인곳에 값을 넣어줌. this를 안넣어 주면 구분이 안된다
    System.out.println("받아온주소번지"+aMain);
  }
  void methodB(){
  aMain.methodA();
  }
}


public class AMain {
  A a = new A(this);//this 있고 없고 차이난다! 
  
  void methodA(){
  System.out.println("AMain methodA()호출");
  }
  public static void main(String[] args) {
  AMain aMain=new AMain();
  aMain.a.methodB();  
  }
  
}
