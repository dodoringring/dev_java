package dev_java.assignmentTest.Dec.Test1230;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {
  //메인 스레드이다.
  public static void main(String[] args) {
    System.out.println("Main시작");
    ChatServer cs=new ChatServer();
    Thread th=new Thread(cs);
    th.start();
    System.out.println("Main끝");
  }

  @Override
  public void run() {
    int port=3000;
    ServerSocket server=null;
    try {
      System.out.println("Run호출 성공");
      server=new ServerSocket(port);
      //대기상태~~~시간이 가다가 ChatClient에서 new Socket("서버아이피",3000)
      System.out.println("서버소켓 생성 완료-클라이언트 소켓 접속 기다리는 중...");
      while(true){
        //아래코드가 진행되는 시점은 언제지?-new Socket("서버ip","포트");
        Socket client=server.accept();
        System.out.println("Client 측 :"+client.getInetAddress());
        //금융권 위주로 사용됨-보안강화-직렬화기법-마샬링, 언마샬링 구간...
        //말하기-ObjectOutPutStream->writeObject();네트워크 전송일어남-패킷
        //듣기-ObjectInputStream->readObject();듣기
        break;
      }
    } catch (Exception e) {
     e.printStackTrace();
    }
    
  }
  
}
