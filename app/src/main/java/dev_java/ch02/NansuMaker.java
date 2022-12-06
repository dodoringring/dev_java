package dev_java.ch02;
//문제! 난수 발생하여 3자리의 서로 다른 숫자로 된 값을 배열에 담기
public class NansuMaker {//2년차 미만은 static쓰지마라. 전역변수로 해서 메소드로 끄집어내라
  //전역변수로 해서 메인에서 불러올수있다.
  int com[]=new int[3];//컴터가 채번한 숫자이다. 배열의 선언 및 생성
  int my[]=new int[3];//사용자가 선택한 숫자 
  
  
  public void ranCom(){
    com[0]=(int)(Math.random()*10);//첫번째는 그냥 채번 간다. 같은 숫자가 있을리 없다.
    do{//조건 먼저 따지지 않고 먼저 채번 그다음 비교
      com[1]=(int)(Math.random()*10);//두번째 자리가 컴터 숫자랑 같니?
    }while(com[0]==com[1]);//같으면 다시 반복해라
    //insert here
    do{
      com[2]=(int)(Math.random()*10);
    }while(com[1]==com[2]||com[0]==com[2]);
    // System.out.println(com[0]);
    // System.out.println(com[1]);
    // System.out.println(com[2]);

  }
  //초기화는 전변?지변? 선택 할 수 있는 기준이 있나요?
  //자리가 같다는 것을 배열의index를 활용하시오.
  public String account(String user_input){
    //insert here! 12/06 숙제
    return "1스 2볼";
  }
  public static void main(String[] args) {
    NansuMaker nansu = new NansuMaker();
    // nansu.ranCom(); 이자리에 인스턴스 가져오면 for문에서 돌지 않는다.
    for(int i =0; i<=10; i++){ //for문 초기화,
      nansu.ranCom();
      System.out.println(nansu.com[0]+","+nansu.com[1]+","+nansu.com[2]);//내가만든 난수 인스턴스에서 전역변수 com을 불러와
    }

    
  }
  
}
