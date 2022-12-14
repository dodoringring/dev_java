package dev_java.ch03.Practice;
/*
 * 연습문제 4
두숫자를 입력 받아 둘 사이의 3의 배수 갯수를 카운트 하는 프로그램을 작성하시오.
예) 3, 13 두 숫자를 입력하였다면 3개 출력해 줌
 */


public class Quiz4 {
  int cnt;//0 전변이 바뀐다. 원본이 바뀐다.
  int account(int start, int end){ //start=3, end=13
    for(int i=start; i<=end; i++){
      // for(int i=start; i<=end; i=i+3){//3,4,5,6,7
        cnt++;
    }if (i%3==0){
      cnt++;
    }
    return cnt;
  }
  public static void main(String[] args) {
    Quiz4 q4=new Quiz4();
    q4.account(3,13);
    System.out.println(q4.cnt);
    
  }
  
}
