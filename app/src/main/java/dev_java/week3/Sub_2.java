package dev_java.view.week3;

public class Sub_2 {

  public static void main(String[] args) {
    Main_2 m1 = new Main_2(); //전역변수이지만 null이잖아... 
    System.out.println(m1.isOk);//주소값이 찍힌다
    // m1.isOk; 배열은 이렇게 안됨
    for(int i=0;i<m1.isOk.length;i++){//0,1,2까지 null이잖아? 길이 못구해... 그래서 생성자 필요
      System.out.println(m1.isOk[i]);
    }
    System.out.println("===================");
    for(boolean isOk : m1.isOk){//개선된 for문 for문에서 isOk변수를 설정하고 배열이 끝날때 까지 돌리기
      System.out.println(isOk);
    }
  }
}
