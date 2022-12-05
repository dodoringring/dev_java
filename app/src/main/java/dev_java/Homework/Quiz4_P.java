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
    int y = -1;
    while (true) {
      int y = scanner.nextInt(10);

    }
  }
}
