package dev_java.assignmentTest;
//while문에 브레이크가 없다

import java.util.Scanner;
//클래스 하나에 기능 하나만...
class Exam2{

  public void sum(){
    Scanner sc=new Scanner(System.in);

    System.out.println("1이상의 숫자를 입력하세요 : ");
    int num=sc.nextInt();
    int sum =0;
    if(num>0){
      int i =1;
      while(i<=num){//1<=2
        sum +=i;
        i++;
      }
      System.out.println("1부터"+num+"까지의 합은 "+sum+"입니다.");
    }else{
      System.out.println("숫자가 1 이상이 아닙니다.");
    }
    
  }

  public void methodA(){
    //while문 사용시 무한루프 방지 코드를 작성 할 것
    //while문 안에 증감연산자 있는지 파악할것.
    System.out.println("methodA호출성공");
    Scanner s =new Scanner(System.in);
    int choice =s.nextInt(); 
    if(choice>2||choice<0){
      System.out.println("1혹은 2 중에서 입력하세요");
      return;
    }

    }
  }



public class Test2_2 {
public static void main(String[] args) {
    Exam2 e2=new Exam2();
    e2.sum();
  }
  
}
