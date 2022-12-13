package dev_java.address;

import javax.swing.JDialog;//팝업창 띄우기

public class AddressDialog {
  JDialog jdg=new JDialog();

  public AddressDialog(){//생성자
    // jdg.setTitle(); 없어도 된다. 오버라이드에서 만들었으므로
    jdg.setSize(400,350);
    jdg.setVisible(false);//이게 포인트????
  }
  // public AddressDialog(){
  //   initDisplay
  
  public void setDialog(String title, boolean isView){
    jdg.setTitle(title);
    jdg.setVisible(isView);
  }
  
}
