package dev_java.address;
//목표 생성자 초기화 알기
//클래스를 쪼갰을때 스태틱을 사용하지 않고 생성자를 사용하기

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;


public class AddressBook_dap implements ActionListener {

  //선언부
  AddressDialog abd =new AddressDialog();
  JFrame jf = new JFrame();
  JPanel jp = new JPanel();
  // JTable jt = new JTable();

  //이미지 경로 선언
  String imgPath="D:\\vscode_java\\dev_java\\images\\address";
  JToolBar jtb = new JToolBar();
  ImageIcon titllcon = new ImageIcon(imgPath+"memo.png");

  //메뉴바구성하기
  JMenuBar jmb= new JMenuBar();
  JMenu jm_file= new JMenu("File");
  JMenuItem jmi_db= new JMenuItem("DB연동확인");
  JMenuItem jmi_all= new JMenuItem("전체조회");

  JSeparator js_exit = new JSeparator();
  JMenuItem jmi_exit= new JMenuItem("종료");
  
  JMenu jm_edit = new JMenu("Edit");////////////////////////
  JMenuItem jmi_ins=new JMenuItem("입력");//
  JMenuItem jmi_upd=new JMenuItem("수정");
  JMenuItem jmi_read=new JMenuItem("삭제");
  JMenuItem jmi_del=new JMenuItem("상세보기");
  //메뉴바구성하기 끝


  JButton jb[]=new JButton [4];
  // String jb_label[]={"전체조회","입력","수정","상세보기"};//이름표 달아주기

  // JButton jb1 = new JButton("입력");
  // JButton jb2 = new JButton("조회");
  // JButton jb3 = new JButton("수정");
  // JButton jb4 = new JButton("상세보기");

  //BorderLayout중앙에 테이블 추가하기
  //JTable Header에 들어갈 문자열 선언
  String[] header= {"번호","이름","H.P"};
  //JTable은 양식만 제공할뿐이고 데이터를 담을 클래스는 별도로 필요함
  String[][] datas= new String[3][3];
  //JTable에 들어갈 실제 데이터셋을 관리할 수 있는 클래스 선언함
  //JTable에 보여지는 실제 데이터는 디폴트모델클래스를 통해 제어해야함을 의미
  DefaultTableModel dtm_addr= new DefaultTableModel(datas, header);
  //데이터셋을 JTable생성시 파라미터로 매칭하기
  JTable jt=new JTable(dtm_addr);
  //디폴트테이블모델의 로우 수가 많아지는 경우 스크롤패인을 추가해야된다.

  JScrollPane jsp_addr = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  




  //생성자
  public AddressBook_dap(){
    initDisplay();
  }

  //화면처리부
  public void initDisplay(){
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창닫기 버튼 클릭시 종료
    jf.setTitle("주소록 Ver1.0");
    jf.setSize(500,450);
    for(int i=0;i<jb.length;i++){
      jb[i]= new JButton(jb_label[i]);//버튼에 이름표/라벨을 달아줘야한다.*****
      // jb[i].setBounds(20,20,120,30);//버튼 붙이기 전에 해주기
      jp.add(jb[i]);//패널에 버튼을 붙임
      jb[i].addActionListener(this);//버튼에다가 액션리스너를 넣어줘야된다.****** 그리고 나를 넣어줘야된다.*****
      
    }
    jm_file.setMnemonic('F');
    jm_edit.setMnemonic('E');
    jb[0].setIcon(new ImageIcon(imgPath+"new.gif"));
    jb[0].setToolTipText("입력");
    jb[1].setIcon(new ImageIcon(imgPath+"update.gif"));
    jb[1].setToolTipText("수정");
    jb[2].setIcon(new ImageIcon(imgPath+"delete.gif"));
    jb[2].setToolTipText("삭제");
    jb[3].setIcon(new ImageIcon(imgPath+"detail.gif"));
    jb[3].setToolTipText("상세보기");
    jm_file.add(jmi_db);
    jmb.add(jm_file);
    jmb.add(jm_edit);

    jtb.add(jmi_ins);
    jtb.add(jmi_upd);
    jtb.add(jmi_del);
    jtb.add(jmi_read);
    jmi_all.addActionListener(this);// 이벤트소스와 이벤트 핸들러 클래스 매칭
		jb[2].addActionListener(this);// 이벤트소스와 이벤트 핸들러 클래스 매칭
		jb[0].addActionListener(this);
		jb[1].addActionListener(this);
		jb[3].addActionListener(this);
    
    jf.setJMenuBar(jmb);
    jf.setIconImage(titlIcon.getImage());
    jf.setSize(500,450);
    


    //JPannel은 FlowLayout이 기본값인데 사용자의 정의 크기와 위치를 위해
    //레이아웃을 뭉갠다..???
    jp.setLayout(new FlowLayout(FlowLayout.LEFT, 10,20));//가로로 붙여주는 친구
    jf.add("North", jtb);//북쪽으로 붙여주기
    jf.add("Center", jsp_addr);
    jf.setVisible(true);//****순서가 중요*** 다 추가하고 보이게 해야된다.
    
    jmb.add(jm_file);
		jm_file.add(jmi_db);
		jm_file.add(jmi_all);
		jm_file.add(js_exit);
		jm_file.add(jmi_exit);
		jmb.add(jm_edit);
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		jm_edit.add(jmi_read);
  

  }

  //메인메소드

  public static void main(String[] args) {
    // 스윙스킨 입히기
		JFrame.setDefaultLookAndFeelDecorated(true);
    new AddressBook_dap();
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource();
    if(obj==jb[0]){//전체조회-검색
      String members[][]={
        {"1","김도희","010-1234-5678"},
        {"2","이은재","010-4567-8912"},
        {"3","박소연","010-2345-6789"}
      };
      // dtm_addr.setDataVector(members, header);

      //이미 테이블에 조회된 정보가 있는경우 모두 삭제함
      // while(dtm_addr.getRowCount()>0){
      //   dtm_addr.removeRow(0);
      // }//없으면 밑에 추가가 된다.
      for(int i=0;i<members.length;i++){
        Vector<String> oneRow= new Vector<>();//<>제네릭
        oneRow.add(members[i][0]);
        oneRow.add(members[i][1]);
        oneRow.add(members[i][2]);
        dtm_addr.addRow(oneRow);     
      }
      jsp_addr.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){
        public void adjustmentValueChanged(AdjustmentEvent e){
          JScrollBar jsb = (JScrollBar)e.getSource();
          jsb.setValue(jsb.getMaximum());
        }
      }
      );

    }


    if(jb[1]==obj){
      // adb.jdg.setVisible(true);
      // adb.jdg.setTitle(jb_label[0]);//배열의 값를 가져와 "입력"
      adb.setDialog(jb_label[1], true);
    }
    if(jb[2]==obj){
      // adb.jdg.setVisible(true);
      // adb.jdg.setTitle(jb_label[1]);
      adb.setDialog(jb_label[2], true);
    }
    
    if(jb[3]==obj){
    //   adb.jdg.setVisible(true);
    //   adb.jdg.setTitle(jb_label[3]);
    adb.setDialog(jb_label[3], true);
    }

  }
  
}
