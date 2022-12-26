package dev_java.thread1;

import javax.swing.JFrame;

public class JFrameTimerClose extends JFrame {
  public JFrameTimerClose() {
    super("JFrame테스트-5초 후 창닫기");
    this.setSize(500, 500);
    this.setVisible(true);
    // 대기
    try {
      Thread.sleep(5000);// 5초
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
    setVisible(false);// 5초후에 사라짐
  }

  public static void main(String[] args) {
    new JFrameTimerClose();// 생성자 호출하기
  }
}
