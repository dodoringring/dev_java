package dev_java.ch03.table;

class T1{
int i =1;
}

public class T1Main{
  public static void main(String[] args) {
    T1[] t1s=new T1[3];
    T1 t1 = new T1();
    t1s[0]=t1;

    System.out.println(t1);//t1의 주소번지가 다르다
    T1[] t1s=new T1[3];
    t1=new T1();
    t1s[1]=t1;
    System.out.println(t1);//t1의 주소번지가 다르다
    T1[] t1s=new T1[3];
    t1=new T1();
    System.out.println(t1);//t1의 주소번지가 다르다
    t1s[2]=new T1();

    for(T1 t:t1s){
      System.out.println(t+"");
    }
  }
  
  
}
