package dev_java.week3;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUI implements ActionListener{ //implements 결합도는 낮고 재사용성은 높여준다. 상속이 아니다. 추상메소드를 재정의함.
   //선언부
   JTextAreaUILogic jtaUILogic = new JTextAreaUILogic(this);//이른 인스턴스화 선언과 생성 동시에/ this는 로직에 값을 그대로 넘겨준다
   //인터페이스는 반드시 구현체 클래스가 있어야 한다.
   //단독으로 인스턴스화 불가함
   //선언부와 생성부의 타입이 다르다-그래서 다형성이 가능함-폴리모피즘-재사용을 높이고 결합도는 낮춤
   JFrame jf = new JFrame();
   JTextArea jta = new JTextArea(10,20);
   JTextField jtf = new JTextField(10);

   public JTextAreaUI(){//디폴트 생성자 선언
      initDisplay();
   }

   public void initDisplay(){//UI를 그려준다. 이벤트 처리가 필요하다. 그래서 addactionListener가 필요하다.
      //이벤트소스와 이벤트 핸들러 클래스 매핑하기(매칭)
      jtf.addActionListener(this);//this 나자신 : 이벤트 핸들러 클래스의 주소번지
      //멀티라인 작성 가능한 콤포넌트 배경색 설정
      jta.setBackground(Color.cyan);
      //JFrame은 디폴트 레이아웃이 보더레이아웃이라서 동 서 남북 중아 배치가능
      jf.add("Center", jta);//JTextArea는 중앙에 배치함
      jf.add("South", jtf);//남쪽에는 JTextField에 배치함
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도창 x버튼 클릭시 자원 회수함
      jf.setSize(400, 300);//윈도우창 가로세로 결정
      jf.setVisible(true);//화면을 출력함
   }
   public static void main(String[] args) {//가장먼저 호출됨. 엔트리 포인트이다.
      new JTextAreaUI();//생성자 호출 되고 그 안에서 화면 그리는 메소드 호출됨
   }
   @Override//구현체 클래스. 어노테이션 annotation-문법적인 제약을 갖고있다. 선언부가 일치해야한다.
   // 어떤 작업을 하겠다는 의미
   public void actionPerformed(ActionEvent e) {//actionPerformed 콜백 메소드 파라미터 자리이지만 값을 받게 되는
      //추상메소드의 파라미터를 통해서 감지된 컴포넌트의 주소번지를 얻어오는 
      //getSource메소드의 소유주임
      Object obj = e.getSource();//이벤트가 일어난 곳의 주소를 가져옴
      if(jtf == obj){//JTeatField에 엔터 친거야?
         //JTextField에 입력한 값 받기
         String input = jtf.getText();
         jta.append("JTextAreaUI원본"+input+"\n");
         jtaUILogic.account(input);
         jtf.setText("");
      }
   }
}

