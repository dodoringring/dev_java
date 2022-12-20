package dev_java.week4;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
//List-순서, 느리다, 정렬(2차가공-속도-3초조회), 추가하면 맨 뒤에 채운다.
//index가 다르면 중복값 저장가능

import javax.swing.JOptionPane;

public class VectorCRUD {
  static Vector <String[]> vdept = new Vector<>();//전역변수이므로 유지가 된다. 스태틱이 있어서 공유된다. 복제본을 절대 만들지 않는다.
  static Vector <DeptVO> vdept2 = new Vector<>();//전역변수이므로 유지가 된다. 스태틱이 있어서 공유된다. 복제본을 절대 만들지 않는다.
  
  public void getDeptList(){
    for(int i=0;i<vdept.size();i++){
      String[] oneRow=vdept.get(i);
      for(int j=0;j<oneRow.length;j++){
        System.out.println(oneRow[j]+",");
      }//end of inner for
      System.out.println();
    }//end of outter for
  }
  //백터에 부서정보 추가하기-없는 거를 새로 추가함
  public int deptInsert(String[] userDeptno){
    System.out.println("부서정보 입력 호출");
    int result=0;//1이면 성공 0이면 실패
    boolean isOk=vdept.add(userDeptno);


    return result;
  }
  /* 
  //벡터에 부서정보 수정하기
  @param deptno 수정하고자하는 부서번호
  @param user_dname 수정하고자하는 부서명
  @param user_loc 수정하고자하는 지역
  @return 1이면 성공 0이면 실패
  */
  public int deptUpdate(int deptno, String user_dname, String user_loc){
    System.out.println("부서정보 수정 호출 :"+user_dname+","+user_loc);
    String[] oneRow=null;
    String[] comRow=null;//얕은복사 깊은 복사 내일 시험
    for(int i=0;i<vdept.size();i++){
      comRow=vdept.get(i);
      if(deptno==Integer.parseInt(comRow[0])){
        //깊은 복사-각자바뀐다
        oneRow=comRow;//얕은 복사-하나를 바꾸면 나도 바뀐다.
      }
    }

    int result=0;//1이면 성공 0이면 실패
    for(int i=0;i<vdept.size();i++){
      String row[]=vdept.get(i);//i는 로우인덱스이다.
      //if()여기는 벡터에서 꺼낸 배열을 갖는다.
      for(int j=0;j<row.length;j++){//String[]돌림
        if(oneRow[0].equals(row[0])){//여기는 화면에서 가져온 배열과 벡터에서 꺼낸 배열을 비교한다.
          String[] updRow = {oneRow[0], user_dname, user_loc};
          vdept.remove(i);
          vdept.add(i,updRow);
          break;
          }else{
            System.out.println("선택한 부서번호와 ");  
          }
      }//end of String[]
      
     
    }//end of Vector
      return result;
   
  }
  //벡터에 부서정보 삭제하기-있는거를 삭제함
  //백터에 있는 부서 정보 중에서 어떤 로우를 삭제할 것인지 부서번호를 받아와야함
  //이것은 사용자로 부터 받아와야하는 값임
  //그런데 int형 String[]에서 부서번호는 String타입
  //그러니까 형전환 필요함- 그런데 null이 와면 numberFormatExeption이 발생할 가능성이 있음
  //방어코드 작성 필요함-null에 대한 이슈는 현재 프로그래밍에 있어 심각한 장애로 인식 - 중요한 문제임
  public int deptDelete(int deptno){//스캐너로 번호 받아와
    System.out.println("부서정보 삭제 호출");
    int result=0;//1이면 성공 0이면 실패
    for(int i=0;i<vdept.size();i++){
      String oneRow[]=vdept.get(i);
      int deptno2=0;
      //예외 발생에 대한 우려 방어코드 작성 함.
      if(oneRow[0]!=null){// 널 체크를 하였다-이것까지도 프레임 워크에서 떠안으려하고있다. 이미 떠안았다.
        deptno2=Integer.parseInt(oneRow[0]);
        }
        //사용자가 선택한 부서번호와 벡터에 있는 부서번호를 비교하여 같은 것 찾기함
        if(deptno==deptno2){
          //삭제 할 벡터의 로우값이 필요함- 이것은 벡터의 size를 통해 찾아냄
          //여기서는 변수 i가 인덱스 값에 해당함
          //remove메소드의 파라미터가 int인경우에 대해서만 삭제된 벡터의 제네릭
          //반환해줌. 그것을 받아서 처리 여부 확인 가능함
        String[] deleteRow=vdept.remove(i);//리무브는 숫자넣으면 지운값을 돌려보내고 객체를 넣으면 트루폴스를 돌려보낸다
        boolean isOk=vdept.remove(oneRow);//메소드 오버 로딩이라고 한다.***내일 시험***
        //삭제한 객체가 존재하니? 네:삭제 되었음 아니:삭제 안됨
        if(deleteRow!=null){
         JOptionPane.showMessageDialog(null,"삭제 처리 되었습니다.");
         //삭제 처리가 성공 한 경우이므로 반환값 1 리턴해줌. 끝 
         result=1;//응답
        }
      }
      return result;
    }

    return result;
  }

