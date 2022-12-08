package dev_java.Homework;
/*
 * 야구게임
 * 입력받는 값은 0~9사이의 숫자여야한다
 * 답을 맞추면 새게임 가능하다-초기화 실전연습
 * 답을 맞추지 못했을경우 답을 볼 수 있도록 한다.
 */

public class HW06 {//2년차 미만은 static쓰지마라. 전역변수로 해서 메소드로 끄집어내라
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
//  초기화는 전변?지변? 선택 할 수 있는 기준이 있나요? 지변이다. 초기화가 될때마다 숫자 바뀌어야하므로
//   //자리가 같다는 것을 배열의index를 활용하시오.
//  파라미터에는 유저가 입력한 값이 들어오도록.
// * 반환값은 ex."1스 2볼"
// * 숫자가 존재하고 자리까지 일치하면 스트라이크
// * 숫자가 존재하나 자리가 다르면 볼
  public String account(String user_input){ //힌트 temp=Integer.parseInt()
    //my[0]=256/100;2.56
    //my[1]=256%100-->56/10=5.6--->5를 초기화
    //my[2]=256%10;
    //스트링이라도 이중 for문 통해서 백의자리 십의자리 일의자리 추출할수있다.
    //insert here! 12/06 숙제
    int my[]=new int[3];
    my[0]=2;
    my[1]=5;
    my[2]=0;

    return "스 볼";
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
