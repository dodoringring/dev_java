package dev_java.ch01;

public class String1 {

  public static void main(String[] args) {
    String s1 = "안녕";
    String s2 = "안녕";
    //주소번지가 가리키는 값을 비교하려면 equals라는 메소드를 찾아볼것
    String s3 = new String("안녕");
    String s4 = new String("안녕");

    /*s1와 s2의 주소번지는 같나? 참OR거짓
    그리고 이유에 대해 설명하시오
    s3,s4의 주소번지가 같니?
    만일 s3이 가리키는 문자열이 s4와 같은지를 비교하려면 어떡하지? 구글링해봐
     * 
     */
    System.out.println(s1==s2);
    System.out.println(s3==s4);
  }
  
}
