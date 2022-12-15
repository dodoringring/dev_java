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



  public int[] MethodB(){ //이래도 되나요?
    int[]arr=new int[5];
    for(int i=0; i<arr.length; i++){
    System.out.println("숫자를 넣어주세요");
    arr[i]=s.nextInt();
    System.out.println("입력값은 ="+arr[i]);
    }
    System.out.println(Arrays.toString(arr));
    return arr;
  }

  public int hap(int[] arr){//파라미터는 메세지를 전달
    
    int hap=0;//지역변수는 반드시 초기화를 해줘야한다.
    for(int i=0; i<5;i++){
      hap=arr[i]+hap;
    }
    return hap;
  }

  public void avg(int hap){
    double avg=0;
    for(int i=0; i<5; i++){
      avg=hap/5;
    }
    System.out.println(avg);
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
    // p.MethodB();

    int hap=p.hap(p.MethodB());//////질문하기!!hap의 파라미터 자리에 arr라는 메소드비의 배열을 넣고싶다.
    //합을 호출했는데 어째서 메소드비도 호출이 된건지 궁금
    System.out.println("총점은"+hap);
    p.avg(hap);
  }
}
  

