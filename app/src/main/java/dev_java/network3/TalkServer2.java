package dev_java.network3;

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

//선언과 생성을 분리하는 코딩 전개
//자바는 단일상속만 가능함
//자바는 단일상속의 단점을 보완하기 위해 인터페이스는 다중으로 처리가능함(구현체클래스)
//상속을 받거나 implements하면 부모클래스나 인터페이스가 정의하고있는 메소드를 재정의=오버라이딩 할 수 있다.
//Overriding - 선언부는 완전 일치해야함
//인터페이스는 오로지 추상메소드만 갖는다. Runnable도 인터페이스이니까 추상메소드 있다.
//그게 run메소드이다.
//POJO F/W설계-인터페이스 중심의 코딩 전개 수업-Spring Boot(전자정부프레팀웤)기반 MVC패턴 수업진행
//자바스크립트 수업(ES5,6,7소개)-NodeJS
//리액트수업진행계획(객체, 클래스수업,리액트훅,메소드,파라미터,리턴타입)

public class TalkServer2 extends JFrame implements /*Runnable */ ActionListener {
  // 선언부
  // 클라이언트측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘김
  TalkServerThread2 tst = null;
  // 동시에 여러명이 접속하니까 List - Vector<>(); 멀티스레드 안전, 속도 느림
  List<TalkServerThread2> globalList = null;
  ServerSocket server = null;
  Socket socket = null;
  JTextArea jta_log = new JTextArea(10, 30);
  JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JButton jbtn_log = new JButton("로그저장");

  // 생성자-클래스이름이 다르면 생성자 이름도 변경해줌
  public TalkServer2() {
    // initDisplay();//시점문제- 스케쥴링
  }

  // 화면그리기
  public void initDisplay() {
    jbtn_log.addActionListener(this);
    this.add("North", jbtn_log);
    this.add("Center", jsp_log);
    this.setSize(500, 400);
    this.setVisible(true);
  }

  // 스레드가 두 개 이므로 화면요청과 start()순서를 바꾸더라도 각자 처리가 됨
  public static void main(String[] args) {// 메소드 자체도 메인 스레드이다. 엔트리 포인트이다. 우선순위가 있다.
    TalkServer2 ts = new TalkServer2();
    ts.initDisplay();// 화면요청 먼저이다. 메인스레드. 순서가 있다. 경합이 벌어진다. 동시에 많은사람. 지속적으로 서비스 제공해야된다.
    // 내안에 run메소드가 재정의(오버라이드) 되어 있으니까
    //아래코드가 에러발생하는것은 러너블 임플리먼트에서 제거하였기때문이다.
    ts.init();//나는 서버, 대기탐, 누구를 기다리나?사용자. 클라이언트. 고객. 업무담당자.
  }

  // 서버소켓과 클라이언트 소켓을 연결. 추상메소드
  public void init() {
    // 서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
    // 벡터는 멀티 스레드라 안전하다-서버에 동시 접속자 수가 여러명이니까
    // 그래서 벡터 안에는 클라이언트를 관리하는 스레드를 추가해야한다.
    // 그 스레드는 메세지를 듣고(청취하고) 들은 내용을 그대로 클라이언트측에 내보냄
    // 200#토마토#오늘스터디할까?-프로토콜 설계! StringTokenizer=new StringTokenozer("", "#");
    // st.nextToken();String-200
    // st.nextToken();String-토마토-닉네임
    // st.nextToken();String-오늘 스터디할까?-메세지
    globalList = new Vector<>();// 멀티스레드안전해서 ArrayList대신 사용함
    boolean isStop = false;
    // try-catch블록. 네트워크는 항상 장애가 발생할 수 있다.-예외처리를 한다.
    // try-catch사이에는 예외가 발생할 가능성이 있는 코드를 넣는다.
    // 콜백 함수란? 시스템에서 필요할때 대신 호출해주는 메소드
    // 언제 호출 되나요? 스레드 인스턴스 변수.start();요청하면
    // 왜이렇게 호출하나요?-여러 스레드가 존재하고 경합이 벌어지므로 우선순위를 따져가며 호출함
    // 어떻게 호출 하나요?
    // 왜 반드시 run매소드를 제정의 해야 하나요?
    try {
      server = new ServerSocket(3000);// 서버포트번호 설정하기
      jta_log.append("Server Ready.........\n");// 대기 탐 - 멈춤 - wait
      while (!isStop) {// 언제 while문 안으로 진입하지?->new Socket(ip-서버의, port)
        socket = server.accept();
        jta_log.append("client info:" + socket + "\n");
        jta_log.append("client info:" + socket.getInetAddress() + "\n");
       //String - VARCHAR2,CHar, int-number(5):9999 double-number(7,2)99999.99
       //위와같이 이종간의 언어에서 데이터를 공유(static)목적으로 설계하는 디자인 패턴 이름-DTO
        //DeptVO-this사용-전변초기화-ValueObject패턴일부-오라클과 자바 연동 필요함. 설계됨
       //ActionListener를 구현할 때 사용-버튼.addActionListener(this)
       //new XXX(this)-클래스분리, 나눌때, MVC패턴으로 구현할 때
       //생성자 호출 시 파라미터로 들어오는 this는 현재 인스턴스화 된 객체를 가리킨다.
       //아래는 객체를 생성하는것과 동시에 생성자를 호출하는데 클래스 이름을 바꾸었다. 그러니까 에러발생
       //해결방법은 TalkSeverThread의 생성자 파라미터 타입을 TalkSever2로 변경하면 됨
        
       
       TalkServerThread2 tst = new TalkServerThread2(this);
        // TalkServerThread tst = new TalkServerThread(super);//여기서 슈퍼는 JFrame이다.
        //TalkSeverThread가 화면을 만들때 JFrame을 상속받았다.
        tst.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }//////////////////////// [[ end of run ]] /////////////////////////

  @Override
  public void actionPerformed(ActionEvent e) {
    // 로그를 파일로 저장하기

  }
}

/*
 * 채팅서버 구축하기
 * 
 * 클라이언트 측에서 접속하면 접속해온 정보를 서버측 화면에서 볼 수 있다.(JFrame을 상속했다.)
 * 자바는 단일 상속만 가능하다.-이러한 약점을 인터페이스로 지원하고있다. -그래서 다중 인터페이스 구현체는 가능하다.
 * 스레드를 구현하는 방법에는
 * 1. 스레드를 상속하기
 * 2. Runnalbe 인터페이스를 implements하기
 * 현재의 TalkSever는 JFrame을 상소받고있어서 Runnable을
 */