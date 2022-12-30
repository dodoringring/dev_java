package dev_java.week6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dev_java.util.DBConnectionMgr;

public class ZipCodeSearch {
  Connection con = null;// 인터페이스-결합도가 약하다. 이종간의 연결을 위해서. 의존적이지 않다.
  PreparedStatement pstmt = null;// 인터페이스
  ResultSet rs = null;// 인터페이스
  DBConnectionMgr dbMgr = new DBConnectionMgr();

  public Integer[] getZipcode(String dong) {// 우편번호를 가져올거다. int타입 변수이다. 넣어줄 값은 동이름이다. 스트링리다.
    System.out.println("getZipcode 호출 성공====>" + dong);
    Integer[] zipcodes = null;// 몇개 나올지 나도 모르겠다.
    // List<Integer> imsi=new ArrayList<>();
    Vector<Integer> imsi = new Vector<>();// copyInto쓰려고 벡터로 바꿨다...
    StringBuilder sql = new StringBuilder();//sql문을 
    sql.append("select");// 띄어쓰기를 해야 append가 붙일때 잘 붙인다....
    sql.append(" zipcode");
    sql.append(" from zipcode_t");
    sql.append(" where dong like :x||'%'");

    try {
      con = dbMgr.getConnection();//오라클이랑 연결을 해줌
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dong);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        System.out.println(rs.getInt("zipcode"));
        int code = rs.getInt("zipcode");
        imsi.add(code);
      }
      zipcodes = new Integer[imsi.size()];
      imsi.copyInto(zipcodes);
      for (int c : zipcodes) {
        System.out.println(c);
      }
    } catch (Exception e) {
      e.printStackTrace();// 라인번호가 출력, 이력출력. 해커들에게 힌트가 됨

    } finally {// 무조건 닫아주자!!!!
      dbMgr.freeConnection(con, pstmt, rs);
    }
    return zipcodes;
  }
  // public List<Integer> getZipcode(String dong){//우편번호들이 다 숫자다. 배열로 담을 수 있다.

  // }

  public static void main(String[] args) {
    ZipCodeSearch zcs = new ZipCodeSearch();
    zcs.getZipcode("잠실");
  }

}
