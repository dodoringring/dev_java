package dev_java.address;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBook implements ActionListener {
  // 선언부
  JFrame jf = new JFrame();
  JPanel jp = new JPanel();
  String[] jb_label = new String[] { "전체조회", "입력", "수정", "상세보기" };
  JButton[] jbtn = new JButton[4];
  // ▽ BorderLayout 중앙에 테이블(주소록 목록) 추가하기.
  // JTable Header에 들어갈 문자열 선언
  String header[] = { "번호", "이름", "H.P" };
  // J
  String datas[][] = new String[3][3];
  DefaultTableModel dtm = new DefaultTableModel(datas, header);
  JTable jt = new JTable(dtm);// dtm이 Data_set
  JScrollPane jsp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

  AddressDialog aDialog = new AddressDialog();

  // 생성자
  public AddressBook() {
    initDisPlay();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == jbtn[0]) {
    } else if (obj == jbtn[1]) {
      aDialog.setDialog(jb_label[1], true);
    } else if (obj == jbtn[2]) {
      aDialog.setDialog(jb_label[2], true);
    } else if (obj == jbtn[3]) {
      aDialog.setDialog(jb_label[3], true);
    }
  }

  public void initDisPlay() {
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(500, 450);
    jf.setTitle("주소록 Ver1.0");
    // JPanel은 FlowLayout이 기본값인데 사용자 정의 크기와 위치를 위해 레이아웃을 뭉갠다.
    // setLayout으로 Null값을 줘서 뭉갬. 그리고 좌표를 직접 입력해 붙이는 방법을 쓴다고 함.
    jp.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
    // jp.setLayout(null);
    for (int i = 0; i < jbtn.length; i++) {
      jbtn[i] = new JButton(jb_label[i]);
      // jbtn[i].setBounds(20, 20, 120, 30);
      jp.add(jbtn[i]);
      jbtn[i].addActionListener(this);// ***
    }
    jf.add("North", jp);
    jf.add("Center", jsp);
    jf.setVisible(true);
  }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    new AddressBook();
  }
}