package dev_java.week5;
class Sup{
  public void m(){
    System.out.println("Sup m() 호출");
  }
}
class Sub extends Sup{
  public Sub(){
    this.m();
    // super.m();
  }
  @Override
  public void m(){
    System.out.println("Sub m() 호출");
  }
}
//선언부에는 상위클래스 생성부에는 하위클래스가 와야한다.
public class SuperSubMain {
  public static void main(String[] args) {
    // //insert here Sup클래스에 오버라이드된 m메소드가 호출되도록 작성
    // //3. polimopisim 될수있도록..?
    // Sup sup=new Sup();
    // // sup.m();
    Sub sub = new Sub();//sub m()호출
    // // sub.m();
    // //선언부(Sup)=생성부(Sub)
    // //생성부의 이름으로 생성됨
    // //부모의 메소드는 은닉 Shadow메소드가 된다.
    Sup sup2= new Sub();//sub m()호출
    // // sup2.m();
    sub=(Sub)sup2;//작은것에 큰것을 넣는다. 오류 강제형전환을 해야된다.
    //sub=new Sup();
    sub.m();
    int i=(int)23.5d;
    System.out.println(i);
    //4.실행하지말고 먼저 생각해보기
  }
  /*
   * 31번에서 sup을 대입하는 경우에는 실제 생성된 객체도 Super타입입니다.
   * 따라서 강제 형전환을 하더라도, 그리하여 문법적인 문제는 해결을 했어도 실제로 가리키는 
   * 객체는 상위 객체이므로 에러가 발생합니다.
   * 그러나 sup2로 하게되면 실제 생성된 객체가 자손인 Sub타입이니까
   * 타입은 달라서 강제 형전환 해야되지만 실제 가리키는 객체가 자손 타입이므로
   * 에러없이도 실행이 됩니다.
   */
  
}
