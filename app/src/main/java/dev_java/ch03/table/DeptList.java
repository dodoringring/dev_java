//package dev_java.ch03.table;
//
//import java.util.Vector;
//
//public class DeptList {
//  //부서등록 성공1 실패0
//  // int deptInsert(int deptno, String dname, String loc){//변수가 3개보다 많은면 어쩔거니? 이렇게 안쓴다.
//  //   int result=-1;
//  //   return result;
//  // }
//  Vector<DeptVO> vdept= new Vector<>();
//
//
//  int deptInsert(DeptVO pdVO){
//    int result=-1;
//    if(vdept.add(pdVO)){
//    result=1;
//    }else{
//     result=0;
//    }
//    return result;
//  }
//  //부서수정-부서명과 지역만 수정할 수 있다.
//  int deptUpdate(int deptno){//부서번호만 넘기면 된다. 고유하니까
//    int result=-1;
//    if(vdept.equals(deptno)){
//
//    }
//
//    return result;
//  }
//  //부서삭제
//  int deptUpdate(int deptno){
//    int result=-1;
//    if(vdept.equals(deptno)){
//      vdept.remove(vdept);
//    }
//  return result;
//  }
//  //부서정보상세보기
//
//  public static void main(String[] args) {
//
//  }
//
//}
