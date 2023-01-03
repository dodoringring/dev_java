package dev_java.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev_java.util.DBConnectionMgr;

public class ListMap {
  DBConnectionMgr dbMgr= new DBConnectionMgr();
  Connection con =null;
  PreparedStatement pstmt=null;
  ResultSet rs =null;//오라클 테이블에서 제공되는 커서를 조작하는 함수제공


    public List<Map<String,Object>> getEmpList(){
      List<Map<String,Object>> list =null;
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
        Map<String, Object> rmap= null;
        while(rs.next()){ //테이블에 한 줄을 가져온다 있으면 돌아라
          rmap =new HashMap<>();
          rmap.put("번호",rs.getInt("empno"));//키는 내가 정해주는거고 뒤에오는게 오라클에서 받은것
          rmap.put("ename",rs.getString("ename"));
          rmap.put("dname",rs.getString("dname"));
          list.add(rmap);//0부터 차례로 들어간다.
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
        return list;
    }
    public static void main(String[] args) {
      ListMap rm =new ListMap();
      List<Map<String, Object>> list=null;
      list =rm.getEmpList();
     
      System.out.println("list : "+list);

      for(Map<String,Object> rmap:list){
        System.out.println(rmap.get("empno")+","+rmap.get("dname")+","+rmap.get("ename"));
      }
    }
  
}
  

