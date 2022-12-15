package dev_java.Homework.quiz1215;
/*
 * 연습문제1

*키보드로 부터 5개의 정수를 입력 받아서 배열에 저장하세요.*

*그리고 이들의 합계와 평균을 출력하는 프로그램을 작성하시오.*
 */

import java.util.Arrays;
import java.util.Scanner;

public class Practice1_dap {
  int users[]=new int[5];

  void average(int hap){//파라미터는 메세지를 전달하는 자리이다.
    double avg=0;
    avg=hap/(double)users.length;//강제 형전환
    System.out.println("평균은 :"+avg);
  }

  int total(){
    int hap=0;//지역변수는 무조건 초기화 해줘야된다. 자동으로 되지 않는다 이 안에서만 유지가 된다.
    for(int i=0; i<users.length;i++){
      hap+=users[i];
    }
    return hap;
  }
  
  void initUsers(){
  Scanner s = new Scanner(System.in);

  for(int i=0;i<users.length;i++){
    System.out.print("정수를 입력하세요");
    users[i]=s.nextInt();
    System.out.println(users[i]);
  }
  s.close();
}
  
    public static void main(String[] args) {
    
    
    Practice1_dap p = new Practice1_dap();
    p.initUsers();
    int hap=p.total();
    System.out.println("총점은"+hap+"입니다.");
    p.average(hap);

  }
}
  

