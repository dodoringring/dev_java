package dev_java.ch03.Practice;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class GradeView extends JFrame implements ActionListener {
   // 선언부
   JLabel jlb_inwon = new JLabel("성적처리인원수:", JLabel.RIGHT);
   JLabel jlb_num = new JLabel("명", JLabel.LEFT);
   JTextField jtf_inwon = new JTextField();
   JButton jbtn_create = new JButton("만들기");
   JButton jbtn_account = new JButton("연산");
   JButton jbtn_add = new JButton("3명샘플");
   JButton jbtn_clear = new JButton("지우기");
   JButton jbtn_exit = new JButton("종료");
   JPanel jp1 = new JPanel();
   JPanel jp2 = new JPanel();
   JPanel jp3 = new JPanel();
   /*
    * TableModel을 구현한 것들은 이러한 데이터가어떻게 저장되었는지 뿐만 아니라 어떻게 데이터를 덧붙이고 조작하고 알아내는지에 대해서도
    * 명시한다. 또한 TableModel은 특정셀이 편집될 수 있는지 각 열의 데이터 타입은 무엇인지를 알아내는 역할도 한다. JTable의
    * TableModel에 있는 데이터의 위치는 JTable 이 화면에 디스플레이 되었을 때의 위치와 일치하지 않는다.
    * DefaultTableModel은 JTable의 생성자에서 아무런 모델도 지정해 주지 않았을 때 쓰이는 클래스이다.
    * 
    */
   DefaultTableModel dtm = null;
   /*
    * TableColumnModel은 TableColumn의 인스턴스를 관리하기 위해 디자인 되었다. TableColumn은
    * TableModel데이터의 한 열을 표현하여 실제 JTable GUI에 보여지는 열을 관리하는데 필요한 것이다.
    */
   DefaultTableColumnModel dtcm = null;
   DefaultListSelectionModel dlsm = null;
   JTable jt = null;
   JScrollPane jsp = null;
   TableColumn tc = null;
   TableColumn tc1 = null;
   TableColumn tc2 = null;
   TableColumn tc3 = null;
   TableColumn tc4 = null;
   TableColumn tc5 = null;
   TableColumn tc6 = null;
   TableColumn tc7 = null;
   /*
    * DefaultCellRenderer는 TableCellEditor인터페이스와 TreeCellEditor인터페이스를 모두 구현한다. 이
    * 에디터는 셀을 편집하기 위해 JTextField, JComboBox 또는 JCheckBox를 반환하도록 디자인 되었다.
    */
   DefaultTableCellRenderer dtcr = null;
   DefaultTableCellRenderer dtcr1 = null;
   DefaultTableCellRenderer dtcr2 = null;
   DefaultTableCellRenderer dtcr3 = null;
   DefaultTableCellRenderer dtcr4 = null;
   DefaultTableCellRenderer dtcr5 = null;
   DefaultTableCellRenderer dtcr6 = null;
   DefaultTableCellRenderer dtcr7 = null;
   JTextField jtf = null;
   JTextField jtf1 = null;
   JTextField jtf2 = null;
   JTextField jtf3 = null;
   JTextField jtf4 = null;
   JTextField jtf5 = null;
   JTextField jtf6 = null;
   JTextField jtf7 = null;
   // 학생 수를 입력 받을 변수 선언
   int num = 0;

   // 화면처리부
   public void initDisplay() {
      jtf_inwon.setHorizontalAlignment(JTextField.RIGHT);
      // 이벤트소스와 이벤트 처리 핸들러를 매핑
      // 이벤트소스.addActionListener(이벤트처리핸들러클래스의 인스턴스 변수);
      jtf_inwon.addActionListener(this);
      jbtn_account.addActionListener(this);
      jbtn_create.addActionListener(this);
      jbtn_exit.addActionListener(this);
      jbtn_add.addActionListener(this);
      jbtn_clear.addActionListener(this);
      jp1.setLayout(new BorderLayout());
      jp2.setLayout(new BorderLayout());
      jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
      jp1.add("West", jlb_inwon);
      jp1.add("Center", jtf_inwon);
      jp2.add("West", jlb_num);
      jp2.add("Center", jbtn_create);
      jp1.add("East", jp2);
      jp3.add(jbtn_account);
      jp3.add(jbtn_add);
      jp3.add(jbtn_clear);
      jp3.add(jbtn_exit);
      this.add("North", jp1);
      this.add("South", jp3);
      setTitle("성적처리");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 창모서리 X버튼 닫기 처리
      setLocation(200, 200);// 창이 열리는 위치
      setSize(400, 250);
      setVisible(true);
   }

   public static void main(String[] args) {
      JFrame.setDefaultLookAndFeelDecorated(true);
      GradeView gv = new GradeView();
      gv.initDisplay();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == jtf_inwon || e.getSource() == jbtn_create) {
         num = Integer.parseInt(jtf_inwon.getText().trim());
         System.out.println("num : " + num);
         dtm = new DefaultTableModel(num, 9);
         /*
          * dtm.setValueAt(aValue, row, column); String s = dtm.getValueAt(row, column);
          */
         dtcm = new DefaultTableColumnModel();
         dlsm = new DefaultListSelectionModel();
         jt = new JTable(dtm, dtcm, dlsm);
         jsp = new JScrollPane(jt);
         dtcr = new DefaultTableCellRenderer();
         jtf = new JTextField();
         DefaultCellEditor dce = new DefaultCellEditor(jtf);
         tc = new TableColumn(1, 120, dtcr, dce);
         tc.setHeaderValue("이름");
         dtcm.addColumn(tc);
         // html
         dtcr1 = new DefaultTableCellRenderer();
         jtf1 = new JTextField();
         DefaultCellEditor dce1 = new DefaultCellEditor(jtf);
         tc1 = new TableColumn(2, 75, dtcr1, dce1);
         tc1.setHeaderValue("국어");
         dtcm.addColumn(tc1);
         // oracle
         dtcr2 = new DefaultTableCellRenderer();
         jtf2 = new JTextField();
         DefaultCellEditor dce2 = new DefaultCellEditor(jtf);
         tc2 = new TableColumn(3, 75, dtcr2, dce2);
         tc2.setHeaderValue("영어");
         dtcm.addColumn(tc2);
         // java
         dtcr3 = new DefaultTableCellRenderer();
         jtf3 = new JTextField();
         DefaultCellEditor dce3 = new DefaultCellEditor(jtf);
         tc3 = new TableColumn(4, 75, dtcr3, dce3);
         tc3.setHeaderValue("수학");
         dtcm.addColumn(tc3);
         // 총점
         dtcr4 = new DefaultTableCellRenderer();
         jtf4 = new JTextField();
         DefaultCellEditor dce4 = new DefaultCellEditor(jtf);
         tc4 = new TableColumn(5, 75, dtcr4, dce4);
         tc4.setHeaderValue("총점");
         dtcm.addColumn(tc4);
         // 평균
         dtcr5 = new DefaultTableCellRenderer();
         jtf5 = new JTextField();
         DefaultCellEditor dce5 = new DefaultCellEditor(jtf);
         tc5 = new TableColumn(6, 100, dtcr5, dce5);
         tc5.setHeaderValue("평균");
         dtcm.addColumn(tc5);
         // 석차
         dtcr6 = new DefaultTableCellRenderer();
         jtf6 = new JTextField();
         DefaultCellEditor dce6 = new DefaultCellEditor(jtf);
         tc6 = new TableColumn(7, 50, dtcr6, dce6);
         tc6.setHeaderValue("석차");
         dtcm.addColumn(tc6);
         this.add("Center", jsp);
         this.validate();
         this.pack();
      } ////////////// end of if ////////////
      else if (e.getSource() == jbtn_account) {
         // 총점과 석차
         // 총점을 구해자
         // 석차를 매겨보자.
           // 위 2중 for문에서 처리된 결과를
           // 테이블에 반영하기
      } ////////////// end of 처리 버튼 구현
      else if (e.getSource() == jbtn_exit) {
      } else if (e.getSource() == jbtn_add) {
         String[][] data = { { "홍길동", "80", "75", "85" }, { "이성계", "90", "85", "80" }, { "강감찬", "70", "75", "70" } };
      } else if (e.getSource() == jbtn_clear) {
      }
   }
}