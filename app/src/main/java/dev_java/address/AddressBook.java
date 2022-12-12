package dev_java.address;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddressBook implements ActionListener {
  //선언부
  JFrame jf = new JFrame();
  JPanel jp = new JPanel();

  JButton jb[]=new JButton [4];
  jb[]=
  // JButton jb1 = new JButton("조회");
  // JButton jb2 = new JButton("입력");
  // JButton jb3 = new JButton("수정");
  // JButton jb4 = new JButton("상세보기");

  AddressDialog aDialog=new AddressDialog();




  //생성자
  public AddressBook(){
    initDisplay();
  }

  //화면처리부
  public void initDisplay(){
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setTitle("주소록 Ver1.0");
    jf.setSize(500,450);
    jf.setVisible(true);
    if(int i=1;i<5;i++){
      jf.add(jb+i);
    }
   

  }

  //메인메소드

  public static void main(String[] args) {
    new AddressBook();
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource(true);
    
  }
  
}
