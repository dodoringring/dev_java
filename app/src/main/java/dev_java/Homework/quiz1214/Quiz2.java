package dev_java.Homework.quiz1214;

import java.util.Scanner;

public class Quiz2 {
  //문제 2
// 1부터 10까지 세면서 짝수의 합을 구하는 프로그램을 작성하시오. 
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("구하고자 하는 합의 두번째 숫자를 입력하세요.");
    
    int user_end=s.nextInt();//Scanner는 사용자가 입력하는 값을 읽어들이는애/nextInt:숫자만넣을수있는

    int tot =0;//합을 넣은 변수 지변이니까 초기화를 해야됨
    int cnt=1;
    //for(초기화; 조건식; 증감연산자)
    for (; cnt <= user_end; cnt = cnt + 1) { 
      //너 짝수니?
      if(cnt%2==1){
        tot=tot+cnt; //1
      }
      System.out.println("tot:" + tot + ",cnt:" + cnt);
    }
    System.out.printf("tot:%d, cnt:%d%n", tot, cnt);
  }
  
}
