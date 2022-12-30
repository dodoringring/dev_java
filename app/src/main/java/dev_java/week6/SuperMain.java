package dev_java.week6;
class Sup{
  void go(){
    System.out.println("Sup go호출");
  }
  void stop(){
    System.out.println("Sup stop호출");
  }
}
class Sub extends Sup{
  Sub(){
    super.stop();
    this.stop();//현재 인스턴스 화 되어있는 생성되어진 객체 : this. 메모리에 로딩이 되어있는...
  }
  @Override
  void stop(){
    System.out.println("Sub stop호출");
  }
}
public class SuperMain {
  public static void main(String[] args) {
    Sup sup=new Sup();
    // sup.stop();//안된다. 부모가 자식것을 쓸 수 없다.
    Sub sub=new Sub();
    sub.go();//super필요없다!
    // sup=sub;//얕은복사. 원본이 바뀌면 복사본도 바뀐다. 
    //부모가 가진 stop메소드는 은닉 메소드라고 한다. shadow메소드라고 한다.
    // sup=new Sub(); 깊은복사아니야..ㅠ 걍 새로운거 만든거임
    sup.stop();//안된다. 타입이 다르다....??????
    sub.stop();
    //this, super는 static영역에서는 사용 할 수 없다.
    // super.stop();
    // this.stop();
  }
  
}
