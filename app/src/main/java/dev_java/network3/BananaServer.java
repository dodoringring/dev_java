package dev_java.network3;

import javax.swing.JFrame;

public class BananaServer extends JFrame{
  String title=null;
  //생성자
  BananaServer(){
    // initDisplay();
  }
  BananaServer(String title){
    super(title);//super는 JFrame을 가리킨다.
    // this(title); 자기 자신을 호출하는것이므로 에러임 this는 바나나서버이다
    initDisplay();
  }

  //화면
  public void initDisplay(){
    // this.setTitle(title);
    this.setSize(400,300);
    this.setVisible(true);
  }

  // public void initDisplay(String title){
  // //   this.title=title;
  //   this.setTitle(title);
  //   this.setSize(400,300);
  //   this.setVisible(true);
  }
  //this는 클래스 쪼개기 즉 화면과 로직의 분리 또는 하나의 클래스를 여러개의 클래스로 나누어 처리할때만 필요하다.
  public static void main(String[] args) {
    // new BananaServer();
    // // 생성자 파라미터는 this말고도 다른 타입을 사용가능함
    // BananaServer b=new BananaServer();
    // b.initDisplay("생성자 파라미터로 제목을 결정함-초기화");
    new BananaServer("생성자 파라미터로 제목을 결정함-초기화");
  }

  
}
/*
 * 관전 포인트
 * initDisplay를 메인메소드에서 호출하는것과 생성자 안에서 호출하는것이 가능하다.
 * 그렇다면 둘의 차이는 있나?
 * 키위톡은 메인에서 
 * 바나나톡은 생성자에서 initDisplay호출하겠다
 * 둘다 열린다. 차이가 없어보인다.
 * 
 */