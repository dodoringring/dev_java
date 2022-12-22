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
   JScrollPane jsp = new JScrollPane(jpc); // 지금은 예쁘라고 붙임
   JPanel jps = new JPanel(); // ->저장 / 닫기 용
   JLabel jl1 = new JLabel("부서번호");
   JTextField jtf_deptno = new JTextField(10);
   JLabel jl2 = new JLabel("부서명");
   JTextField jtf_dname = new JTextField(20);
   JLabel jl3 = new JLabel("지역");
   JTextField jtf_loc = new JTextField(20);
   // jps속지
   JButton jbtn_save = new JButton("저장");
   JButton jbtn_close = new JButton("닫기");
   JButton jbtn_check = new JButton("자동닫기");
   JButton jbtn_sample = new JButton("자동닫기");
  
    DeptVO pdVO=null;
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
		jbtn_check.addActionListener(this);
     this.setSize(400, 360);
     jpc.setLayout(null);
     jps.setLayout(new FlowLayout(FlowLayout.RIGHT));
     jl1.setBounds(20, 20, 50, 20);
     jtf_deptno.setBounds(70, 20, 100, 20);
     jl2.setBounds(170, 20, 40, 20);
     jtf_dname.setBounds(210, 20, 100, 20);
     jl3.setBounds(310, 20, 30, 20);
     jtf_loc.setBounds(340, 20, 100, 20);
     jbtn_check.setBounds(20,40,100,20);//
     jpc.add(jl1);
     jpc.add(jl2);
     jpc.add(jl3);
     jpc.add(jbtn_check);

     jpc.add(jtf_deptno);
     jpc.add(jtf_dname);
     jpc.add(jtf_loc);
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

   public void set(String title, boolean isView,DeptVO pdVO,boolean isEdit){
    this.setTitle(title);
    this.setVisible(isView);
    this.pdVO=pdVO;
    setValue(pdVO);//?????초기화
    setEditable(isEdit);
  }

  private void setEditable(boolean isEdit){
    jtf_deptno.setEditable(isEdit);
    jtf_dname.setEditable(isEdit);
    jtf_loc.setEditable(isEdit);
  }

  public void setValue(DeptVO pdVO){
  //입력을 위한 윈도우 설정-모든 값을 빈문자열로 셋팅함
    if(pdVO==null){
      setDeptno("");
      setDname("");
      setloc("");
    }
  //상세조회, 수정시는 배열로 받은 값으로 셋팅함
    else{
      setDeptno(String.valueOf(pdVO.getDeptno()));
      setDname(pdVO.getDname());
      setloc(pdVO.getLoc());
    
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
      //다이얼로그화면에서 저장버튼 하나로 어떨때는 입력처리를 어떤 경우는 수정처리를 한다.
      //어떻게 나누지? 부모창에서 버튼이 눌려졌을때 set메소드를 호출함
      //이때 입력이면 세번째 파라미터에 nill을 입력하고 만일 수정이라면
      //JTable에서 선택된 로우의 인덱스로 DeptVO를 추출해서 세번째 파라미터에 *널대신*입력해준다.
      //내 안에 수정하고자 하는 로우의 DeptVO가 있고 그 안에는 deptno, dname, loc가 있다.

      if(pdVO!=null){// 
        //처음에는 벡터에 Generic으로 String[]을 사용하였으므로 2중 for문을 사용해야했음
        //그런데 지금 DeptVO로 변경했으니까 for문 하나면 됨
        for(int i=0;i<DeptTable7.vdata.size();i++){
          DeptVO comVO=DeptTable7.vdata.get(i);
          //DeptTable7에서 (set메소드 세번째)받아온 부서번호와
          //벡터에서 꺼낸 DeptVO의 부서번호와 같니?
          if(pdVO.getDeptno()==comVO.getDeptVO()){//부서번호가 타입이 int이므로== quals안된다.
          
          }
        }////end of for
        dept7.refershData();
        this.dispose();
      }else{//그외에는 
        DeptVO insVO=DeptVO.builder().deptno(Integer.parseInt(getDeptno())).dname(getDname()).loc(getloc()).build();
        System.out.println("before :"+DeptTable7.vdata.size());
        dept7.vdata.add(insVO);
        System.out.println("after"+DeptTable7.vdata.size());
        dept7.refreshData();
        this.dispose();
      }
    }//end of save
    else if(obj==jbtn_sample){
      setDeptno("30");
      setDname("운영부");
      setloc("세종");
    }
  }
}
