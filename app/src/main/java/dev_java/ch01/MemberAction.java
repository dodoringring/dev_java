package dev_java.ch01;

public class MemberAction {
  //회원가입성공 1반환 회원가입 실패하면 0을 반환한다 그렇다면 회원가입을 처리하는 메소드의 리턴타입은 무엇으로해야되나?
  public int memberInsert(String mem_id, String mem_pw, String mem_name){
    System.out.println("memberInsert호출-파라미터3개");
    System.out.println(mem_id+","+mem_pw+","+mem_name);
    int result =-1;
    //회원가입에 성공했니?
    if(1==1){
      result=1;
    }else{
      result=0;
    }

    return result;

  } 

  public int memberInsert(MemberVO memberVO){
    System.out.println("memberInsert호출-파라미터1개");
    System.out.println(memberVO.getMem_id()+","+memberVO.getMem_pw()+","+memberVO.getMem_pw());//getter통해서 꺼내오기
    int result =-1;//프로그램세계에서는 -1은 없다는 뜻. 찾았는데 없을경우에는 -1로쓴다.
    result=1;//다시 1로 초기화
    return result;

  }
  public static void main(String[] args) {
    //insert here-memberInsert 메소드를 호출하시오.
    MemberAction call = new MemberAction();
    int result=call.memberInsert("id", "pw", "name");
    if(result == 1){
      System.out.println("회원가입 성공하였습니다.");
    }
    else{
      System.out.println("회원가입에 실패하였습니다.");
    }
  
    MemberVO call2 = new MemberVO();
    call2.setMem_id("tomato");
    call2.setMem_pw("456");
    call2.setMem_name("토마토");

  }
  
}
