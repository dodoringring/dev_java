package dev_java.week5;

import java.net.InetAddress;
import java.net.Socket;

public class NetworkClient {
	public void client() {
		int port = 3000;
		String serverIP = null;
		try {
			serverIP = "192.168.20.34"
			Socket socket = new Socket(serverIP, port);
			System.out.println("NetworkClient socket " + socket);
		} catch (Exception e) {
			System.out.println("NetworkClient client " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		NetworkClient nc = new NetworkClient();
		nc.client();
	}

}