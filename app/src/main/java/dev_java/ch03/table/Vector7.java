package dev_java.ch03.table;

import java.util.Vector;

public class Vector7 {
  public static void main(String[] args) {
    String[][] dept={
      {"10","개발부","서울"},
      {"20","인사부","인천"},
      {"30","총무부","부산"}
    };
    Vector <DeptVO> vdept= new Vector<>();

    DeptVO[] dVOS= new DeptVO[3];
    DeptVO dvo= new DeptVO(10,"개발부","서울");
    dVOS[0]=dvo;
    vdept.add(dvo);
    dvo=new DeptVO(20,"인사부","인천");
    dVOS[1]=dvo;
    vdept.add(dvo);
    dvo=new DeptVO(30,"총무부","부산");
    dVOS[2]=dvo;
    vdept.add(dvo);

    
  }
  
}
