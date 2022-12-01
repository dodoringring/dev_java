package dev_java.ch01;

public class DeptVOMain{//클래스를 나누어 사용했다.메인 따로 빼서 재사용성 극대화!! 
  public static void main(String[] args) {
    DeptVO deptVO = new DeptVO();
    deptVO.deptno=10;
    deptVO.dname="개발1팀";
    System.out.println(deptVO.deptno);
    System.out.println(deptVO.dname);//개발1팀
    deptVO =new DeptVO();//변수 선언이 아니라 객체생성
    deptVO.deptno=30;//타입은 같지만 새로운 객체이다
    deptVO.deptno=30;//동시에 한 변수에 다른 값 넣을수없다.
    System.out.println(deptVO.deptno);//0
    System.out.println(deptVO.dname);//null
    System.out.println(deptVO.loc);
    
    
  }
  
}
