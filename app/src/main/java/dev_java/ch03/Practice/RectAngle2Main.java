package dev_java.ch03.Practice;

class RectAngle2{//둘다 퍼블릭일수는 없다. 퍼블릭이 없으면 friendly이다. 같은 패키지않에서는 공유. 임포트는 안된다.


  void area(int w,int h){
    int area=w*h;
    System.out.println("면적은" + area);
  }

  long area(long w, int h){ //타입 맞춰줘야 한다. 작은 타입을 큰타입에 넣는것은 언제나 합법. 자동 형전환. 반대는 강제 형전환
    // int result=w*h;
    // return result;
    return w*h;//이것도 가능
  }
}

public class RectAngle2Main {

  public static void main(String[] args) {
    RectAngle2 r2=new RectAngle2();
    r2.area(2,3);//값에 의한 호출. call by value
    System.out.println("면적은" + r2.area(2L,3));//int우선이라서 long값을 넣어줘야된다.
    

  }
  
}
