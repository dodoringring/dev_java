package dev_java.network1;

import java.io.IOException;
import java.io.ObjectInputStream;//듣기
import java.io.ObjectOutputStream;//말하기
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
//서버를 기동하고 클라이언트가 접속해 오기를 기다린다-기다리면 스레드
public class TimeServer extends Thread{
  //선언부
  //객체직렬화가 가능하고 듣기와 쓰기가 가능한 I/O관련 클래스 선언
  ObjectOutputStream oos=null;//소켓이있어야만 객체 생성 가능함-말하기
  ObjectInputStream ois=null;//소켓이 있어야만 객체생성 가능함-듣기
  Socket client=null;//전변위치
  //run메소드 재정의 -스레드에서 할일을 처리함
  //반드시 선언부가 일치해야한다-부모가 가진 메소드와(쓰레드)
  //TimeServer is a Thread관계가 성립하니까 상속처리 가능하다

  //생성자
  TimeServer(){
  }
  //아래생성자가 필요한 이유는 서버소켓에 접속해온 클라이언소켓을 
  //런 메소드에서 사용해야하니까 전변으로 치환해야함.
  TimeServer(Socket client){
    this.client=client;
  }
  //스레드 구현 메소드에서 서버 소켓에 접속해온 클라이언트 소켓을 가지고 
  //말하기와 듣기에 필요한 oos와 ois객체를 생성함
  // I/O도 지연과 데드락 상태에 빠질수 있으므로 반드시 예외처리할것.
  @Override
  public void run(){
    //여기서 처리해야한다 
    try {
      oos=new ObjectOutputStream(client.getOutputStream());
      ois=new ObjectInputStream(client.getInputStream());
      while(true){
        oos.writeObject(getTimeMessage());//12:05:45
        try {
          sleep(1000);//sleep은 1000 즉, 1초만큼 정지한다. 그래서 1초에 한번씩 나오는것이다.
        } catch (InterruptedException ie) {
          
        }
      }//end of while
    } catch (Exception e) {
     
    }//end of try-catch
  }
  //메인메소드
  public static void main(String[] args) {
    //서버소켓 생성시 파라미터로 포트 번호가 필요하다
    int port=7891;
    //동시에 여러사람이 접속을 시도함

    ServerSocket server =null;
    Socket client=null;//여기에 들어오는 소켓은 서버소켓에 접속해온 클라이언트의 소켓이다. 주소번지이다.클라이언트를 참조하고있다.
   try {
      server=new ServerSocket(port);
    } catch (IOException ie) {
      System.out.println("Cant't bind port"+ port);
      ie.printStackTrace();//에러메세지를 라인번호와 함께 출력-힌트문-디버깅
      try {
        server.close();
      } catch (Exception e) {
        System.exit(0);//서버 강제종료시킴
      }
    }//end of try-catch
    System.out.println("TimeServer start successfully...");
    while(true){
      try {
        //클라이언트가 접속해오기를 기다리다가 접속(new Socket("192.168.10.47",7891))을 해 오면 
        //아래 메소드가 클라이언트 소켓 정보를 취득함
        client=server.accept();
        System.out.println(client.getInetAddress());//클라이언크의 네트워크 정보
        System.out.println("New Client connected...");
        //쓰레드의 개입이 필요하다-1초동안 sleep(1000)멈춰라는뜻...호출하고 현재 시분초 정보를 출력해야한다
        //스레드를 동작시킴-스레드에 추상 메소드 런을 호출해야한다.
        //주의사항: 런을 직접 호출하는게 아니라 start() 호출하면 JVM이 순서를 따져서 출발시킴-콜백
        //스레드 대기방에 모여있다가 순서대로 나가는 느낌/ 스레드가 메소드를 지원하고있다.
        TimeServer ts =new TimeServer(client);//왜냐면 런에서 사용하고 싶으니까
        ts.start();//런 메소드가 호출
        System.out.println("New TimeServer Thread Started...");
      } catch (Exception e) {
        
      }
    }//end of while
  }//end of main
  public String getTimeMessage(){
    Calendar cal=Calendar.getInstance();
    int hour=cal.get(Calendar.HOUR_OF_DAY);
    int min=cal.get(Calendar.MINUTE);
    int sec=cal.get(Calendar.SECOND);
    return (hour<10?"0"+hour:""+hour)+":"
    +(min<10?"0"+min:""+min)+":"
    +(sec<10?"0"+sec:""+sec)+" 얄루^-^";
  // return "얄루^^";
  }
  
}
