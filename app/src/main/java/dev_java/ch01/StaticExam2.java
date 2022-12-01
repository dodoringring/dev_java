package dev_java.ch01;

public class StaticExam2 {

  public static void main(String[] args) {
    StaticExam1 staticExam1 = new StaticExam1();
    StaticExam1 staticExam2 = new StaticExam1();
    StaticExam1 staticExam3 = new StaticExam1();
    staticExam1.methodA();
    // 인스턴스화 된 객체?는 Heap에 저장된다. 클래스랑 같이 같은 파일에 없더라도 다른 파일에 있어도 불러올수있다.
    staticExam1.methodA();
    staticExam2.i = 5;
    staticExam3.i = 3;
    // i전역변수니까 가능
    System.out.println(staticExam1.i);
    System.out.println(staticExam2.i);
    System.out.println(staticExam3.i);
  }

}
