package dev_java.Homework;

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
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    int x = random.nextInt(10);// 0부터 10까지 범위이다 라는 의미
    System.out.println("채번한 숫자는====>" + x);
    int y = -1;
    while (true) {
      System.out.println("0부터 9까지 숫자를 하나 입력하세요.");
      y = scanner.nextInt();
      System.out.println("사용자가 선택한 값 :" + y);
      if (x == y) {// 맞다
        System.out.println("축하합니다.");
        scanner.close();// 스캐너 쓰고 해킹 안당하기 위해 닫는다.
        break;
      } else if (x > y) {
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
