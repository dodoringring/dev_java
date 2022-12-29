package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//회원정보를 담기
public class MapTest5 {

  public static void main(String[] args) {
    List<Map<String, Object>> fruit=new ArrayList<>();
    Map<String, Object> rMap=new HashMap<>();
    rMap.put("mem_id","tomato");
    fruit.add(rMap);
    System.out.println("1 :"+rMap);//변수명은 같지만 15번은 apple출력
    rMap=new HashMap<>();//새로운 객체가 생성됨-타입은 같지만
    rMap.put("mem_id","apple");
    fruit.add(rMap);
    System.out.println("2 : "+rMap);//apple
    //insert here-tomato원해
    System.out.println("***"+fruit.get(0).get("mem_id"));
    System.out.println("***"+fruit.get(1).get("mem_id"));

    System.out.println();
    rMap=new HashMap<>();
    System.out.println("3 : "+rMap);
    
  }
  
}
