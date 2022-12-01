package dev_java.ch01;

//java.lang폴더에 없는 클래스는 모두 import문을 작성해야함
import javax.swing.JFrame;//자바에서 제공하는 

public class LoginView {

  public static void main(String[] args) {
    // 윈도우 운영체제 안에서
    JFrame jf_login = new JFrame();

    int width = 300;// 로그인 창의 가로길이를 담는 선언
    int height = 200;// 로그인 창의 세로길이를 담는 선언

    jf_login.setTitle("로그인 화면 Version1.0");// 내가만든 창의 타이틀바에 문자 열 찍기

    jf_login.setSize(width, height);// 내가만든 창의 가로세로길이 정해주는 메소드 호출
    Return1 r1 = new Return1();// 내가 만든 창을 화면에 활성화 또는 비 활성화
    jf_login.setVisible(r1.isView1());
    

  }

}
