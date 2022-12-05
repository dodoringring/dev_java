package dev_java.ch02;

public class P21_2 {

  public static void main(String[] args) {
    int i =1;
    int j =2;
    // if((i==--j)&(++i<=j)){}
    if((i==--j)&&(++i<=j)){ //j=1 i=2 &&는 앞이 참이면 뒤도 따진다
      System.out.println("조건을 만족했을 때");
      //INSERT HERE -i와j의 값을 확인할 수 있다 없다?

    }
    else{
      System.out.println("조건을 만족하지 않았을 때");
    }
    //insert here -->i는 얼마?j는 얼마?
    System.out.println("i="+i+", j="+j);
  }
  
}
