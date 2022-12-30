package dev_java.week6;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class S1{
  int age=30;
}
class S2{
  String animal="사자";
  int leg=4;
}
class S3{
  //3개짜리 클래스 설계
}
public class MapTest1 {
  List<Map<String, Object>> list=null;
  public static void main(String[] args) {
    S1 s1=new S1();
    System.out.println(s1.age);
    //Map에 넣고 age를 출력해보자!
    Map<String, Object> map1=new HashMap<>();
    map1.put("s1",s1);
    S1 s2=(S1)map1.get("s1");//겟은 오브젝트타입으로 꺼내온다 그래서 강제 형전환
    System.out.println(s2.age);
    // System.out.println(map1.get("s1").age);//안되나봄...
    // Map<String, String> map11=new HashMap<>();//타입이 달라서 안된다.
    // map11.put("s1",s1);

    Map<String, Object> map2=new Hashtable<>();
    S2 s3=new S2();
    map2.put("s2",s3);
    S2 s4= (S2)map2.get("s2");
    
    if(s4.animal instanceof String){
      System.out.println("문자열입니다");
      System.out.println(s4.animal);
    }
    //Deprecated 가급적 쓰지 말아라..예전꺼라서 줄그인다
    if(new Integer(s4.leg)instanceof Integer){
      System.out.println("정수형입니다.");
      System.out.println(s4.leg);
    }
    
  
    
  }
  
}
