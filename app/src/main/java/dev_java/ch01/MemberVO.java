package dev_java.ch01;

//자료구조의 일부로 사용함
//회원정보를 관리하기위한 목적으로 설계하였다. 그래서 메인메소드는 필요없다
public class MemberVO {
  private String mem_id = null;
  private String mem_pw = null;
  private String mem_name = null;

  public String getMem_pw() {
    return this.mem_pw;
  }

  public void setMem_pw(String mem_pw) {
    this.mem_pw = mem_pw;
  }

  public String getMem_name() {
    return this.mem_name;
  }

  public void setMem_name(String mem_name) {
    this.mem_name = mem_name;
  }

  // setter는 write, save
  public void setMem_id(String mem_id) {
    this.mem_id = mem_id;
  }

  // getter는 듣기, read의 느낌
  public String getMem_id() {
    return mem_id;
  }

  public static void main(String[] args) { // static 이 없으니까 인스턴스화를 한다. 같은 클래스라도. 같은 클래스 내에서는 프라이빗 사용가능
    MemberVO memberVO = new MemberVO();
    System.out.println(memberVO.mem_id);
  }

}
