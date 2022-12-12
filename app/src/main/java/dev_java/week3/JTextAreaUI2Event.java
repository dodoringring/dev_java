package dev_java.week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI2Event implements ActionListener {//오버라이드랑 임플리먼트 세트이다
  JTextAreaUI2 jUi2=null;
  public JTextAreaUI2Event(JTextAreaUI2 jUi2){
    this.jUi2=jUi2;
    
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource();
    if(jUi2.jtf==obj){
      String input = jUi2.jtf.getText();
      jUi2.getTextArea().append("JTextAreaUI원본"+input+"\n");
      jUi2.jtaUILogic.account(input);
      jUi2.jtf.setText("");
    }
    
    
  }
  
}