  //벡터에 부서정보 상세보기-있는거를 하나 꺼내봄
  public String[] detpDetail(int index){//또는 int deptno정도 있어야
    String[] oneRow=new String[3];
    int x= Integer.parseInt(vdept.get(0)[0]);
    for(int i=0;i<vdept.size();i++){
      if(x==index){
        oneRow=vdept.get(i);
      }
    }
    return oneRow;
  }

  public static void main(String[] args) {
    VectorCRUD vCrud =new VectorCRUD();
    //입력테스트
    int deptno=10;
    String dname="개발부";
    String loc="인천";
    String[] oneRow={"10","개발부","인천"}; //제네릭 타입으로 쓸거야
    String[] oneRow2={"20","개발부","인천"}; //제네릭 타입으로 쓸거야
    // int result1=vCrud.deptInsert(deptno,dname,loc);//코드의 양이 늘어난다
    // //둘중에 무엇으로 할까?-메소드 오버로딩
    int result1 =vCrud.deptInsert(oneRow);
    result1=vCrud.deptInsert(oneRow2);
    if(result1==1){
    JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
      vCrud.getDeptList();
      return;
    }
    Scanner s =new Scanner(System.in);
    System.out.println("삭제 부서번호 입력하세요.");
    int user=s.nextInt();
    //삭제테스트
    int result3 =vCrud.deptDelete(user);
    if(result3==1){
      JOptionPane.showMessageDialog(null, "삭제가 되었습니다.");
      vCrud.getDeptList();
      // return; 리턴문 해당 메소드 블록을 빠져나간다. 
    }
    s.close();//스캐너는 반드시 클로즈를 해야된다. 근데 위에서 리턴으로 메소드 빠져나가게하면 스캐너를 못한다.
     s =new Scanner(System.in);
    System.out.println("수정할 부서번호,부서명,지역명을 입력하세요.(구분은|)");
    String user1=s.nextLine();
    int user_deptno=0;
    String user_dname=null;
    String user_loc=null;
    StringTokenizer st=new StringTokenizer(user1,"|");
    user_deptno=Integer.parseInt(st.nextToken());//사용자가 입력한 부서번호
    user_dname=st.nextToken();//사용자가 입력한 부서명
    user_loc=st.nextToken();//사용자가 입력한 지역
    
    // System.out.println("수정할 부서명을 입력하세요.");
    // String user_dname=s.nextLine();
    
    // System.out.println("수정할 지역을 입력하세요.");
    // String user_loc=s.nextLine();
    //수정테스트
    int result2=vCrud.deptUpdate(user_deptno,user_dname,user_loc);
    if(result2==1){
      JOptionPane.showMessageDialog(null, "수정이 되었습니다.");
      return;
    }


    //상세보기 테스트
    String[] result4=vCrud.detpDetail(deptno);
  }
  
}
