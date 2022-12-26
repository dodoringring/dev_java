package dev_java.network1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class TimeClientView extends JFrame{
  //선언부
  JLabel jlb_timer=new JLabel("현재시간", JLabel.CENTER);
  Font f= new Font("굴림체",Font.BOLD,46);
  //생성부
  TimeClientView(){
    initDisplay();
  }

  //화면처리부
  public void initDisplay(){
    Thread th = new TimeClient(jlb_timer);
    th.start();
    this.add("Center",jlb_timer);
    this.setSize(400,300);
    this.setVisible(true);
    jlb_timer.setFont(f);
  
  }
  //메인메소드
  public static void main(String[] args) {
    new TimeClientView();
  }
  
}
