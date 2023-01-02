package dev_java.assignmentTest.Dec.Test1230;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
  public void output(){
  FileWriter fw=null;
  try {
    fw=new FileWriter("text.txt", true);
    fw.write(97);
    fw.write(65);
    //IO패키지는 스트림 형태로 이동하니꺼 열려있을 경우 위변조가 가능하다.
    //반드시 사용후에는 닫도록 하고 있다.
    fw.close();
  } catch (FileNotFoundException fe) {
    System.out.println("파일이 존재하지 않습니다.");
  }catch(IOException ie){
    ie.printStackTrace();
  }catch(Exception e){
    System.out.println(e.getMessage());
  }finally{
    //예외가 발생하든 그렇지않든 무조건 처리할 코드는 여기에 작성할 것
    try {
      if(fw!=null)fw.close();
    } catch (Exception e) {
      //보통 이렇게 파이널리로 함
    }
  }
  }

  public static void main(String[] args) {
    FileTest ft=new FileTest();
    ft.output();
  }
  
}
