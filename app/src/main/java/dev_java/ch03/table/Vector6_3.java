package dev_java.ch03.table;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Vector6_3 {//메소드 분리. 삭제 기능추가
  String[][] dept={
    {"10","개발부","서울","도희"},
    {"20","인사부","인천","은재"},
    {"30","총무부","부산","정윤"}
  };
  Vector <String[]> vdept= new Vector<>();//전역변수. 1차 배열을 받는 벡터

  void initVector(){
    
    for(int i=0; i<dept.length;i++ ){
        vdept.add(dept[i]);//벡터에 담기는 것은 1차배열이다.-컬럼의 수는 바뀔 수 있다.
        // System.out.println(Arrays.toString(dept[i]));
    }
  }

  void initVectorPtint(){
  for(int i=0; i<vdept.size();i++){//사이즈는 로우의 크기
    String[] oneRow=vdept.get(i);// 이차배열을 한줄씩 뽑아서 일차배열로 만들고 싶다!
    System.out.println(oneRow.toString());// 그일차배열의 값을 프린트한다. toString은 주소를 가져온다
    for(int j=0;j<oneRow.length;j++){//1차 배열의 열을 가져왔다.
    System.out.print(oneRow[j]+" ");//하나하나뽑기
      }
      System.out.print("\n");
    }
  }

  public static void main(String[] args) {
    Vector6_3 v=new Vector6_3();
    v.initVector();//경유해야 값이 들어감
    System.out.println(v.vdept.get(0));//
    // v.vdept.get(0);->
    // v.vdept.get(1);->
    // v.vdept.get(2);->
    System.out.println(v.vdept.size());
    v.initVectorPtint();
    System.out.println("삭제하고자 하는 부서번호를 입력하세요.");
    Scanner s = new Scanner(System.in);
    int deptno=s.nextInt();
    for(int i=0;i<v.vdept.size();i++){
      String[] oneRow =v.vdept.get(i);
      if(deptno == Integer.parseInt(oneRow[0])){
       v.vdept.remove(i);
      }
    }
  }//end of mian 
    
}
