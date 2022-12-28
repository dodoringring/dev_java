package dev_java.week5;
								
class StopThread implements Runnable {								
	boolean stopped = false;							
								
								
	@Override							
	public void run() {							
		while(!stopped) {//true						
			System.out.println("Thread is alive....");	//출력			
			try {					
				Thread.sleep(500);//0.5초 또 출력-Thread is alive가				
			} catch (InterruptedException e) {					
				e.printStackTrace();				
			}					
		}	
		//아래코드는 9번과 16번 구간중 12번에서 멈춰있을때 다른 스레드가 인터셉트 가능하다-다른스레드가 있으면				
		System.out.println("Thread is deaded");						
	}							
	public void stop() {							
		stopped = true;						
	}							
}								
								
													
public class StopThreadTest {			
// 29(메인스레드)-31(메소드호출)-34(객체생성)-35(스레드객체생성-파라미터36번주번넘김)
	// 38-8(run콜백호출)[스레드대기자방에서 우선순위따짐-자기순서이면 실행시작]-19번 사이에 인터셉트. 18번이 출력.
	public static void main(String[] args) {							
		StopThreadTest stt = new StopThreadTest();						
		stt.process();		
		System.out.println("main end");//어플리케이션(앱)죽는다-메인스레드 회수-JVM				
	}							
	public void process() {							
		StopThread st = new StopThread();//지변으로 객체생성-오토메틱이다. 이영역안에서만 살고 죽음					
		Thread th = new Thread(st);//스레드 생성(객체파라미터)
		th.start();						
		try {						
			Thread.sleep(1000);					
		} catch (InterruptedException e) {						
			e.printStackTrace();					
		}						
		st.stop();						
	}							
}								
								