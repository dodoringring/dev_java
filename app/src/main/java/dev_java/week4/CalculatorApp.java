package dev_java.week4;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CalculatorApp extends JFrame implements ActionListener{
  //선언부
  Vector <String> v=new Vector();
  v.parseInt
  JTextField jtf_display=new JTextField(10);//북쪽에붙이기
  JPanel jp_center =new JPanel();
  JButton jbtn_clear = new JButton("C");//clear
  JButton jbtn_equal = new JButton("=");
  JButton jbtn_one = new JButton("1");
  
  JButton jbtn_plus = new JButton("+");
  JButton jbtn_minus = new JButton("-");
  JButton jbtn_mult = new JButton("*");
  JButton jbtn_div = new JButton("/");
  JButton jbtn_two = new JButton("2");

  Font f = new Font("Paryrus", Font.BOLD,40);


  //생성부
  public CalculatorApp(){
    initDisplay();
  }

  //화면처리기
  public void initDisplay(){
    jbtn_one.setFont(f);
    jbtn_two.setFont(f);
    jbtn_plus.setFont(f);
    jbtn_minus.setFont(f);
    jbtn_clear.setFont(f);
    jbtn_equal.setFont(f);
    jbtn_div.setFont(f);
    jbtn_mult.setFont(f);

    jp_center.setBackground(Color.CYAN);
    jp_center.setLayout(new GridLayout(2,6,2,2));
    jp_center.add(jbtn_plus);
    jp_center.add(jbtn_minus);
    jp_center.add(jbtn_one);
    jp_center.add(jbtn_two);
    jp_center.add(jbtn_mult);
    jp_center.add(jbtn_div);
    jp_center.add(jbtn_equal);
    jp_center.add(jbtn_clear);
    jtf_display.setEditable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//다대문자 상수
    this.add("Center", jp_center);
    this.add("North", jtf_display);

    this.setTitle("내가만든 계산기");
    this.setSize(500,300);
    this.setVisible(true);

  }

  public static void main(String[] args) {
    new CalculatorApp();
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj=new Object();

    int a=0;
    int b=0;
    String x=null;
    int result=0;

    System.out.println("숫자를 눌러주세요");
    if(obj==jbtn_one){
      a=1;
    }else if(obj==jbtn_two){
      a=2; 
    }
    System.out.println("연산기호를 눌러주세요");
    if(obj==jbtn_plus){
       x="+";
    }else if(obj==jbtn_minus){
      x="-";
    }else if(obj==jbtn_mult){
      x="*";
    }else if(obj==jbtn_div){
      x="/";
    }
    System.out.println("숫자를 눌러주세요");
    if(obj==jbtn_one){
      b=1;
    }else if(obj==jbtn_two){
      b=2;
    }
    
    if(obj==jbtn_equal){
      if(x=="+"){
      result= a+b;
      }else if(x=="-"){
      result= a-b;
      }else if(x=="/"){
        result=a/b;
      }else if(x=="*"){
        result=a*b;
      }
      System.out.println("결과값 : "+result);
    }

    if(obj==jbtn_clear){
    a=0;
    b=0;
    x=null;
    }



    
    if(obj==jbtn_plus){
      v.add("+");
    }

    if(obj==jbtn_minus){
      v.add("-");
    }
    if(obj==jbtn_mult){
      v.add("*");
    }

    if(obj==jbtn_div){
      v.add("/");
    }
    if(obj==jbtn_clear){
      v.removeAllElements();
    }
    if(obj==jbtn_one){
      
    }
    if(obj==jbtn_two){
      v.add(2));
    }
    if(obj==jbtn_equal){
    
    }


    
  }
  
}
