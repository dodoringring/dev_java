package dev_java.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//한 클래스에서 만드는게 아니고 로직따라 분리하기로했다. 
public class RandomGameView implements ActionListener {
  JFrame jf = new JFrame();// 이른 인스턴스화

  JTextField jtf_input = new JTextField(5);// 생성자 파라미터는 int

  JTextArea jta_display = new JTextArea(10, 20);// 생성자파라미터는 int
  JScrollPane jsp_display = new JScrollPane(jta_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 스크롤바 만들기

  public RandomGameView() {
    System.out.println("디폴트 생성자 호출");
    initDisplay();
  }

  // 화면처리부
  public void initDisplay() {
    System.out.println("initDisplay 호출");
    jtf_input.requestFocus(true);//자동커서깜빡위해 넣었다.???
    jtf_input.addActionListener(this);
    jta_display.setEditable(false);
    jf.add("South", jtf_input);

    jf.add("Center", jsp_display);// 스크롤이 화면을 갖고있으니까
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
    // 엔터의 주소번지를 가져온다
    Object obj = e.getSource();
    System.out.println(e.getSource());// 주소번지
    if (jtf_input == obj) {
      System.out.println("사용자가 입력한 값은 jtf_input.getText()");
      jta_display.append(jtf_input.getText() + "\n");// 개행처리
      jtf_input.setText("");// 지우기는 ""로 대체함
    }
  }
}
