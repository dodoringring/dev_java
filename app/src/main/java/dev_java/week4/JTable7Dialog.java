package dev_java.week4;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.FlowLayout;

import dev_java.week4.DeptVO;

//JDialog도 디폴트가 BorderLayout임 - jp_center 를 중앙배치
public class JTable7Dialog extends JDialog implements ActionListener{
   // 선언부
   DeptTable7 dept7=null;
   JPanel jpc = new JPanel();
   JScrollPane jsp = new JScrollPane(jpc); 
   JPanel jps = new JPanel(); // ->저장 / 닫기 용
   JLabel jlb_deptno = new JLabel("부서번호");
   JTextField jtf_deptno = new JTextField(10);
   JLabel jlb_dname = new JLabel("부서명");
   JTextField jtf_dname = new JTextField(20);
   JLabel jlb_loc = new JLabel("지역");
   JTextField jtf_loc = new JTextField(20);
   // jps속지
   JButton jbtn_save = new JButton("저장");
   JButton jbtn_close = new JButton("닫기");
    String[] oneRow=null;
   // 생성자
   public JTable7Dialog() {
   }
   
   // JTable7을 받아주는 생성자가 있어야된다!!
   public JTable7Dialog(DeptTable7 dept7){
    this.dept7=dept7;
    initDisplay();
  
  }
   // 화면 그리기
   public void initDisplay() {
    jbtn_save.addActionListener(this);
		jbtn_close.addActionListener(this);
     this.setSize(400, 360);
     jpc.setLayout(null);
     jps.setLayout(new FlowLayout(FlowLayout.RIGHT));
     jlb_deptno.setBounds(20, 20, 50, 20);
     jtf_deptno.setBounds(70, 20, 100, 20);
     jlb_dname.setBounds(170, 20, 40, 20);
     jtf_dname.setBounds(210, 20, 100, 20);
     jlb_loc.setBounds(310, 20, 30, 20);
     jtf_loc.setBounds(340, 20, 100, 20);
     jpc.add(jl1);
     jpc.add(jl2);
     jpc.add(jl3);
     jpc.add(jtf_deptno);
     jpc.add(jtf_dname);
     jpc.add(jtf_loc);
     jpc.add(jbtn_check);
     jps.add(jbtn_save);
     jps.add(jbtn_close);
     jps.add(jbtn_sample);
     jsp.add(jpc);

     this.add("Center", jpc);
     this.add("South", jps);
     this.setVisible(false);
   }
  //각 컬럼(부서집합-부서번호,부서명,지역)의 값들을설정하거나
	//읽어오는 getter/setter메소드 임
  public String getDeptno(){
    return jtf_deptno.getText();
  }

  public void setDeptno(String deptno){
    jtf_deptno.setText(deptno);
  }

  public String getDname(){
    return jtf_dname.getText();
  }

  public void setDname(String dname){
    jtf_dname.setText(dname);
  }

  public String getloc(){
    return jtf_loc.getText();
  }

  public void setloc(String loc){
    jtf_loc.setText(loc);
  }
  //아래메소드는 DeptTable7에서 호출됨
  //actionPerformed에서 이벤트(입력,수정,상세보기)가 발생되면 호출됨
	//메소드의 파라미터 자리는 Call by Value에 의해서 결정됨

   public void set(String title, boolean isView, String[] oneRow){
    this.setTitle(title);
    this.setVisible(isView);
    this.oneRow=oneRow;
    setValue(oneRow);//?????초기화
  }

  public void setValue(String[] oneRow){
  //입력을 위한 윈도우 설정-모든 값을 빈문자열로 셋팅함
    if(pdVO==null){
      setDeptno("");
      setDname("");
      setloc("");
    }
  //상세조회, 수정시는 배열로 받은 값으로 셋팅함
  // 부모창에서 set메소드 호출시 파라미터로 넘겨준 값으로 초기화할것.
    else{
      setDeptno(oneRow[0]);
      setDname(oneRow[1]);
      setloc(oneRow[2]);
    
    }
  }//end of setValue

  public static void main(String[] args) {
    new JTable7Dialog(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource();
    if(obj==jbtn_save){
      //oneRow가 존재하면 수정모드, 그렇지 않으면 입력모드로 함
      if(oneRow!=null){// 
        //날리고 추가하기?
        // .remove
      }else{//그외에는 
        String[] oneRow={getDeptno(),getDname(),getloc()};
        System.out.println(oneRow[0]+","+oneRow[1]+","+oneRow[2]);
        System.out.println("before"+DeptTable7.vdata.size());
        dept7.vdata.add(oneRow);
        System.out.println("after"+DeptTable7.vdata.size());
        this.dispose();
      }
    }
    
    
    
  }
}
