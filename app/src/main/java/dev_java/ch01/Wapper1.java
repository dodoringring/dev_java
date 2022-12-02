package dev_java.ch01;

public class Wapper1 {

  public static void main(String[] args) {
    Integer i = new Integer(10); //줄 그인 이유? 자바 가상머신 11을 쓰기때문에(내가) 지원 안할수도 있으니까 조심해라는 의미
    int j=i;
    System.out.println(i);
    System.out.println(j);
    String x = String.valueOf(j);

    String y=x;
    System.out.println(x);

    if(y instanceof String){
      System.out.println("y는 String타입입니다.");
    }
    if(i instanceof Integer){
      System.out.println("i는 Integer타입입니다.");
      
    }
  }
  
}
