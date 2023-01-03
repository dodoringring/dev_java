package dev_java.basic;
//블럭 설정 후 게터 세터 저너레이터로 만들기-데이터를 사용하기 위해서
public class DeptVO {//변수있고 게터 세터가 있다? VO에 이런게 있다.
  private int deptno;
  private String dname;
  private String loc;
  //디폴트 생성자는 필요없지만 파라미터가 있는 생성자가 하나라도 선언되면 
  //제공하는 것을 원칙으로 한다.
  public DeptVO(){}//디폴트 생성자
  public DeptVO(int deptno,String dname, String loc){//값을 받는 생성자
    this.deptno=deptno;
    this.dname=dname;
    this.loc=loc;
  }

  public int getDeptno() {
    return this.deptno;
  }

  public void setDeptno(int deptno) {
    this.deptno = deptno;
  }

  public String getDname() {
    return this.dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }

  public String getLoc() {
    return this.loc;
  }

  public void setLoc(String loc) {
    this.loc = loc;
  }
  
}
