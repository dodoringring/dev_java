package dev_java.network3;

public abstract class Mycar {
  private int WheelNum=0;

  public Mycar(){
    System.out.println("Mycar()디폴트 호출");
  }

  public abstract void display();
  
  public void go(){
    System.out.println("나는 앞으로 간다.");
  } 
  public Mycar(int WheelNum){
    System.out.println("Mycar호출");
    this.WheelNum=WheelNum;//지역변수가 전역변수를 결정짓는다. 
  }

}

