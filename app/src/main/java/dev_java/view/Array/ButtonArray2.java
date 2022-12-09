package dev_java.view.Array;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;//이벤트 리스너

// import dev_java.view.AccountSample;?????????????????????????월요일 질문하기




public class ButtonArray2 implements ActionListener{//액션리스너를 쓰려면 임플리먼트 해야된다
//선언부
AccountSample action = new AccountSample(this);//this원본을 넘긴다.

JFrame jf = new JFrame();//인스턴스화 함으로써 setSize(400,300);가로 세로 크기지정 setVisible(윈도우 창에 활성화 하기)
JPanel jp_center=new JPanel();

JTextArea jta_display= new JTextArea(10,20);
JScrollPane jsp_display=new JScrollPane(jta_display);
JTextField jtf_input=new JTextField();

JPanel jp_east=new JPanel();
// JButton jbtn_new=new JButton("새게임");
// JButton jbtn_dap=new JButton("정답");
// JButton jbtn_clear=new JButton("지우기");
// JButton jbtn_exit=new JButton("종료");

//배열로 버튼 만들기
JButton jbtns[]=new JButton[4]; //null이 들어있다...?디폴트
String jbtn_label[]={"새게임","정답","지우기","종료"};
//생성자-디폴트생성자 
public ButtonArray2(){
  System.out.println("디포트 생성자 호출");
  //이벤트 소스와 이벤트 처리를 하는 핸들러 클래스를 매핑하기
  jtf_input.addActionListener(this);
  // jbtn_new.addActionListener(this);
  // jbtn_dap.addActionListener(this);
  // jbtn_clear.addActionListener(this);
  // jbtn_exit.addActionListener(this);
  //for문으로 돌려보자!

  initDisplay();
}
//화면그리기
public void initDisplay(){
  System.out.println("화면그리기 호출");
  
  //윈도우 창 오른쪽상단끝에 x버튼 누르면 종료 후 가상머신과 연결끊기
  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  jp_center.setLayout(new BorderLayout());
  
  jp_center.add("Center",jsp_display);
  jp_center.add("South",jtf_input);
  jp_east.setLayout(new GridLayout(4,1,2,2));

  for(int i=0;i<jbtns.length;i++){
    jbtns[i]=new JButton(jbtn_label[i]);
    jbtns[i].addActionListener(this);
    jp_east.add(jbtns[i]);
  }

  jbtns[0].setBackground(new Color(158,9,9));
  jbtns[0].setForeground(new Color(212,212,212));
  jbtns[1].setBackground(new Color(180,7,15));
  jbtns[1].setForeground(new Color(0,0,0));
  jbtns[2].setBackground(new Color(1,160,160));
  jbtns[2].setForeground(new Color(0,0,0));
  jbtns[3].setBackground(new Color(215,255,0));
  jbtns[3].setForeground(new Color(0,0,0));

  
  // jp_east.add(jbtn_new);//윈도우 창 내에 버튼 생성. 레이아웃 다음에 와야 버튼이 위로 보인다.위치가 중요하다.
  // jp_east.add(jbtn_dap);
  // jp_east.add(jbtn_clear);
  // jp_east.add(jbtn_exit);

  jp_center.setBackground(Color.ORANGE);
  jf.add("Center", jp_center);
  jf.add("East", jp_east);

  jf.setSize(400,300);//스태틱이 아니다. 다트연산자로 처리
  jf.setVisible(true);
}
//메인메소드
  public static void main(String[] args) {
    new ButtonArray2();
    
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    // e.getsource는 이벤트가 감지되는 컴포넌트(JTextField)의 주소번지를 반환함
    Object obj = e.getSource();
    //너 새게임 할려구..?
    if(jbtns[0]==obj){//주소번지 비교. 같은 주소면 이벤트가 일어난거다. 여기서 눌린거다
      jta_display.append("새게임을 시작합니다.\n");//디스플레이 표시에 글자를 갖다붙임
    }
    //너정답 볼래?
    else if (jbtns[1]==obj){
      jta_display.append("정답입니다\n"); //개행표시 : 엔터
    }
    //화면좀 지워줘
    else if(jbtns[2]==obj){
    jta_display.setText("");
    }

    //나 그만할래
    else if(jbtns[3]==obj){
      System.exit(0);
    }

    // 너 JTextField에서 엔터친거야?
    else if(jtf_input==obj){
      //사용자가 텍스트 필드에 입력한 문자열을 읽어 온다.
      String input=jtf_input.getText();
      // jta_display.append(input+":"+action.account()+"\n");//뷰에다가 로직을 인스턴스화 해야된다. 뷰가 로직을 원해
      action.account2();
      jtf_input.setText("");//자동으로 텍스트 입력 후 없애주는 역할
    }
  
    
  }
  
}
