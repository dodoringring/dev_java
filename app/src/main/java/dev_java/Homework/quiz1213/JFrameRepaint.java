package dev_java.Homework.quiz1213;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//가비지 컬렉터
//Candidate상태
//System.gc 쓰레기 좀 치워주세요

public class JFrameRepaint extends JFrame implements ActionListener {//상속은 하나만 가능
  JPanel jp = new JPanel();
  JTextArea jta =new JTextArea("여기는 JTextArea",10,20);
  JButton jbtn =new JButton("화면변경");
  public JFrameRepaint(){
    initDisplay();
  }
  public void initDisplay(){
    jbtn.addActionListener(this);
    jp.setLayout(new BorderLayout());//??
    jp.add("Center",jta);
    this.add("Center",jp); //JFrame을 상속받아서 '내꺼' 된상태에서 this를 쓴다.
    this.add("North",jbtn);

    this.setSize(400,300);
    this.setVisible(true);
  }
  public static void main(String[] args) {
    new JFrameRepaint();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if(obj==jbtn){
      Container con=this.getContentPane();
      if(jp != null){
        con.remove(jp);
        con.remove(jbtn);
      }
      JPanel jp1=new JPanel();
      jp1.setBackground(Color.ORANGE);
      this.add("Center",jp1);
      con.revalidate();
    }
    
  }//enf of Actionperfomer
  
}//end of JFrameRepaint
