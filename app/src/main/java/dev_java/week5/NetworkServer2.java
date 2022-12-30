package dev_java.week5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer2 {
	public void server() {
		int port = 3000;
		ServerSocket server = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			server = new ServerSocket(port);
			System.out.println("서버 소켓 생성되었습니다.");
			while (true) {
				Socket client = server.accept();//클라이언트소켓에서 받아오기
				System.out.println("client : " + client);
				oos = new ObjectOutputStream(client.getOutputStream());//하드웨어와 연결되어있는 소켓 클래스가 있어야 된다.그렇게 생각하기...
				ois = new ObjectInputStream(client.getInputStream());
        //듣기코드
				String msg = (String) ois.readObject();//스피커(h/w)
				System.out.println("msg : " + msg);
				oos.writeObject(msg);//말하기코드 마이크(h/w)-소켓-oos만들어야
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NetworkServer2 ns = new NetworkServer2();
		ns.server();
	}

}