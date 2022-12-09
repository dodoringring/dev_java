package dev_java.view;
//로직

import dev_java.view.Array.ButtonArray2;

public class AccountSample {
  ButtonArray2 ba2=null;//원본을 가져오고 싶다. 그래서 new로 인스턴스화 안한다.
  public AccountSample(ButtonArray2 ba2){
    this.ba2=ba2;
  }
  public String account(){
    return "낮춰라";
  }

  public void account2(){
    String msg = "낮춰라";
    ba2.jta_display.append(msg+"\n");
  }
  
}
