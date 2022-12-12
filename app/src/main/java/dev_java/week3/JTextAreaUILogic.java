package dev_java.week3;

import javax.swing.JTextArea;
//메모리 스택오버플로우 발생-서버가 중지됨
public class JTextAreaUILogic {
  //여기서 직접인스턴스화하면 복제본-망함
  // JTextAreaUI jta = new JTextAreaUI(10,20); 직접 인스턴스화
  JTextAreaUI jtaUI = null;


  public JTextAreaUILogic(JTextAreaUI jTextAreaUI){
    //생성자 안에서 JTextArea원본과 전변을 초기화 해주어야 한다.
    this.jtaUI=jTextAreaUI;//this로 원본 사용 앞에 this가 넘겨준다...?
  }
  
  public JTextAreaUILogic(JTextAreaUI2 jTextAreaUI2) {
  }

  public void account(String input){
    System.out.println("호출성공");
    //JTextAreaUI클래스에 정의된 주소번지를 사용하고 싶다. 어떡하지?
    //insert here
    jtaUI.jta.append("UILogic"+input+"\n");
  }
}
