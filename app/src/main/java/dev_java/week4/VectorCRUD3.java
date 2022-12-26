package dev_java.week4;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

import lombok.Builder;
import lombok.Data;

// @Data
// @Builder
public class VectorCRUD3 {

	static Vector<DeptVO> vdept = new Vector<>();
	static Scanner s =new Scanner(System.in);

	public void getDeptList() {
		for (int i = 0; i < vdept.size(); i++) {
			DeptVO dVO = vdept.get(i);
			System.out.print(dVO.getDeptno()+","+dVO.getDname()+","+dVO.getLoc());
			
		} //// end of outter
	}

	public int deptInsert(DeptVO pdVO) {// 지변 - 메소드영역안에서.. 내안에는 부서번호 10만있다. 나머지 두개는 null인 상태이다.
		System.out.println("부서 정보 입력 호출");
		int result = 0;// 1이면 성공, 0이면 실패
		boolean isOk = vdept.add(pdVO);
		if (isOk)
			result = 1;
		return result;
	}
	/*********************************************************************
	 * 벡터에 부서정보 수정하기 - 있는 거를 변경함
	 * @param deptno 수정하고자 하는 부서번호
	 * @param user_dname 수정하고자 하는 부서명
	 * @param user_loc 수정하고자 하는 지역
	 * @return 1이면 성공 0이면 수정실패
	 ********************************************************************/
	public int deptUpdate(DeptVO pdVO) {
		System.out.println("deptUpdate 호출 : 입력받은 부서번호는 "+pdVO.getDeptno());
		int result =0;

		//insert
		System.out.print("수정할 부서번호,부서명, 지역를 입력하세요.(구분은|연산자로 함)");
		VectorCRUD3.s=null;
		VectorCRUD3.s=new Scanner(System.in);

		String user = VectorCRUD3.s.nextLine();//10|인사부|포항->10 개발부 인천이 원본
		int user_deptno = 0;//사용자가 입력한 부서번호 담기
		String user_dname = null;//사용자입력 부서명담기
		String user_loc = null;//사용자 입력 지역명담기
		//문자열 3개를 한번에 받아오기 위해서 StringTokenizer사용함-메신저개발
		StringTokenizer st = new StringTokenizer(user, "|");
		user_deptno = Integer.parseInt(st.nextToken());//사용자가 입력한 부서번호
		user_dname = st.nextToken();//사용자가 입력한 부서명
		user_loc = st.nextToken();//사용자가 입력한 지역
		//사용자가 입력한 부서번호|부서명|지역 을 DeptVO에 멤버변수에 초기화 한것
		DeptVO updVO=DeptVO.builder().deptno(user_deptno).dname(user_dname).loc(user_loc).build();
    //벡터에 들어있는 DeptVO에서 꺼낸 부서번호와 파라미터로 넘겨받은 부서번호가 일치하면
		//그 때 가져온 DeptVO의 인덱스가 우리가 삭제하고 추가해야되는 벡터의 인덱스 값이 된다.
		DeptVO comVO=null;
		for(int i=0;i<vdept.size();i++){
			comVO=vdept.get(i);
			//화면에서 받아온 DeptVO의 deptno와 벡터 안에서 꺼내온 DeptVO의 deptno가 같니?
			if(updVO.getDeptno()==comVO.getDeptno()){
				//화면에서 받아온 부서번호와 벡터에서 꺼낸 부서번호와 같을때 그 때 i값이다.
				vdept.remove(i);
				vdept.add(i,updVO);
				result=1;
				break;//벡터를 반복하는 for문 탈출
			}else{
				System.out.println("선택한 부서번호와 벡터에서 가져온 부서번호가 다르다.");
			}
			getDeptList();//새로고침 처리됨
		}
		return result;
	}

	public int deptDelete(int deptno) {
		System.out.println("부서 정보 삭제 호출");
		int result=0;
		for(int i=0;i<vdept.size();i++){//데이터 영속성을 지원하는 오라클이 없어서 벡터로 대신함
			DeptVO rdVO=vdept.get(i);
			int deptno2=0;
			deptno2=rdVO.getDeptno();
			System.out.println("입력받은 값과 벡터에서 가져온 값을 비교함 :"+deptno+","+deptno2);
			if(deptno==deptno2){//파라미터로 넘어온 부서번호와 벡터에서 꺼낸 부서번호를 비교
			 DeptVO rmVO=vdept.remove(i);
			 if(rmVO!=null)
			 	result=1;
			}
		}
		return result;
		}//// end of deptDelete

	// 벡터에 부서정보 상세보기 - 있는 거를 하나 꺼내 봄
	public DeptVO deptDetail(int deptno) {// or int deptno
		DeptVO rdVO=null;
    //insert here
		return rdVO;
	}

	public static void main(String[] args) {
		VectorCRUD3 vCrud = new VectorCRUD3();
		// 입력테스트
		
		
		DeptVO dvo1=DeptVO.builder().deptno(10).dname("개발부").loc("인천").build();//??????????????????????????
    System.out.println(dvo1.toString());
    int result1 = vCrud.deptInsert(dvo1);// 답
    dvo1=null;//기존에 참조하는 객체와 연결을 끊는다.
    dvo1=DeptVO.builder().dname("총무부").deptno(20).loc("서울").build();
		System.out.println(dvo1.toString());
		result1 = vCrud.deptInsert(dvo1);
		if (result1 == 1) {
			JOptionPane.showMessageDialog(null, "등록이 되었습니다.");
			vCrud.getDeptList();
			// return;//조건문안에 return문 해당 메소드 블록을 빠져나간다.
		}
		//전체조회가 출력됨
		// Scanner s = new Scanner(System.in);
		//수정과 삭제 메뉴 담기
		int result2=0;//수정 성공여부담기 1이면 성공 0이면 실패
		int choice=0;//디폴트
		System.out.println("수정은 1,삭제는 2를 입력하세요.");
		choice=VectorCRUD3.s.nextInt();//10번을 입력했다고 가정
		//담을 수 있는 값은 부서번호 10 뿐이다. dname에는 또 loc에는 뭐가들어있죠? 둘다null이지
		if(choice==1){//true이면 아래코드 실행이됨
			System.out.println("수정하고자 하는 부서번호를 입력하세요.=====>");//10,20 둘중 하나
			int u_deptno=VectorCRUD3.s.nextInt();
			DeptVO updVO=DeptVO.builder().deptno(u_deptno).build();
			result2=vCrud.deptUpdate(updVO);//DeptVO파라미터로 넘김-메인메소드 결정됨-10만있음
			if(result2==1){
			 System.out.println("수정처리되었습니다.");
				vCrud.getDeptList();
			}else 
				System.out.println("수정 실패 하였습니다.");
		}else if(choice==2){
			System.out.println("삭제하고자 하는 부서번호를 입력하세요======>");
			VectorCRUD3.s=null;
			VectorCRUD3.s=new Scanner(System.in);
			int d_deptno=VectorCRUD3.s.nextInt();
			int result3=vCrud.deptDelete(d_deptno);
			if(result3==1){
				System.out.println("삭제처리되었습니다.");
				vCrud.getDeptList();
			}else{
				System.out.println("삭제 실패하였습니다.");
			}

		}
		VectorCRUD3.s.close();	
	}// end of main
}