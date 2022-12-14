package dev_java.ch03.Practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeView2 implements ActionListener{
  
//선언부
JFrame jf=new JFrame();
JPanel jp1=new JPanel();
JPanel jp2=new JPanel();
JPanel jp3=new JPanel();
JLabel jl_inwon=new JLabel("성적처리인원",JLabel.RIGHT);
JLabel jl_num=new JLabel("명",JLabel.LEFT);
JButton jb_make=new JButton("만들기");
JButton jb_cal=new JButton("연산");
JButton jb_sam=new JButton("3명샘플");
JButton jb_clear=new JButton("지우기");
JButton jb_exit=new JButton("종료");
JTextField jtf=new JTextField();




//생성자
public GradeView2(){
  initDisplay();
}

//화면구현부
public void initDisplay(){
  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  jf.setSize(500,400);
  jf.setVisible(true);
  jf.setTitle("성적처리");
  jf.add("North",jp1);
  jf.add("South",jp3);
  jp3.add(jb_cal);
  jp3.add(jb_sam);
  jp3.add(jb_clear);
  jp3.add(jb_exit);
  jp1.setLayout(new BorderLayout());
  jp2.setLayout(new BorderLayout());
  jp1.add("East",jp2);
  jp1.add("Weast",jl_inwon);
  jp1.add("East",jl_num);
  jp1.add("Center",jtf);
  jp2.add(jb_make);
  




}

//메인메소드
public static void main(String[] args) {
  new GradeView2();
  
}




@Override
public void actionPerformed(ActionEvent e) {
  

}
  
}
