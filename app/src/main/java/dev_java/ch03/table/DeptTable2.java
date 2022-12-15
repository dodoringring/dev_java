package dev_java.ch03.table;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

//이른 인스턴스화 게으른 인스턴스화
//어떤 클래스를 상속 받을때는 extends예약어를 사용
//A is a B관계이면 상속으로 처리 한다.
//소나타는 자동차이다.
//자동차는 소나타이다.
//부모클래스가 가진 변수와 메소드도 사용 가능하다.
//자손이 더 많이 누릴 수 있다.

public class DeptTable2 extends JFrame{//DeptTable is a JFrame

  //선언부
  String header[]={"부서번호","부서명","지역"};
  String data[][]=new String[1][3];
  DefaultTableModel dtm = new DefaultTableModel(data,header);//생성자 호출 
  JPanel jp=new JPanel();
  

  //생성자
  public DeptTable2(){
    initDisplay();
  }
  public DeptTable2(String title){
  }
  public DeptTable2(int i){//내가 정의한 생성자이기때문에 바꿀수있다.
  }


  //화면그리기
  public void initDisplay(){
    this.setSize(500,400);
    this.setVisible(true);
    this.setTitle("부서관리 시스템 Ver1.0");

  }

  //메인메소드
  public static void main(String[] args) {
    new DeptTable1();//다른 클래스에 있는 생성자도 사용가능하다.
  }
  
}
