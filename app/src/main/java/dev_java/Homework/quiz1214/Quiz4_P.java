package dev_java.Homework.quiz1214;

/* 문제 4 

0부터 9까지의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오. 기회는 단 5번 그후에는 빠져나오게.

java.util.Random

Random r =new Random();

힌트는 낮춰라 높여라

맞으면 축하합니다. 끝
 */
import java.util.Scanner;
import java.util.Random;

public class Quiz4_P {

  public static void main(String[] args) {
    // Random하게 채번하는 메소드를 제공하는 클래스 선언 및 생성하기
    Random random = new Random();// new다음에 오는 이름의 객체가 로딩-> 생성자 호출도 일어남
    // 스캐너 클래스를 사용하면 입력장치로 입력된 정보를 받아올수있다.
    // 생성자의 파라미터에 입역 장치에 대한 코드가 필요하다
    // 시스템-내가 사용하는 컴터의 장치
    // 그 뒤에 변수 인을 붙이면 입력 장치를 나타냄

    Scanner scanner = new Scanner(System.in);
    // nextInt메소드는 스캐너 클래스가 소유주이다. 스캐너 클래스 안에있는 애임
    int x = random.nextInt(10);// 0부터 10까지 범위이다 라는 의미
    System.out.println("채번한 숫자는====>" + x);
    int y = -1;
    boolean isOK = true;
    int cnt = 1;
    // 회차를 카운트 해주는 변수 필요하다
    // 언제 카운트를 증가 시킬것인가?-힌트를 줄때 증가시킨다.
    while (isOK) {// 조건문에 변수만 들어가도 된다.
      System.out.println("0부터 9까지 숫자를 하나 입력하세요.");
      // 스캐너 클래스가 소유한 nextInt메소드 호출하기
      // nextInt():int이다
      y = scanner.nextInt();
      System.out.println("사용자가 선택한 값 :" + y);
      // 컴터가 채번한 값x과 사용자가 입력한 값y이 같니?
      if (cnt == 5) {
        System.out.println("5번의 기회를 모두 사용했습니다.");
        System.exit(0);// 파ㅣ라미터에 0을 주면 자바가상머신과의 연결고리 끊긴다.-종료-할당 스레드 반환이됨
      }
      if (x == y) {// 맞다- 변수가 가리키는 값이 같은지를 비교하는 것임. 원시형 변수이다.직접접근 방식이다.
        System.out.println("축하합니다.");
        scanner.close();// 사용한 주소번지는 반드시 닫아준다. 위변조 막기위해서. 스캐너 쓰고 해킹 안당하기 위해 닫는다.
        break;
      } else if (x > y) {// 컴터가 채번한 숫자보다 크니?
        System.out.println("올리세요.");
      } else if (x < y) {
        System.out.println("내리세요.");
      } else if (y == 10) {
        scanner.close();
        System.exit(0);

      }
    }
  }
}
// 채번한 숫자를 배열에 담아라