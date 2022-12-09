package dev_java.assignmentTest;

import java.util.Scanner;

public class Test1_1 {

  public void count(){
    Scanner sc = new Scanner(System.in);

    while(true){
      System.out.println("문자열을 입력해주세요 : ");
      String str = sc.nextLine();
      if(str.equals("exit")){
        break;
      }else {
        System.out.println(str.length() + "글자입니다.");
      }
    }
    System.out.println("프로그램을 종료합니다.");


  }
  public static void main(String[] args) {
    Test1_1 t = new Test1_1();
    t.count();

    String s1=new String("안녕");
    String s2=new String("안녕");
    String s3 ="안녕";
    String s4 = "안녕";
    if(s1==s2){
      System.out.println("주소번지가 같니?");
    }
    if(s1.equals(s2)){
      System.out.println("주소번지가 같니?");
    }
    if(s3==s4){
      System.out.println("주소번지가 같니?");
    }
    if(s3.equals(s4)){
      System.out.println("주소번지가 같니?");
    }

  }
}
