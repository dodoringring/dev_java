package dev_java.Homework;


public class Quiz2_1 {
  //문제 2
// 1부터 10까지 세면서 짝수의 합을 구하는 프로그램을 작성하시오. 
  public static void main(String[] args) {
   int i =1;
   int sum=0;
  //  for(;i<=10;i++){
    while(i<=10){ //while 문으로 바꾸기
    
    if(i%2==0){
      sum = i+sum;
      }
      i++;// 나머지를 확인을 하고 증가시킨다. 순서 중요!
   }
   System.out.println(sum);
  }
  
}


