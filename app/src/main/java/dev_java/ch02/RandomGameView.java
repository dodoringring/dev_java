package dev_java.ch02;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class RandomGameView {
  // 선언부
  JFrame jf_game = new JFrame();
  JPannel jp_east = new JPanel();
  Jbutton jbtn_new = new JButton("새게임");
  Jbutton jbtn_dap = new JButton("정답");
  Jbutton jbtn_clear = new JButton("지우기");
  Jbutton jbtn_exit = new JButton("종료");

  // 생성자-파라미터가 없는 생성자를 디폴트 생성자한다-생략가능함
  RandomGameView() {// 그러나 화면을 그리는 메소드를 호출하기 위해서 굳이 선언하였다
    initDisplay();
  }

  // 화면 그리기 구현
  public void initDisplay() {
    // 동쪽에 붙일 속지의 레이아수을 설정함
    // 메소드의 파라미터로 객체를 생성함-왜냐면 딱 한번만 호출하니까...
    GridLayout layout = new GridLayout(4, 1);
    jp_east.setLayout(layout);
    jp_east.add(jbtn_new);
    jp_east.add(jbtn_dap);
    jp_east.add(jbtn_clear);
    jp_east.add(jbtn_exit);
    jf_game.add("East", jp_east);
    jf_game.add.setSize(450, 400);

  }

  // 메인 메소드
  public static void main(String[] args) {

  }

}
