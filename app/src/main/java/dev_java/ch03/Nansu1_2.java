package dev_java.ch03;

import java.util.Scanner;

public class Nansu1_2 {// 야구게임 확장예정
  int com = -1;// 사용자가 값 넣는 동안에는 바뀌면 안되니까 전역변수
  // int my=-1; no필요 값이 바뀌니까 지변으로

  public void ranCom() {
    com = (int) (Math.random() * 10); // 10을 곱하면 0~9사이의 숫자를 선택할수있다.
  }

  // user변수 때문에 변수 my를 삭제하였다.
  // 사용자가 입력한 값을 지변에 담아야 하는 이유에 대해 설명하시오.
  // 또 com변수는 왜 전역변수 이어야만 하는것인가?
  public String account(int user) {
    String msg = null;
    // 정답보다 입력한 값이 작니?
    if (com > user) {
      msg = "높여라";
    } else if (com < user) {
      msg = "낮춰라";
    } else if (com == user) {
      msg = "정답";
      // return msg; // if문에서 해당 메소드를 탈출할때 return예약어 사용가능하다.
      // 반복문에서는 break;사용한다
    }
    return msg;
  }

  public static void main(String[] args) {
    // 실행하자마자 채번하도록 코딩하시오--->생성자를 활용
    // 생성자역할-전변 초기화, 부모클래스 초기화 포함-상속
    Nansu1_2 nansu1_2 = new Nansu1_2();
    // 컴퓨터가 채번한 값을 초기화 하는 메소드 호출하기
    nansu1_2.ranCom();// 새게임을 누르면 -재사용성, 정답을 봤니?

    // 컴터가 채번한 숫자를 출력하시오
    System.out.println("컴퓨터가 채번한 숫자는 =====>" + nansu1_2.com);// 전변이다. 그러니까 인스턴스 변수. 유지
    // Scanner를 활용하여 사용자가 입력한 값을 받으시오.
    Scanner s = new Scanner(System.in);// 장치로부터 듣기-소통-매번새로받아옴-반복문 안에 올것
    int i = 1;// 회차를 표시하는 변수선언. 사람마다 횟수 다름. 동시에 플레이할수있잖아. 스태틱으로 하면 안됨.
    String 입력값 = null;
    String 반환값 = null;
    // 게임기회는 5회로 제한하시오
    while (i < 4) {// 주의사항-무한루프 방지 코드- break;
      System.out.println("0부터 9까지 입력하시오.");
      입력값 = s.nextLine();// 사용자가 입력한 값 받아오기. 사용자에게 보이면 안된다. 스캐너 클래스의 넥스트메소드
      System.out.println(입력값);// null이 아닌지 확인 해 본다.
      // 알면서도 잡지 못하는 Exception-> NumberFormatException
      int user = Integer.parseInt(입력값);// NumberFormatException
      반환값 = nansu1_2.account(user);
      i++;
      if ("정답".equals(반환값)) {// 만약 정답이랑 같으면 이퀄 앞에 스트링이 온다
        // 정답을 반환했을경우 축하합니다. 라고 말한뒤
        // 새 게임 진행 여부를 물어보시오.--> 초기화해야된다.
        System.out.println("축하합니다.");
        // System.out.println("다시 게임을 시작하시겠습니까?y/n");
        // String yes=s.nextLine();
        // if(yes.equals("y")){
        // i=1;//1회차부터 다시 시작.
        // } else if(!yes.equals("y")){

        // }
        i = 4;// 정답을 맞추고 다시 4로 초기화시켰다.
        // break;/////while문에서 제일 중요!!!!!if조건을 만족하면은 깨고 나오게 만든다.
      }
      // 시도할때마다 몇 번째 기회를 사용하는지 출력하시오.
      System.out.println(user + ":" + 반환값);
      // i++;
      // 주어진 기회를 모두 사용했습니다.
      if (i == 4) {
        System.out.println("주어진 기회를 모두 사용 또는 정답을 맞추었습니다.\n 새게임을 시작하려면 Y/N을 입력하세요.");
        String choice = s.nextLine();
        if ("Y".equals(choice)) {
          // 새게임시작 새로 채번
          nansu1_2.ranCom();
          System.out.println("새게임을 시작합니다.==>정답:" + nansu1_2.com);
          i = 1;
        } else if ("N".equals(choice)) {
          System.out.println("종료합니다.");
          System.exit(0);// break 대신에 노 했을때 끄도록 만듦
        }

      }

    } ////// end of while
    s.close();// Stream,I/O,network, 사용 후 반드시 닫는다.
    // 시도 할 때 마다 몇 번째 기회를 사용하는지 출력하시오

    // 정답을 맞췄을경우 축하합니다. 라고 말한뒤

    // 새게임 진행 여부를 물어보시오.

  }

}
