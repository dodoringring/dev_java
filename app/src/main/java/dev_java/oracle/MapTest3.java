package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//회원정보를 담기
public class MapTest3 {

  public static void main(String[] args) {
    List<Map<String, Object>> list=new ArrayList<>();
    //회원아이디, 회원이름, 비번, 성별
    //키는 mem_id,mem_name,mem_pw,mem_gender
    //정보 3가지 tomato, 토마토, 123, 남자
    // banana, 바나나, 123, 여자
    // kiwi, 키위, 123, 남자
    //Map을 세개만들어라?
    System.out.println(list);//아무것도 없어. 넣기전 []만 출력된다.
    Map<String, Object> m1=new HashMap<>();
    m1.put("mem_id","tomato");
    m1.put("mem_name","토마토");
    m1.put("mem_pw","123");
    m1.put("mem_gender","남자");
    list.add(m1);
    System.out.println(m1);//@abcd1234아니고 자동으로 값이나온다. toString을 Object이 갖고있다.
    // System.out.println(m1.toString());//@abcd1234아니고 자동으로 값이나온다. toString을 Object이 갖고있다. 
    //자료구조중에 toString을 가지고 있는 애들이 있다.
    System.out.println(m1.get("mem_name"));

    Map<String, Object> m2=new HashMap<>();
    m2.put("mem_id","banana");
    m2.put("mem_name","바나나");
    m2.put("mem_pw","123");
    m2.put("mem_gender","여자");
    list.add(m2);
    Map<String, Object> m3=new HashMap<>();
    m3.put("mem_id","kiwi");
    m3.put("mem_name","키위");
    m3.put("mem_pw","123");
    m3.put("mem_gender","남자");
    list.add(m3);
    
    System.out.println(list);
    //list를 이용해서 토마토만 출력....
    Object a=list.get(0).get("mem_id");
    System.out.println(a);

    System.out.println("1 : "+list.get(0));//Map만 찍기
    System.out.println("2 : "+list.get(0).get("mem_name"));
    System.out.println("3 : "+list.get(0).get("mem_pw"));
  }
  
}
