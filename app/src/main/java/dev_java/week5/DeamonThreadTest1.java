package dev_java.week5;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
											
/*												
 * 상황에 따라 분리된 스레드로 백그라운드 작업을 해야 하는 경우도 있다.												
 * JVM안의 가비지 컬렉션과 같은 작업이 대표적이다.												
 * 이런 백그라운드 작업이 일반 스레드로 설정되어 있다면 전원이 종료되거나 사용자가 강제 종료하지 않는 한												
 * 애플리케이션은 영원히 정지 하지 않을 것이다.												
 * 												
 */												
//DeamonThreadTest.java->DeamonThreadTest.class, DeamonThreadTest$1.class(익명클래스)
//Node.js, ES5,6,7 arrow function,람다식. 최신문법
public class DeamonThreadTest1 {												
	JButton jbtn=new JButton("전송");
	public DeamonThreadTest1(){
		jbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				System.out.println("전송 버튼 클릭");
			}//end of ActionPerformed
		});
	}
	public static void main(String[] args) {											
		Thread th = new Thread() {										
			public void run() {	//Override오버라이드 추상메소드를 직접 정의					
				try {								
					Thread.sleep(5000);//5동안 정지상태. 멈춰만 있는거다. 죽지않았다.				
					System.out.println("MyThread 종료");							
				} catch (InterruptedException e) {								
												
				}								
			}									
		};										
		//데몬 스레드로 설정함.										
		//아래와 같이 데몬스레드를 설정하면 내부의 모든 스레드가 종료되지 않아도 어플리케이션이 종료된다.		
		//setDeamon을 사용하여 옵션을 true로 주면 스레드와 상관없이 앱을 강제 종료시킨다.
		//프로그램 처리하는것과 상관없이 별개로 동작해야하는것들이 있다면 
		//이메소드를 호출하지 말거나 추가했다면 false로 설정할것								
		th.setDaemon(false);//false로 하면 MyThread 종료가 출력된다. 이문장이 없으면 false와 결과같음.										
		th.start();										
		System.out.println("main() 종료");										
	}///////////////end of main			

	
}												