package dev_java.network3;

import javax.swing.JFrame;

public class KiwiServer extends JFrame implements Runnable {
  //선언부

  //생성자
  public KiwiServer(){
    System.out.println("KiwiServer디폴트 생성자 호출");
  }
  public void initDisplay(){
    this.setSize(400, 300);
    this.setVisible(true);
    this.setTitle("키위톡");

  }

  //메인메소드
  public static void main(String[] args) {
    KiwiServer k =new KiwiServer();
    k.initDisplay();
    Thread th=new Thread(k);
    th.start();
  }
  @Override
  public void run() {
    System.out.println("run호출 성공");
    // 경합이 벌어지는 일 또는 지연이 필요한 일(대기타는것)
    //일반 메소드로 처리할때와 다른점?
    //보장받는다. 늦게라도 실행이 된다. 일반 메소드는 어플리케이션이 종료되면 보장을 못받는다.
    //개별적으로 동작을 할 수 있다.
  }
}
