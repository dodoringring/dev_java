package dev_java.network2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
  TalkServer ts =null;
  Socket client=null;
  ObjectOutputStream oos=null;
  ObjectInputStream ois=null;
  String chatName=null;
  //생성자
  public TalkServerThread(){
  
  }
  public TalkServerThread(TalkServer ts) {
    this.ts=ts;
    this.client=ts.socket;
    try {
      oos=new ObjectOutputStream(client.getOutputStream());//말하기
      ois=new ObjectInputStream(client.getInputStream());//듣기
      String msg=(String)ois.readObject();
      ts.jta_log.append(msg+"\n");
      StringTokenizer st=new StringTokenizer(msg,"#");
      st.nextToken();//100 skip
      chatName=st.nextToken();//토마토저장
      ts.jta_log.append(chatName+"님이 입장하였습니다.\n");
      //현재 서버에 입장한 클라이언트 스레드 추가하기
    
      ts.globalList.add(this);
      this.broadCastring(msg);
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
  public void broadCastring(String msg){
    for(TalkServerThread tst:ts.globalList){
      tst.send(msg);
    }

  }
  //클라이언트에게 말하기 구현
  public void send (String msg){
    try {
      oos.writeObject(msg);
    } catch (Exception e) {
      e.printStackTrace();//디버깅할때 유익함 외우세요
      // TODO: handle exception
    }
  }
  @Override
  public void run(){
  
  } 
}
