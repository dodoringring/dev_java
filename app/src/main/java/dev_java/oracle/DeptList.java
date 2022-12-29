package dev_java.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;//커서를 조작하는 인터페이스
import java.util.ArrayList;
import java.util.List;

import dev_java.util.DBConnectionMgr;

public class DeptList {
  Connection con =null;
  PreparedStatement pstmt=null;
  ResultSet rs =null;
  DBConnectionMgr dbMgr =new DBConnectionMgr();

  public List<DeptVO> getDeptList(){
    con = dbMgr.getConnection();
		String sql="SELECT deptno, dname, loc FROM dept";
    List<DeptVO> deptList= new ArrayList<>();
    try{
		  pstmt = con.prepareStatement(sql);
		  rs = pstmt.executeQuery();//오라클 서버에게 처리를 요청함.
      DeptVO dVO=null;
        while(rs.next()){//4번 반복한다. next의 리턴타입 불리언.
          //get으로 가져올때 columnLabel로한다.
          dVO=DeptVO.builder().deptno(rs.getInt("deptno")).dname(rs.getString("dname")).loc(rs.getString("loc")).build();
          deptList.add(dVO);
        }
    }catch(Exception e){

    }
    return deptList;
}
  public static void main(String[] args) {
    DeptList deptList =new DeptList();
    List<DeptVO> list=null;
    list=deptList.getDeptList();
    
    for(DeptVO rdVO:list){
      System.out.println(rdVO.getDeptno()+","+rdVO.getDname()+","+rdVO.getLoc());
    }

    for(int i=0;i<list.size();i++){
      System.out.print(list.get(i).deptno+",");
      System.out.print(list.get(i).dname+",");
      System.out.println(list.get(i).loc);
    }


  }
  
}
