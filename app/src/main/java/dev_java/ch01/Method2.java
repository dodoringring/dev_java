package dev_java.ch01;

public class Method2 {
double m1(double d){
  return 3.5;//상수를 반환 했으니까 365일 3.5만 반환됨
  //void와는 출력타입이 다르다.리턴 타입이 있을때는 반환되지만 없으면 파라미터 안에 넣어줌
}
  public static void main(String[] args) {
    Method2 method2 = new Method2();
    //메소드 내부에 출력하는 문장이 없는 경우 외부의 메소드에서 
    //그 메소드에서 결정된 값을 출력 하려면 반환형이 필요하다.
    double result = method2.m1(1.5); //선언과 초기화를 한번에 함
    System.out.println(result);
  }
  
}
