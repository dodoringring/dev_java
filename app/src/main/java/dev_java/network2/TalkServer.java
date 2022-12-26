package dev_java.network2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//자바는 단일 상속만 가능하다
//선언과 생성을 분리하는 코딩전개
//자바는 단일 상속의 단점을 보완하기 위해서 인터페이스는 다중으로 처리 가능함(구현체 클래스)

public class TalkServer extends JFrame implements Runnable, ActionListener{//경합이 벌어져서 러너블을 넣은거다. 
  //선언부
  //클라이언트측에서 뉴소켓하면 그 소켓정보를 받아서 스레드로 넘김
  TalkServerThread 		tst 		= null;
 
  //동시에 여러명이 접속하니까List-Vector<>();멀티스레드 안전, 속도 느림
	List<TalkServerThread> 	globalList 	= null;
	ServerSocket 			server 		= null;
	Socket 					socket 		= null;
	JTextArea 				jta_log = new JTextArea(10,30);
	JScrollPane 			jsp_log = new JScrollPane(jta_log,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JButton jbtn_log = new JButton("로그저장");
	String logPath = "src\\athread\\talk1\\";
  
  //화면그리기
	public void initDisplay() {//화면을 먼저 호출해라
		jbtn_log.addActionListener(this);
		this.add("North",jbtn_log);
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	//서버소켓과 클라이언트측 소켓을 연결하기
	@Override
	public void run() {
		//서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기 
		globalList = new Vector<>();//멀티 스레드가 안전해서 ArrayList(싱글스레드 안전)대신 사용함
		boolean isStop = false;
		try {
			server = new ServerSocket(7891);//서버포트 번호 설정하기
			jta_log.append("Server Ready.........\n");//대기 탐-멈춤-wait
			while(!isStop) {
				socket = server.accept();
				jta_log.append("client info:"+socket+"\n");				
				jta_log.append("client info:"+socket.getInetAddress()+"\n");				
				TalkServerThread tst = new TalkServerThread(this);
				tst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

  //생성자
  public TalkServer(){
    //initDisplay();//망한다. 화면을 먼저 호출해라. 시점의 문제가 발생한다. 스케줄링의 해야된다.
  }
 
  public static void main(String[] args) {
    //메인 메소드 자체도 메인 스레드이다. 엔트리 포인트이다. 우선순위가 있다.
    TalkServer ts= new TalkServer();
    ts.initDisplay();//여기서 호출
    Thread th=new Thread(ts);
    th.start();//밑에 오버라이드 호출된-지연발생함-클라이언트가 접속할때까지 대기함
  }
  //서버소켓과 클라이언트 소켓을 연결
  @Override
  public void actionPerformed(ActionEvent e) {
    //로그를 파일로 저장하기
  }
  
}
