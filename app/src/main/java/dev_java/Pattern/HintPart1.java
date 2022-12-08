package dev_java.Pattern;

public class HintPart1 {
  // 선언부
  // 기회 9번주자
  // 컴터가 채번한 숫자를 담을 1차 배열 선언
  int com[] = new int[3];
  // 사용자가 입력한 문자열 쪼개서 담을 변수 선언
  int my[] = new int[3];
  // 회차 담을 변수
  int cnt = 0;

  // 새게임 버튼을 누르면 3자리의 서로 다른 숫자를 채번한다.
  public void ranCom() {
    com[0] = (int) (Math.random() * 10);// 10을 곱하는 이유는 늘리기 위함 랜덤이 더블형으로 나옴0.0~1.0
    // 중복된 숫자를 제거하는 목적으로 do-while선택함
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[1]);
    do {
      com[1] = (int) (Math.random() * 10);
    } while (com[0] == com[2] || com[1] == com[2]);
  }

  // 3자리 숫자를 받아서 힌트문을 작성해주는 메소드 구현
  public String account(String user) {

    if (user.length() != 3) {
      return "세자리만 입력";// account 메소드 탈출하기
    }

    int imsi = 0;// 파라미터로 넘어온 사용자가 입력한 문자열을 값을 정수형으로 변환 담기
    int strike = 0;
    int ball = 0;

    try {// 예외처리
      imsi = Integer.parseInt(user);
    } catch (NumberFormatException e) {
      return "숫자 입력해라.";
    } // 예외처리 끝

    my[0] = imsi / 100; // 256/100이면 만약에--->2.56int/int--->2만 남음
    my[1] = (imsi % 100) / 10;// 256%100->56/10->5/6->5만남음
    my[2] = imsi % 10;// 256/10->몫은 25고 나머지는 6이다.
    for (int i = 0; i < com.length; i++) {// 입력받은 숫자가 com배열에 존재하니? 네-볼 /아니오-제외
      for (int j = 0; j < com.length; j++) {//
        // 만일 위에서 네 라면 스트라이크 인지를 검사한다 com배열의 i자리와 my배열의 j자리가 같니?
        // 숫자가 있어?
        if (com[i] == my[j]) {// 같은 숫자가 있는지만 비교하고 자리가 달라도 참이다.
          // 볼은 확보 되었다. 자리가 같은지 비교하자
          // 숫자의 자리도 같아?

          if (i == j) {// 42번에서 비교한 숫자의 자리가 사용자가 입력받은 자리까지도 같은거야? 네-스, 노-볼
            strike++;
          } else {
            ball++;
          }

        } // 입력받은 숫자가 채번한 숫자와 일치하는 경우
      } //// end of inner for문
    } //// end of outter for문
      // strike변수값이 3이면 55번은 실행될 기회를 못 갖는다.
    if (strike == 3)
      return "정답";
    return strike + "스" + ball + "볼";
  }////// end of account

  public static void main(String[] args) {

  }

}
