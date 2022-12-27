package dev_java.network3;

public class ServerTest {
  public static void main(String[] args) {
    //인스턴스화를 하면 생성자(디폴트)도 호출된다.
    //아래중에서 생성자 안에 메소드 호출구문이 있는 바나나만 화면나옴
    BananaServer bs= new BananaServer();
    KiwiServer ks= new KiwiServer();
  }
  
}
