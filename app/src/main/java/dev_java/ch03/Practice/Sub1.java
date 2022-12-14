package dev_java.ch03.Practice;

import javax.swing.JButton;
import javax.swing.JDialog;
// import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//기본 이외에 다 추가
//인터페이스를 임플리먼트하면 추상메소드를 재정의해야함

public class Sub1 implements ActionListener{
  //선언부 -전역변수의 위치
  //선언에서 결정되는 것은 무엇? 타입만 결정 되었다. 선언만 하면
  //원시형에서는 NullpointException 없다. 
  Main1 main1=null;//선언만 했다.-null의 의미는 결정이 되지 않았다는 뜻. 주소번지만 있다. 원본을 사용하겠다.
  // Main1 main1=new Main1();//선언도 했고 생성도 했고 생성자도 호출한다. 복제본이다.
  // JFrame jf = new JFrame();
  JDialog jdg=new JDialog();
  JButton jbtn=new JButton("저장");

  
  public void initDiplay(){
    
    jdg.add("South",jbtn);
    jdg.setTitle("Sub1");
    jdg.setSize(300,200);
    jdg.setVisible(true);
    jbtn.addActionListener(this);//인식????????????
  }

  public Sub1(){

  }
  public Sub1(Main1 a){//this를 받아주는 파라미터
    System.out.println(main1);
    if(main1==null){
      System.out.println("main1은 null입니다. 객체생성 안된 상태임");
    }
    //Main1 mian1=null의 의미가 된다.
    //나는 언제 호출되나요?-메입앱이 실행될때
    //어디서 호출?-Main1클래스에서
    //왜 호출?-입력을 눌렀을때, 주문을 할 때, 회원가입을 할때
    this.main1=a; //this는 Sub1이다. 위의 this랑 다른애다. 전역변수의 초기화다.*******
    //객체 치환이 일어났다.
    initDiplay();//스태틱 아니니까 그냥 호출 가능
    
  }
  int insert(){//1.입력성공 0:입력실패
    // main1불가하다 insert 메소드에서 접근이 불가함
    return 1;
  }

  // public static void main(String[] args) {
  //   new Sub1(null);//
  // }

/*
 * 콜백 메소드라고 부른다
 * 저장버튼이 클릭되었을때 jvm이 이를 감자하고 인터셉트하여 메소드 호출을 해줌
 * 파라미터인 ActionEvent 객체를 통해서 이벤트가 감지된 버튼을 구분 할 수 있음
 * 이 객체는 파라미터에 있으므로 JVM으로부터 주입이 되는 객체이다.
 * 다시말해 개발자가 인스턴스화 하지 않고 JVM이 대신 해줌
 */
  @Override
  public void actionPerformed(ActionEvent e) {
    //너 저장버튼 누른거야
    Object obj =e.getSource();
    // 반복문을 탈출할때는 break사용
    // 조건문을 탈출할때는 return사용
    if(obj==jbtn){
      int result=insert();
      if(result==1){
        JOptionPane.showMessageDialog(jdg, "입력에 성공 하였습니다.");
        main1.refresh();
        jdg.dispose();//새로고침확인 누르면 서브창 꺼지게한다.
      }
        else if(result==0){
          JOptionPane.showMessageDialog(jdg, "입력 실패하였습니다.");
          return;//actionPerformed를 탈출함
        }
    }
    
  }
}
