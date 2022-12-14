package dev_java.ch03.Practice;
//배열쓰기

class RectAngle3{

  void rectangle(int params[]){
    params[2]=params[0]*params[1];
    System.out.println(params[2]);
  }

  void circle(int params[]){
    final double pi=3.14;
    double area=params[0]*params[1]*pi;
    System.out.println(area);


  }


  void triangle(int params[]){
    params[2]=params[0]*params[1]/2;
    System.out.println(params[2]);
  }

}

public class RectAngle3Main {

  public static void main(String[] args) {
    RectAngle3 r3=new RectAngle3();
    int arr[]={2,3,0};
    r3.rectangle(arr);
    r3.circle(arr);
    r3.triangle(arr);

  }
  
}
