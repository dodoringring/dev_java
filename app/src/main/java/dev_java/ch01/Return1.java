package dev_java.ch01;

public class Return1 {
  void m() {

  }

  int m1() {
    return 2;
  }

  boolean isView() {
    return true;
  }

  boolean isView1() {
    boolean bool = true;
    return bool;

  }

  String getName() {
    String name = "이순신";
    return name;
  }

  int name1() {
    return 10;
  }

  String name2() {
    return "도도희";

  }

  public static void main(String[] args) {
    Return1 r1 = new Return1();

    // int y = r1.m1();

    System.out.println(r1.m1());

    Return1 d1 = new Return1();
    d1.name2();
    

  }
}
