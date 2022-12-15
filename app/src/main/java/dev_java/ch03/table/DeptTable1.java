package dev_java.ch03.table;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.concurrent.Flow;

//이른 인스턴스화 게으른 인스턴스화
//어떤 클래스를 상속 받을때는 extends예약어를 사용
//A is a B관계이면 상속으로 처리 한다.
//소나타는 자동차이다.
//자동차는 소나타이다.
//부모클래스가 가진 변수와 메소드도 사용 가능하다.
//자손이 더 많이 누릴 수 있다.

public class DeptTable1 extends JFrame{//DeptTable is a JFrame

  //선언부
  String header[]={"부서번호","부서명","지역"};
  String data[][]=new String[1][3];
  //this는 사용되는 클래스 영역에서 선언된 클래스를 가리킨다.
  //그러면 여기서는 DeptTable1타입인 것임
  // DeptTableModel은 자바에서 제공되는 클래스임-생성자도 정해져 있음
  //제공되는 생성자에 없음 - 결국 사용못함-컴파일 에러(문법에러발생)
  //생성자는 메소드 오버로딩 규칙을 따름
  //액션리스너 = 인터페이스 단독으로 인스턴스화가 불가능하다-구현체 클래스가 필요하다
  DefaultTableModel dtm = new DefaultTableModel(data,header);//생성자 호출 
  JTable jtb=new JTable(dtm);
  JScrollPane jsp=new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  JButton jb1=new JButton("입력");
  JButton jb2=new JButton("조회");
  JButton jb3=new JButton("수정");
  JButton jb4=new JButton("상세보기");
  JPanel jp = new JPanel();

  

  //생성자
  public DeptTable1(){
    initDisplay();
  }


  //화면그리기
  public void initDisplay(){
    this.setSize(500,400);
    this.setVisible(true);
    this.setTitle("부서관리 시스템 Ver1.0");
    
    // jp.setLayout(new BorderLayout());
    jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
    this.add("North",jp);
    jp.add(jb1);
    jp.add(jb2);
    jp.add(jb3);
    jp.add(jb4);

  }

  //메인메소드
  public static void main(String[] args) {
    new DeptTable1();
  }
  
}
