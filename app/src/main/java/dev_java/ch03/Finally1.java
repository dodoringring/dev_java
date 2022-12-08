package dev_java.ch03;
//java예외처리
//java finally사용법
public class Finally1 {

  public static void main(String[] args) {
    int i = 10;
    int j = 2;
    j=0;
    j=5;
    try{
      System.out.println(i/j);//5
    }catch(ArithmeticException a){
      System.out.println(a.getMessage());
    }finally{
      System.out.println("Finally는 무조건 실행이 된다.");
    }

  }
  
}
