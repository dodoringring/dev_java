package dev_java.Homework.quiz1215;
/*
 * *연습문제 2*
- 10에서 10사이의 정수 10개를 랜덤하게 채번하여 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
출력)
배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
음수합 : -24
양수합 : 17

 */

public class Practice2 {
  
  public static void main(String[] args) {
    int user[]=new int[10];
    for(int i=0;i<user.length;i++){
    user[i]=(int)(Math.random()*21)%21-10;
    }//reandom은 0.0~1.0미만
    System.out.println(user[]);
  }
}
