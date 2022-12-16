package dev_java.Homework.quiz1215;
/*
 * *연습문제 2*
- 10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
출력)
배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
음수합 : -24
양수합 : 17

변수 몇개? 2개 mhap, phap
전변은 무엇? 배열 nansus[]
합계 - total
난수 채번 제대로 됐는지 체크하기


 */

public class Practice2 {
  int nansus[]=new int[10];
  int mhap=0;
  int phap=0;
  int user[]=new int[10];

  void setArray(){
    for(int i=0;i<user.length;i++){
    user[i]=(int)(Math.random()*21)%21-10;
    }//reandom은 0.0~1.0미만

  }

  void setArryInt(int size){
    for(int i=0;i<size;i++){
      user[i]=(int)(Math.random()*21)%21-10;
      }

  }

  void total1(){
    System.out.println("난수들의 합 : ");
    for(int i=0;i<user.length;i++){
      mhap=mhap+user[i];
      }
      System.out.println(mhap);
  }

  void total(int user[]){
    for(int i=0;i<user.length;i++){
      if(user[i]<0){
        mhap=mhap+user[i];
      }else if(user[i]>0){
        phap=phap+user[i];
      }
    }//for끝
    System.out.println("\n");
    System.out.println("음수합"+mhap);
    System.out.println("양수합"+phap);
  }

  void nansuPrint(){
    for(int i=0; i<user.length;i++){
    System.out.print(user[i]+" ");
    }

  }

  public static void main(String[] args) {
     Practice2 p2=new  Practice2();
     p2.setArray();
     p2.nansuPrint();
     p2.total(p2.user);
  }
}
