package dev_java.ch03.Practice;

public class RectAngle {
  //변수선언2개 - 가로길이, 세로길이
  //변수선언 1개 - 면적 구하기

  public static void main(String[] args) {
    int i=2;//가로
  int j =3;//세로
  int area=0;
  area=i*j;
    System.out.println("직사각형의 면적은?"+ area);
  }
  
}
/*
 * 1-1
 * 메인안에서 처리하기
 * 
 * 문제제기
 * 
 * 원의 면적도 구하고싶다면?
 * 삼각형의 면적도 구하고 싶다
 * 사각형도 구해야하면?
 * 
 * 이걸 모두 할 수있도록 3에서 만들어달라.
 * 
 */
