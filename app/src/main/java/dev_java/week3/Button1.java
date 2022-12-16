package dev_java.week3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Button1 extends JFrame{
  //선언부
  String jbtn_label[]={"입력","수정","삭제"};
  JPanel jp_north=new JPanel();
  JButton jb1=new JButton(jbtn_label[0]);
  JButton jb2=new JButton(jbtn_label[1]);
  JButton jb3=new JButton(jbtn_label[2]);
  JButton[] jbtns=new JButton[3];
  JPanel jp_south=new JPanel();
  
  //생성자
  public Button1(){
    initDisplay();
  }
  public void initDisplay(){
   
    for(int i=0;i<jbtn_label.length;i++){
      jbtns[i] = new JButton(jbtn_label[i]);
      jp_south.add(jbtns[i]);
     
    }

    jp_north.add(jb1);
    jp_north.add(jb2);
    jp_north.add(jb3);

    
    this.add("North",jp_north);
    this.add("South",jp_south);
    this.setSize(500,400);
    this.setVisible(true);
  }
  //메인메소드
  public static void main(String[] args) {
    new Button1();
  }
  
}
