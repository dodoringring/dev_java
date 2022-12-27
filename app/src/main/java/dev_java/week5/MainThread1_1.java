package dev_java.week5;							
									
/*									
 * main메소드 호출은 JVM에 의해 호출된다. 									
 * JVM은 main스레드를 생성하여 main메소드를 호출한 것이다.									
 * 따라서 프로그램을 실행할 때 main메소드가 실행되었다는 것은 main스레드가 									
 * 수행되는 것이다.									
 * 그리고 main안에서 사용자가 만든 새로운 스레드를 실행시켰다면 									
 * 두 개의 스레드(main 스레드와 사용자 스레드)가 작동하고 있다는 것을 의미한다.									
 * 									
 * 아래 결과는 예측 불허(실행할 때마다 다를 수 있다.)									
 * 									
 */									
public class MainThread1_1 {//나는 스레드 클래스가 아님	
  //단 메인스레드는 갖고있음
  //작동 순서 : 18-19-20(main start)-21(인스턴스화. 아직 런 호출 안됨)		-24(implements라서 필요함 상속이면 필요 없음)	
  //27(start()->run() : 즉시 실행되지안고 대기실에서 순서를 따짐)	-54	-58first-63second			
	public static void main(String[] args) {								
		System.out.println("====================================");							
        System.out.println("main start");        									
        Runnable r = new MyRunnableOne();//인터페이스=구현체클래스(override:run-추상메소드)-다형성							
        //코드를 조금만 수정(오래전에 코딩, 오타 등등..)하고 유지보수가 가능하니까
        //많이 손대면 손댈수록 의존관계로인해 다른 에러를 유발시킴
        Thread myThread = new Thread(r);									
        //스레드가 아니어서 에러이고 둘째 static 안에서는 this나 super를 쓰면 안된다.
        // Thread myThread = new Thread(this);		망함 안됨. 							
        myThread.start();//디폴트 가중치는 5이다.????	
        try {
          myThread.sleep(5000);	//try-catch에 반드시 들어가있어야
          //스레드가 제공하고 있다.-스레드 구현함-양보, 고집,차레대로 스케줄링          
        } catch (Exception e) {
          // TODO: handle exception
        }

        // Thread himThread =new MyRunnableTwo();//나자신이 스레드일떼 start호출하는 방법과 아닐 때 방법
        // himThread.start();//디폴트 가중치는 5이다.-절대적이지 않다.
        //상속으로 처리하든 인터페이스로 처리하든 동등하다. 우선순위 없다.
        //누구든 먼저 선점하는 스레드가 우선권을 갖는다.
		System.out.println("main end");							
	}								
									
}		
//Thread가 되는 방법에는 두가지가 있다.
//1.상속
//2.implements
//공통점 - 둘다 run메소드를 가질 수 있다.(재정의 할 수 있다.)-그 안에서 실행문을 처리 하면 안전함							
class MyRunnableTwo extends Thread{//스레드 상속
  @Override
  public void run(){
    System.out.println("MyRunnableTwo run호출");
  }
}								
class MyRunnableOne implements Runnable{		//임플리먼츠							
    public void run(){									
        System.out.println("run메소드 호출 성공");									
        first();									
    }									
    public void first(){									
        System.out.println("first메소드 호출 성공");									
        second();									
    }									
    public void second(){									
        System.out.println("second메소드 호출 성공");									
        System.out.println("====================================");									
    }									
}									
/*
 * 클래스를 상속 받으면 클래스간의 결합도가 높아진다.->재사용성이 떨어진다(오작동경험)
 * 기능적인 부분을 결합도를 낮추면서 테스트도 용이한 그러면서 오작동도 방지되는 방법
 * 인터페이스 중심의 코딩을 전개하는 방법-오버라이딩 필수다.
 * 
 */