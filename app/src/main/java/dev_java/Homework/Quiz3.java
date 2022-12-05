package dev_java.Homework;
/*문제 3

1부터 100까지 세면서 5의 배수이면 fizz를 출력하고

7의 배수이면 buzz를 출력하고

5와 7의 공배수이면 fizzbuzz를 출력하고

나머지는 숫자를 출력하는 프로그램을 작성하시오. 순서가 중요하다. 35는 fizz만 출력될수도 fizzbuzz 먼저 if문 쓰기
조건이 4가지이다. 
*/

public class Quiz3 {

  void methodA() {
    System.out.println("===============[[methodA호출]]==============");
    for (int i = 1; i < 101; i++) {
      switch (i % 35) {
        case 0:
          System.out.println("fizzbuzz");
        case 5:
        case 10:
        case 15:
        case 20:
        case 25:
        case 30:
          System.out.println("fizz");
          break;
        case 7:
        case 14:
        case 21:
        case 28:
          System.out.println("buzz");

        default:
          System.out.println(i);
      }/////// end of switch

    } ////// end of for
  }////// end of methodA

  public static void main(String[] args) {
    Quiz3 aaa = new Quiz3();
    aaa.methodA();

    // for(int i=1;i<101;i++){
    // // System.out.println(i);

    // if(i%35==0){
    // System.out.println("fizzbuzz");
    // }
    // else if(i%5==0){
    // System.out.println("fizz");
    // }else if(i%7==0){
    // System.out.println("buzz");
    // }else{
    // System.out.println(i);
    // }

    // }

  }
}
