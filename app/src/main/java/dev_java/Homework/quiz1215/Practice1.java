package dev_java.Homework.quiz1215;
/*
 * 연습문제1

*키보드로 부터 5개의 정수를 입력 받아서 배열에 저장하세요.*

*그리고 이들의 합계와 평균을 출력하는 프로그램을 작성하시오.*
 */

import java.util.Arrays;
import java.util.Scanner;

public class Practice1 {
  Scanner s = new Scanner(System.in);



  public void MethodB(){
    int[]arr=new int[5];
    for(int i=0; i<arr.length; i++){
    System.out.println("숫자를 넣어주세요");
    arr[i]=s.nextInt();
    System.out.println("입력값은 ="+arr[i]);
    }
    System.out.println(Arrays.toString(arr));
  }

  public void hap(int[] arr){
    
    int hap=0;
    for(int i=0; i<5;i++){
      haparr[i]
    }
  }

  public void avg(){
  
  }






  
  
  // public void methodA(int user){

  //   int[]arr=new int[5];
  //   System.out.println("숫자를 넣어주세요");
  //   Scanner s=new Scanner(System.in);
    
  //   for(int i=0;i<arr.length;i++){
  //     arr[i]=s.nextInt();
      
  //     System.out.println(arr[i]);
  //   }
    
  // }
  
    public static void main(String[] args) {
      
    
    Practice1 p = new Practice1();
    p.MethodB();

  }
}
  

