package dev_java.week4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Button1 extends JFrame{
//선언부
Button1Event bevent=new Button1Event(this);//상속, 추상클래스 중심, 인터페이스 중심의 코딩 전개해야
//게으른 인스턴스화
//북쪽배치
JButton jbtn_ins=null;//선언만 했다. 생성자 호출 안된다.
//이른 인스턴스화
//남쪽배치
JButton jbtn_upd= new JButton("수정");//선언 및 생성 동시에 생성자 호출까지
//생성자
Button1(){
  System.out.println("Button1디폴트 생성자 호출"+jbtn_ins);//버튼 완성 전에 실행되서 null이다.
  //생성자 안에서 버튼 객체를 생성하면 뭐가 다르지? 어떻게 다른지?-시점에 따라 NullPointerException
  initDisplay();//new Button1이 호출 되면 자동으로 호출이 일어남
  System.out.println("initDisplay호출 후"+(jbtn_ins==null));
  jbtn_ins=new JButton("입력");//initDispaly랑 순서바꾸니까 입력버튼에서 널익솁션뜸
  System.out.println("입력버튼 생성 후=====>"+(jbtn_ins==null));
}

//화면처리부
  public void initDisplay(){
    jbtn_upd.addActionListener(bevent);//여기서는 this안됨
    System.out.println("initDisplay 호출 성공");
    //동쪽배치
    JButton jbtn_del=new JButton("삭제");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    if(jbtn_ins!=null){//if문은 흐름을 바꾼다.
      this.add("North",jbtn_ins);
    }
  
    this.add("South",jbtn_upd);
    this.add("East",jbtn_del);
    this.setSize(400,300);
    this.setVisible(true);
  }

}
//ActionListener의 구현체 클래스이다.-이벤트 핸들러 클래스이다.
//인터페이스는 추상 메소드만 가진다.
class Button1Event implements ActionListener{
  Button1 button1 = null;//주석하면 문법에러
  // Button1 button1=new Button1();//이거는 복사본->망함
  public Button1Event(Button1 button1){
    this.button1=button1;//주석처리하면 런타임에러. 치환을 안해서.
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj=e.getSource();
    //너 수정버튼 누른거야?
    if(obj == button1.jbtn_upd){
      System.out.println("수정버튼 클릭");
    }
  }

}
public class Button1Main {
  public static void main(String[] args) {
    Button1 b1=new Button1();
    // Button1 b2=new Button1();
    // Button1 b3=new Button1();//화면 세개 열린다. 각각 다른 복제본 객체
    
  }
}
