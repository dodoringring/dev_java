package dev_java.week4;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class DeptTable7 extends JFrame implements ActionListener{
  // 선언부
  //파라미터의 this는 DeptTable7타입이고 main에서 호출된 생성자로
  //현재 메모리에 로딩 중인 그 객체를 가리킨다.
  //this를 왜 넘겨야 하나요? 입력할건데
  //JTable7Dialog에서 부서번호, 부서명, 지역을 입력한 후 저장버튼을 누르면
  //Vector<String[]>추가하고 추가된 로우를 포함하는  Vector\가 부모창에 새로 리플레쉬되어야함
  //리플레쉬 즉, 재사용 되어야 함-이건 부모 클래스에 구현함
  JTable7Dialog jtd7=new JTable7Dialog(this);
  String header[] = { "부서번호", "부서명", "지역" }; //표에서 제일 위에를 나타내줄
  String datas[][] = new String[1][3]; //
  DefaultTableModel dtm_dept = new DefaultTableModel(datas, header); // 생성자 호출
  JTable jtb_dept = new JTable(dtm_dept);
  JScrollPane jsp_dept = new JScrollPane(jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JPanel jp_north=new JPanel();
  //부서목록 조회에 들어갈 샘플 데이터 생성
  JButton jbtn_sel = new JButton("조회");
  JButton jbtn_ins = new JButton("입력");
  JButton jbt_upd = new JButton("수정");
  JButton jbtn_del = new JButton("삭제");
  JButton jbtn_det = new JButton("상세보기");

static Vector<String[]> vdata=new Vector<>();//vdata.size()=0; 
String[][] depts = {
  {"10","개발부","서울"},
  {"20","인사부","경기"},
  {"30","총무부","부산"}
};
  // 생성자
  public DeptTable7() {
    initDisplay();
  }

  // 화면출력부
  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jbtn_ins.addActionListener(this);
    jbtn_sel.addActionListener(this);
    jbt_upd.addActionListener(this);
    jbtn_del.addActionListener(this);
    jbtn_det.addActionListener(this);

    this.setTitle("부서관리 시스템 Ver1.0");
    this.setSize(500, 400);
    this.setVisible(true);
    jbtn_ins.setBackground(new Color(20,20,30));
    jbtn_ins.setForeground(new Color(225,225,225));
    jbtn_sel.setBackground(new Color(30,60,30));
    jbtn_sel.setForeground(new Color(225,225,225));
    jbt_upd.setBackground(new Color(40,100,30));
    jbt_upd.setForeground(new Color(225,225,225));
    jbtn_del.setBackground(new Color(50,150,30));
    jbtn_del.setForeground(new Color(225,225,225));
    jbtn_det.setBackground(new Color(50,150,30));
    jbtn_det.setForeground(new Color(225,225,225));
    jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
    jp_north.add(jbtn_ins);
    jp_north.add(jbtn_sel);
    jp_north.add(jbt_upd);
    jp_north.add(jbtn_del);
    jp_north.add(jbtn_det);
    this.add("North", jp_north);
    this.add("Center",jsp_dept); //디폴트 테이블~테이블을 붙인 스크롤팬을 소환해서 기본테이블을 만들었ㄷ  
  }
  
  //새로고침
  //입력, 수정화면에서 저장 버튼 누르면 Vector에 String[]추가하고
  //그 다이얼 로그 화면은 닫히고 부모창은 새로고침 처리 한다.
  //그러니까 다이얼로그 창에서 부모 클래스에 리프레쉬데이터메소드를 호출해야한다.
  //그러니까 인스턴스화 할 때 파라미터에 this를 넘겨서 사용할 수 있도록 할 것(N.P.E안일어나게)
  public void refreshData(){
    System.out.println("refreshData 호출");  
    //입력, 수정 전에 조회된 정보는 삭제함
    while(dtm_dept.getRowCount()>0){
      dtm_dept.removeRow(0);
    }
    if(DeptTable7.vdata.size() <=0){
      JOptionPane.showMessageDialog(this, "조회결과가 없습니다.", "Warning", JOptionPane.WARNING_MESSAGE);
      return;//refresh탈출
    }
    System.out.println("DeptTable7 : "+vdata.size());
    //벡터의 크기만큼 반복하면서 dtm_dept데이터셋에 String[]추가함
    for(int i=0;i<vdata.size();i++){
      String[] oneRow =vdata.get(i);////들어간는데 버튼누르
      dtm_dept.addRow(oneRow);
    }
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource();
    //조회 할거니?
    if(obj==jbtn_sel){
      // dtm_dept.setDataVector(depts, header);//조회 누르면 데이터가 표가 들어감
     refreshData();
    }

    //너입력 버튼 누른거야?
    if(obj == jbtn_ins){
      jtd7.set("입력",true,null);
    }
    //너 수정할려고?
    else if(obj==jbt_upd){
      //어떤 로우를 수정할거니?
      //JTable목록에서 선택한 로우의 인덱스값을 가져옴
      int index=jtb_dept.getSelectedRow();//테이블에서 선택된 열의 번호를 가져오는것
      // dtm_dept.removeRow(index);
      //데이셋객체로 백터를 사용중이니 벡터에서 꺼낸 값을 String[]초기화
      //테이블 양식 폼인 JTable이벤트로 얻어옴
      String[] oneRow=vdata.get(index);//한줄씩 꺼내오기
      jtd7.set("수정",true,oneRow);
    }
    //너 상세보기원해?
    else if(obj ==jbtn_det){
      int index=jtb_dept.getSelectedRow();
      String[] oneRow=vdata.get(index);
      jtd7.set("상세보기",true,oneRow);
    }
    
  }
  public static void main(String[] args) {
    new DeptTable7();
  }
}
  

