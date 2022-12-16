package dev_java.ch03.table;

import java.util.Arrays;
import java.util.Vector;

public class Vector6_1 {//쌤 답안
  public static void main(String[] args) {
    String[][] dept={
      {"부서번호","부서명","지역"},
      {"10","개발부","서울"},
      {"20","인사부","인천"},
      {"30","총무부","부산"}
    };

  Vector <String[]> vdept= new Vector<>();//1차 배열을 받는 벡터
    for(int i=0; i<dept.length;i++ ){
        vdept.add(dept[i]);
        System.out.println(Arrays.toString(dept[i]));
    }
    for(int i=0;i<vdept.size();i++){
      String[] oneRow=vdept.get(i);
      for(int j=0;j<oneRow.length;i++){
      System.out.println(oneRow[j]+" ");
      }//end of inner for
    }//outer for


  }//end of mian 
    
}
