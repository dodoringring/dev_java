package dev_java.ch03.table;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
//자바.랭 이 아니면 내가 추가해야한다.


//이른 인스턴스화 게으른 인스턴스화
//어떤 클래스를 상속 받을때는 extends예약어를 사용
//A is a B관계이면 상속으로 처리 한다.
//소나타는 자동차이다.
//자동차는 소나타이다.
//부모클래스가 가진 변수와 메소드도 사용 가능하다.
//자손이 더 많이 누릴 수 있다.
//선언부와 ㅡ생성부가 다를수있다. 이럴때만 다형성이 가능하다
//동일한 메소드를 호출했는데 다른 기능이 처리되었다? ->다형성
//Duck myDuck =new WoodDuck();
//Duck herDuck =new RubberDuck();
//Duck himDuck=new MallardDuck();
public class DeptTable3 extends JFrame implements ActionListener{//DeptTable is a JFrame

  //선언부
  String header[]={"부서번호","부서명","지역"};
  String data[][]=new String[1][3];
  //this는 사용되는 클래스 영역에서 선언된 클래스를 가리킨다.
  //그러면 여기서는 DeptTable1타입인 것임
  // DeptTableModel은 자바에서 제공되는 클래스임-생성자도 정해져 있음
  //제공되는 생성자에 없음 - 결국 사용못함-컴파일 에러(문법에러발생)
  //생성자는 메소드 오버로딩 규칙을 따름
  //액션리스너 = 인터페이스 단독으로 인스턴스화가 불가능하다-구현체 클래스가 필요하다
  //추상메소드를 선언하고 있다.
  DefaultTableModel dtm = new DefaultTableModel(data,header);//생성자 호출 
  JTable jtb=new JTable(dtm);
  JScrollPane jsp=new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  JButton jb1=new JButton("입력");
  JButton jb2=new JButton("조회");
  JButton jb3=new JButton("수정");
  JButton jb4=new JButton("삭제");
  JPanel jp = new JPanel();

  //부서목록 조회에 들어갈 샘플 데이터 생성
  String[][]depts={
    {"10","개발부","서울"},
    {"20","인사부","인천"},
    {"30","총무부","부산"}
  };

  

  //생성자
  public DeptTable3(){
    initDisplay();
  }


  //화면그리기
  public void initDisplay(){
    this.setSize(500,400);
    this.setVisible(true);
    this.setTitle("부서관리 시스템 Ver1.0");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    // jp.setLayout(new BorderLayout());

    jp.setLayout(new FlowLayout(FlowLayout.RIGHT));
    jb1.addActionListener(this);
    jb2.addActionListener(this);
    jb3.addActionListener(this);
    jb4.addActionListener(this);
    jp.add(jb1);
    jp.add(jb2);
    jp.add(jb3);
    jp.add(jb4);
    this.add("North",jp);
    this.add(jsp);
    


  }

  //메인메소드
  public static void main(String[] args) {
    new DeptTable3();
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();

    if(obj==jb4){
    int index=jtb.getSelectedRow();
    System.out.println(index);
    Integer deptno=Integer.parseInt((String)dtm.getValueAt(index,0));
    System.out.println(deptno);
  }

    if(obj==jb2){//너 조회버튼 누른거야?
      for(int x=0;x<depts.length;x++){
      Vector<String> oneRow=new Vector<>();//배열을 벡터로 대신 할 수 있다.
      oneRow.add(depts[x][0]);
      oneRow.add(depts[x][1]);
      oneRow.add(depts[x][2]);
      dtm.addRow(oneRow);
      }



      for(int i=0;i<depts.length;i++){//row
      for(int j=0;j<depts[i].length;j++){//colum
        // System.out.print(depts[i][j]+" ");//ln을 빼서 3개 출력하고 줄바꿈 처리
        dtm.setValueAt("여기", 1, 1);//첫번째자리는 입력하는값, 두번째는 로우, 세번째 컬럼
        System.out.println(dtm.getValueAt(i, j));//겟은 값을 읽어들이는것 set은 값을 받는것

        }//end of inner for
      System.out.println();
      }//end of outter for

    }//end of 조회 이벤트 
  
  }
}
  

