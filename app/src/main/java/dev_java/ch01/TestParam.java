package dev_java.ch01;

class Param {
  int ival;///0->100->500
}

public class TestParam {
  void effectParam(Param p) {//p는 @abcd1234 복사한거
    // insert here - 여기에 p = new Param()이 있으면 결과가 달라진다 아니다 같다?????
    // p = new Param();//p의 주소번지는 @abcd1235(다른주소)로 바뀐다. 17번의 p가 아니다.
    p.ival = 500;
    System.out.println("sub ival ===> " + p.ival);
  }

  public static void main(String[] args) {
    TestParam tp = new TestParam();
    Param p = new Param();
    p.ival=100;
    tp.effectParam(p);// 주소번지@abcd1234를 넘긴다
    System.out.println("main ival ===> " + p.ival);
  }
}