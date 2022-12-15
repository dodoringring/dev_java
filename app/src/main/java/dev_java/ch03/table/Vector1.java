package dev_java.ch03.table;

import java.util.Vector;//

public class Vector1 {

  public static void main(String[] args) {
    Vector v=new Vector();//배열과 비슷
    Vector <String> v2=new Vector<>();
    v2.add("안녕");
    v2.add("2");
    Vector <String> v3=new Vector<>();//Vector는 오브젝트 단위로 담을 수 있다.
    Vector <Integer> v4=new Vector<>();//3차 배열 안쓴다 거의.
    v.add("안녕");//오토박싱? v.get(0)
    v.add(1);//v.get(1)
    System.out.println(v.size());//2
    System.out.println(v.get(0));//1

    // v.add(new Integer(1));// 오토박싱 있는데 왜이래? 줄을 쫙 그어줌. 담에 쓰지마라.
   
    System.out.println(v.get(0));//1
    System.out.println(v.get(1));//안녕
    String insa=(String)v.get(0);
    System.out.println(insa);
    String insa2=v2.get(0);//v가 오브젝트급이므로 스트링 안된다.강제형전환 근데 이렇게 안씀
    System.out.println(insa2);
    if(v.get(1)instanceof Integer){
    System.out.println("넌 문자열이야");}
    
  }
  
}
