package dev_java.basic.basic3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import dev_java.util.DBConnectionMgr;

public class ZipcodeSearchView extends JFrame implements ItemListener {
  // 선언부
  // 게으른 인스턴스화-오라클과 연동하기 위해
  // 사용자가 선택한 zdo
  String zdo = null;
  // 사용자가 선택한 sigu
  String sigu = null;
  // 시용자가 선택한 dong
  String dong = null;
  // 콤보에는 배열이 들어가더라
  // DB에서 가져온 zdos[]
  String[] zdos = null;
  // DB에서 가져온 sigus[]
  String[] sigus = null;
  // DB에서 가져온 dongs[]
  String[] dongs = null;
  // 중분류(sigu), 소분류(dong)
  String[] totals = new String[]{"전체"};

  JPanel jp_north = new JPanel();
  JComboBox jcb_zdo = null;
  JComboBox jcb_sigu = null;
  JComboBox jcb_dong = null;
  DBConnectionMgr dbMgr = new DBConnectionMgr();
  Connection con = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  // 생성자
  public ZipcodeSearchView() {
    zdos = getZDOList();
    jcb_zdo = new JComboBox(zdos);
    jcb_sigu = new JComboBox(totals);
    jcb_dong = new JComboBox(totals);
    jcb_zdo.addItemListener(this);
    jcb_sigu.addItemListener(this);
    jcb_dong.addItemListener(this);
  }

  // 대분류 정보 초기화에 필요한 DB조회하기 구현
  public String[] getZDOList() {
    StringBuilder sql = new StringBuilder();
    sql.append("select '전체' zdo from dual ");
    sql.append(" union all                  ");
    sql.append(" select  zdo                ");
    sql.append(" from (         ");
    sql.append("   select distinct(zdo) zdo");
    sql.append("   from zipcode_t  ");
    sql.append("   order by zdo asc)");
    try {
      // con의 주소번지가 확인 되면 오라클 서버와 연결통로가 확보되었다.
      con = dbMgr.getConnection();
      // 전령의 역할. 정적-스테이트먼트 동적-프리페어드스테이트먼트
      pstmt = con.prepareStatement(sql.toString());
      // 오라클에서 생성된 테이블의 커서 디폴트위치는 항상 isTop이다.커서가 존재하는데...이동시킴
      rs = pstmt.executeQuery();
      Vector<String> v = new Vector<>();
      // rs.previous(); ???
      while (rs.next()) {
        String zdo = rs.getString("zdo");
        v.add(zdo);
      }
      zdos = new String[v.size()];
      v.copyInto(zdos);
    } catch (SQLException se) {
      System.out.println(se.toString());// getMessage();도 가능
      System.out.println(sql.toString());// 위에서 쓴 쿼리문 프린트
    } finally {
      // 사용한 자원 반납하기-생성의 역순으로 할것
      // 생략해도 언젠가 반납은 이루어짐-명시적으로 반납처리 권장함
      // 왜냐하면 오라클 서버에서 커넥션을 강제로 종료시켜버리니까...
      try {
        dbMgr.freeConnection(con, pstmt, rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return zdos;
  }// end of getZDOList

  public String[] getSiguList(String zdo) {
    StringBuilder sql = new StringBuilder();
    sql.append("select '전체' sigu from dual ");
    sql.append(" union all                  ");
    sql.append(" select  sigu                ");
    sql.append(" from (         ");
    sql.append("   select distinct(sigu) sigu");
    sql.append("   from zipcode_t  ");
    sql.append("   where zdo=?  "); //오라클에서 :zdo가 ?변수됨
    sql.append("   order by sigu asc)");
    try {
      // con의 주소번지가 확인 되면 오라클 서버와 연결통로가 확보되었다.
      con = dbMgr.getConnection();
      // 전령의 역할. 정적-스테이트먼트 동적-프리페어드스테이트먼트
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1,zdo);
      // 오라클에서 생성된 테이블의 커서 디폴트위치는 항상 isTop이다.커서가 존재하는데...이동시킴
      rs = pstmt.executeQuery();
      Vector<String> v = new Vector<>();//coptInto메소드 사용 위해서 그대로 복사하려고
      // rs.previous(); ???
      while (rs.next()) {
        String sigu = rs.getString("sigu");
        v.add(sigu);
      }
      //시구 콤보박스에 들어갈 배열 생성하기
      sigus = new String[v.size()];
      //벡터에 들어있는 값 스트링 배열에 복사하기
      v.copyInto(sigus);
    } catch (SQLException se) {
      System.out.println(se.toString());// getMessage();도 가능
      System.out.println(sql.toString());//위에서 쓴 쿼리문 프린트
    } finally {
      // 사용한 자원 반납하기-생성의 역순으로 할것
      // 생략해도 언젠가 반납은 이루어짐-명시적으로 반납처리 권장함
      // 왜냐하면 오라클 서버에서 커넥션을 강제로 종료시켜버리니까...
      try {
        dbMgr.freeConnection(con, pstmt, rs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sigus;
  }
  public String[] getDongList(String zdo, String sigu){
    
    return dong;
  }

  // 화면처리부
  public void initDisplay() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jp_north.add(jcb_zdo);
    jp_north.add(jcb_sigu);
    jp_north.add(jcb_dong);

    this.add("North", jp_north);
    this.setSize(630, 400);
    this.setVisible(true);
  }

  // 메인
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    ZipcodeSearchView zcsv = new ZipcodeSearchView();
    zcsv.initDisplay();

  }

  @Override
  public void itemStateChanged(ItemEvent ie) {
    //이벤트가 감지되는 소스 가져오기
    Object obj=ie.getSource();
    //너 ZDO콤보박스니??
    if(obj==jcb_zdo){
      if(ie.getStateChange()==ItemEvent.SELECTED){
        System.out.println("선택한 ZDO===>"+ zdos[jcb_zdo.getSelectedIndex()]);
        zdo=zdos[jcb_zdo.getSelectedIndex()];
        sigus=getSiguList(zdo);
        //대분류가 결정이 되었을때  sigus를 초기화 해줘야 한다.
        //기존에 디폴트로 전체 상수값을 넣어 두었으니 이것을 삭제하고
        jcb_sigu.removeAllItems();//아까 토탈 넣어놓은거 지워줌
        //새로운 DB서버에서 읽어온 값으로 아이템을 추가 해야 한다.-초기화
        for(int i=0;i<sigus.length;i++){
          jcb_sigu.addItem(sigus[i]);

        }
      }
    }
    
  }

}
