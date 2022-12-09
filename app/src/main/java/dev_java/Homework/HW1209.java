package dev_java.Homework;
/*
 * 중간고사 점수 구하기
 * 학생별로
 * 총점구하는 메소드 따로
 * 평균구하는메소드 따로
 * 석차구하는 메소드 따로 
 * 만드세요~!
 */

public class HW1209 {
  String[]subject={"JAVA","ORACLE","SPRING"};
  //String[][]data= new int[3][4];
  String[][]data={ 
    {"이순신","80","75","70"}
    ,{"강감찬","90","85","95"}
    ,{"김춘추","65","60","60"}
  };

  //자바 점수의 합은?
  void javaTot(){
    int javaHap=0;
    for(int i=0;i<data.length;i++){
      javaHap +=Integer.parseInt(data[i][1]);
    }
    System.out.println("자바 총점은? : "+javaHap);
  }

  void namePrint(){
    for(int i=0;i<data.length;i++){//로우
      System.out.println(data[i][0]);
    }
  }

  public void total(String [][] data){
    int total=0;
    for(int i=0;i<data.length;i++){//data.length는 
      total=Integer.parseInt(data[i][1])+Integer.parseInt(data[i][2])+Integer.parseInt(data[i][2]);
      System.out.println(total);
    }
  }

  public void Average(){

  }
  
  public static void main(String[] args) {
  HW1209 hw = new HW1209();
  hw.namePrint();
  hw.javaTot();
  hw.total(hw.data);
  }
  
}
