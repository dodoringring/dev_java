package dev_java.ch01;

public class MemberVOMain {

  public static void main(String[] args) {
    MemberVO memberVO = new MemberVO();
    String 사용자가입력한아이디 = "tomato";
    System.out.println(사용자가입력한아이디);
    //
    memberVO.setMem_id(사용자가입력한아이디);

    memberVO.setMem_id("tomato");// 파라미터에 값을 넣기위해 적은거임
    String id = memberVO.getMem_id();
    System.out.println(id);
    System.out.println(memberVO.getMem_id());

    memberVO.setMem_name("이순신");//setter메소드를 호출 하는것 만으로도 초기화 됨
    System.out.println(memberVO.getMem_name());//이순신 출력
    memberVO.setMem_pw("123");
    System.out.println(memberVO.getMem_pw());


  }
  // mem_name의 경우 접근제한자를 public으로 했으므로 직접 초기화가 가능하다.
}
