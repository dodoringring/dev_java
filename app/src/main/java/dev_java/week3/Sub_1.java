package dev_java.view.week3;

public class Sub_1 {

  public static void main(String[] args) {
    Mian_1 m1 = new Mian_1();
    System.out.println(m1.isOk);//주소값이 찍힌다
    // m1.isOk; 배열은 이렇게 안됨
    for(int i=0;i<m1.isOk.length;i++){
      System.out.println(m1.isOk[i]);
    }
    System.out.println("===================");
    for(boolean isOk : m1.isOk){//개선된 for문
      System.out.println(isOk);
    }
  }
}
