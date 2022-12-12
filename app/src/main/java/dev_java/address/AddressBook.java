package dev_java.address;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class AddressBook implements ActionListener {

  //선언부
  AddressDialog adb =new AddressDialog(this);
  JFrame jf = new JFrame();
  JPanel jp = new JPanel();
  JTable jt = new JTable();

  JButton jb[]=new JButton [4];
  String jb_label[]={"조회","입력","수정","상세보기"}
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
    for(int i=0;i<4;i++){
      jp.add(jb[i]);
    }
    jp.setLayout(new FlowLayout(FlowLayout.LEFT, 10,20));
    jf.add(jp);

  

  }

  //메인메소드

  public static void main(String[] args) {
    new AddressBook();
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource(true);
    if(jb[0]==obj){
      jf.append()

    }
  }
  
}
