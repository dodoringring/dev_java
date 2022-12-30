package dev_java.week5;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWirter {

  public void output(){
    FileWriter fw=null;
    try {
      fw= new FileWriter("text.txt",true);
      fw.write(97);
      fw.write(65);
      fw.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
}
