package dev_java.address;

import javax.swing.JDialog;//팝업창 띄우기

public class AddressDialog {
  JDialog jdg=new JDialog();

  public AddressDialog(){//생성자
    jdg.setTitle("입력| 수정| 상세보기");
    jdg.setSize(400,350);
    jdg.setVisible(true);//이게 포인트????
  }
  
  
}
