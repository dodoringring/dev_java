package dev_java.week5;

import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {
  //서버측에는 소켓이 두개 필요함
  //ServerSocket-동시에 많은 사람 접속해올때 튕기지 않고 모두 받아주기위한 소켓
  //Socket-실제로 일하는 소켓
	public void server() {
		int port = 3000;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("서버 소켓 생성되었습니다.");
      //대기상태 진행됨-이 뒤에 있는 코드는 진행이 안된다.
			while(true) {
        //언제 이 코드로 진입 하는가?-while문
				Socket client = server.accept();
				System.out.println("client : "+client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		NetworkServer ns = new NetworkServer();
		ns.server();
	}

}