package dev_java.assignmentTest;

public class Test1_2 {
  int i=1;
  public void Bbb(){
  while(i<=20){
    if(i%5==0){
      System.out.println(i + ": 5의 배수입니다.");
    }else {
      System.out.println(i + ": 5의 배수가 아닙니다.");
    }
    i++;
    }
  }

public void Bbb(){
    for(int i=1;i<=20;i++){
      switch(i%5){
        case 0 :
        System.out.println(i + ": 5의 배수입니다.");
        break;

        default :
        System.out.println(i + ": 5의 배수가 아닙니다.");
      }
    }
  } 


  public static void main(String[] args) {
    Test1_2 t2 = new Test1_2();
    // t2.Aaa();
    t2.Bbb();
  }
  
}
