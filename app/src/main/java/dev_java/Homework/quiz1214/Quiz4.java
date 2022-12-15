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

public class Quiz4 {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner s = new Scanner(System.in);
    int com = r.nextInt(10);// 0.0~10.0
    System.out.println("채번한 숫자는" + com);
    int my = -1;//그냥 구별 위한 0~9가 아닌 숫자
    while (true) {
      System.out.println("0부터 9사이의 정수를 입력하세요.");
      my = s.nextInt();
      System.out.println("사용자가 입력한 값" + my);
      if (com == my) {
        System.out.println("축하합니다.");
        break;
      } else if (com > my) {// 컴터가 채번한 숫자가 사용자가 입력한 값보다 크니?
        System.out.println("높여라");
      } else if (com < my) {
        System.out.println("낮춰라");
      } else if (my == 10) {
        System.exit(0);
      }

    }

  }
}
