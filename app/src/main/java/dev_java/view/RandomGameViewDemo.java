package dev_java.view;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGameViewDemo implements ActionListener {

  // 선언부
  // JFrame jf = null;//게으른 인스턴스화
  JFrame jf = new JFrame();// 이른 인스턴스화
  JButton jbtn_north = new JButton("북쪽");// 생성자 파라미터는 string
  JButton jbtn_south = new JButton("남쪽");
  JButton jbtn_east = new JButton("동쪽");
  JButton jbtn_west = new JButton("서쪽");
  JButton jbtn_center = new JButton("중앙");

  // 생성자
  public RandomGameViewDemo() {//인스턴스화 하면 생성이 동시에 일어난다. 클래스 이름 바꾸면 생성자도 바꿔줘야한다.
    System.out.println("디폴트 생성자 호출");
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    System.out.println("initDisplay 호출");
    jbtn_south.addActionListener(this);
    jbtn_east.addActionListener(this);
    jbtn_north.addActionListener(this);
    jbtn_west.addActionListener(this);
    jbtn_center.addActionListener(this);
    jf.add("North", jbtn_north);
    jf.add("South", jbtn_south);
    jf.add("East", jbtn_east);
    jf.add("West", jbtn_west);
    jf.add("Center", jbtn_center);
    jf.setSize(300, 400);
    jf.setVisible(true);
  }
  // 1. UI API를 사용하여 공부를 하면
  // 2. 초기화를 활용할 수 있게 됨
  // 3. 사용자 정의 메소드를 많이 만들어 볼 수 있음
  // 4. 파라미터와 리턴타입에 대해 확실해짐
  // 5. 전역변수와 지역변수를 구분하여 코딩을 전개하게됨
  // 6. 클래스를 나누는 조건을 갖게됨
  // 7. 이벤트 처리응 사전학습 할 수 있음
  // 8. 익명 클래스를 활용할 수 있음-익명함수,arrow funion 등 신 문법을 공부하는데에 도움됨

  // 메인메소드
  public static void main(String[] args) {
    new RandomGameView();
    // 선언부 없이 생성자만 호출 할 수 있다. 인스턴스 변수를 재사용할 일이 없다면 괜찮아
    // new RandomGameView(); 복제본이 생성됨. 그러나 다른 객체임
    // new RandomGameView();마찬가지 동일타입 그러나 다른 객체?
  }

  @Override // 화면상에 보여줄려고 하는것
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
    System.out.println(e.getSource());// 주소번지
    String label = e.getActionCommand();// 중앙,서쪽, 남쪽
    if ("중앙".equals(label)) {
      System.out.println("중앙 버튼 클릭");
    } else if ("서쪽".equals(label)) {
      System.out.println("서쪽버튼클릭");
    } else if ("남쪽".equals(label)) {
      System.out.println("남쪽버튼 클릭");
    }
  }
}
