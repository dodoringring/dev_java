package dev_java.Homework;

public class gugudan {
  public static void main(String[] args) {
    int i = 2;// 단수

    for (; i < 10; i++) {
      int j = 1;// j의 초기화를 안에서 해줘야한다.
      for (; j < 10; j++) {

        System.out.println(i * j);

      }

    }

  }
}
