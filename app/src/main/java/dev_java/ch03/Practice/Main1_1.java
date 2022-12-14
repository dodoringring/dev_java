// package dev_java.ch03.Practice;

// import javax.swing.JFrame;

// public class Main1_1 {
//   Sub1 sub1=new Sub1();//this가 mian1이라는 뜻이다.
//   JFrame jf = new JFrame();

//   //디폴트 생성자 안에서 화면을 그리는 initDiplay 가 호출 되고 있다.
//   //이 메소드는 화면을 그리는 메소드이다.
//   //화면이 두 개 열린다????->괜찮니?
//   public Main1_1(){
//     initDisplay();
//   }
//   public void initDisplay(){
//     jf.setSize(300,400);
//     jf.setVisible(true);
//     System.out.println("initDisplay호출");
//   }
  
//   public static void main(String[] args) {
//     new Main1_1();
//   }
// }
// /*
//  * 디폴트 생성자는 생략이 가능하다. 
//  * 파라미터가 있는 생성자는 생략이 불가능하다.
//  * 파라미터가 있는 생성자가 하나라도 있으면 디폴트 생성자도 생략 불가하다.
//  * 인스턴스화 할 때 생성부의 이름으로 객체가 생성이 된다.
//  * 이때 파라미터 자리에 인자를 추가할 수 있다. -여러개의 생성자를 선언할 수 있다.
//  * 단, 파라미터의 갯수가 다르거나 타입이 달라야 한다.
//  * 
//  */