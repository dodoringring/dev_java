package dev_java.network2;

import java.util.StringTokenizer;
import java.util.Vector;

public class TalkClientThread extends Thread{
  TalkClient tc=null;

  public TalkClientThread(TalkClient tc) {
      this.tc=tc;
    }
  
  //서버쪽에서 클라인어트가 접속하면 접속자의 정보를 List <TalkServerThread> add(스레드 생성자)했고
  //메세지를 청취 하자마자 클라이언트쪽에 반복문을 돌려서 쓰기 한다.(전송함)-broadCasting(String msg)
  @Override
  public void run(){
    boolean isStop=false;
    // :run_stop//라벨을 쓰면 바깥쪽 와일문 탈출할수있다.
    while(!isStop){
      try {
        //100#tomato 님이 입장하였습니다.
        String msg="";
        msg=(String)tc.ois.readObject();
        System.out.println("서버에서 전송된 msg:"+msg);
        StringTokenizer st =null;
        int protocol=0;//100 200 300 400 500
        if(msg!=null){
          st=new StringTokenizer(msg, "#" );
          protocol=Integer.parseInt(st.nextToken());
        }
        System.out.println("protocol :"+protocol);
        switch(protocol){
          case Protocol.TALK_IN:{
            String nickName=st.nextToken();
            tc.jta_display.append(nickName+"님이 입장하였습니다.\n");
            //JTable은 양식일 뿐이고 데이터셋은 디폴트테이블모델이니까 거기에 
            //닉네임을 출력함
            Vector<String> v =new Vector<>();
            v.add(nickName);
            //데이터셋 객체에 한개 로우 추가하기
            tc.dtm.addRow(v);
          }break;
          default:
          System.out.println("해당하는 프로토콜이 존재하지 않습니다.");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

  }
  
}
