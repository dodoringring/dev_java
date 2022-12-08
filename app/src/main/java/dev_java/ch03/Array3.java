package dev_java.ch03;

public class Array3 {
  public static void main(String[] args) {


    int i[]={1,2,3};
    int j[];
    j=i;
    int k[];
    k=new int[3];//새롭게 생성
    //insert here
    j=k;//왜 에러인가? 에러가 발생하지 않도록 11번 라인에 코드를 추가하라.
    


    String s1="안녕";
    String s2=s1;
    System.out.println(s1.length());//문자의 길이를 알려주는 Length

  }
  
}
