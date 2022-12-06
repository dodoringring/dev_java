package dev_java.ch02;
/*카드가 3,3,5,5 이렇게 4장이 있는데 셔플시키는 프로그램 만들고 싶다.

변수는 몇개 필요한가?

자리는 4개
*/

public class Shuffle {
  public static void main(String[] args) {
    int a = 3;
    int b = 5;

    int imsi = 0;
    imsi = a;
    a = b;
    b = imsi;
    System.out.println("a :" + a + " ,b :" + b);
  }

}
