package dev_java.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev_java.util.DBConnectionMgr;

public class ListDeptVO {
  DBConnectionMgr dbMgr= new DBConnectionMgr();
  Connection con =null;
  PreparedStatement pstmt=null;
  ResultSet rs =null;//오라클 테이블에서 제공되는 커서를 조작하는 함수제공


    public List<DeptVO> getEmpList(){
      List<DeptVO> list =null;
      StringBuilder sql= new StringBuilder();
      sql.append("SELECT                      ");
      sql.append("        empno, ename, dname");
      sql.append("  FROM emp, dept            ");
      sql.append("  WHERE emp.deptno = dept.deptno");
      try {
        con=dbMgr.getConnection();
        pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery();
        list= new ArrayList<>();//list.size()=0
        DeptVO dVO= null;
        while(rs.next()){ //테이블에 한 줄을 가져온다 있으면 돌아라
          dVO =new DeptVO();//디폴트 생성자를 호출함 0 null
          // dVO =new DeptVO(0,null,rs.getString("dname"));//쌤은 파라미터있는걸로 받아오심
          // System.out.println(rs.getInt("empno")+","+rs.getString("ename")+","+rs.getString("dname"));
          dVO.setDeptno(Integer.parseInt(rs.getString("empno")));//getString으로 쿼리문의 실행 결과를받아온다. 
          //그리고 내가 넣어준다. set으로 DeptVO클래스에 
          dVO.setDname(rs.getString("dname"));
          dVO.setLoc(rs.getString("ename"));
          list.add(dVO);//0부터 차례로 들어간다.
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
        return list;
    }
    public static void main(String[] args) {
    
      ListDeptVO listDeptVO= new ListDeptVO();
      List<DeptVO> list =null;
        list=listDeptVO.getEmpList();
      System.out.println("list : "+list);
      for(DeptVO rdVO: list){
        System.out.println(rdVO);//while문을 타지않으면 null인상태
        System.out.println(rdVO.getDeptno()+","+rdVO.getDname()+","+rdVO.getLoc());
      }
  
    }

}
  

