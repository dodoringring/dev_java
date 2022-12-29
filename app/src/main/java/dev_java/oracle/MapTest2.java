package dev_java.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
  List<Map<String, Object>> list=new ArrayList<>();
  Map <String, Object> rMap=new HashMap<>();//rMap.size()=0
  public void setMap(){
    rMap.put("deptno",10);
    rMap.put("dname","인사부");
    rMap.put("loc","뉴욕");
    list.add(rMap);//list.get(0)하면 꺼내는것
    // Map<String, Object> rMap=new HashMap<>();//안됨.
    rMap=new HashMap<>();//리셋
    rMap.put("deptno",20);
    rMap.put("dname","킹갓부");
    rMap.put("loc","파리");
    list.add(rMap);//list.get(1)하면 꺼내는것
    rMap=new HashMap<>();
    rMap.put("deptno",30);
    rMap.put("dname","제너럴부");
    rMap.put("loc","올랜도");
    list.add(rMap);//list.get(2)하면 꺼내는것
    
  }
  public void mapPrint(){
    //각 로우 안에 키가 3개 있다.(컬럼-deptno,dname,loc)
    //Map m1=get(0) -컬럼이 3개, Map m2=get(2)-컬럼이 3개, Map m3=get(2)-컬럼이 3개
    //아래에서 반복해야되는것은 List 이다.(ArrayList이다)
    for(int i=0;i<list.size();i++){//반복해서 처리할 것은 row값이다.get(0),get(1),get(2)
      Map<String, Object> m1=list.get(i);
      //컬럼의 수를 반복해서 출력하기
      Object[] keys=m1.keySet().toArray();
      for(int j=0;j<keys.length;j++){
        String key =(String)keys[j];
        System.out.print(m1.get(key)+" ");
      }
      System.out.println();//개행처리
    }
  }

  public static void main(String[] args) {
    MapTest2 mt1=new MapTest2();
    mt1.setMap();//이렇게 안해도 되는것은 콜백 메소드뿐이다.
    //Map의 size는 세로방향이다. 컬럼의 수이다.
    System.out.println(mt1.rMap.size());//0->3
    //Map에서 제공하는 메소드 중에서 key값을 묶음 처리하는 메소드가 있다.
    Set<String> set =mt1.rMap.keySet();//set은 모든 키를 set객체에 담아서 리턴
    //set인터페이스가 제공하는 메소드 중에서 toArray()를 지원한다.
    Object obj[]=set.toArray();//deptno,dname,loc
    for(int i=0;i<obj.length;i++){//length는 배열의 원소의 갯수
      String key=(String)obj[i];//배열에서 꺼낸 값은 key값이다.
      System.out.println("key :"+key);//3번 출력-Map은 순서대로가 아니다.
    }
    System.out.println("=========================");
    Iterator<String> iter=set.iterator();
    while(iter.hasNext()){//이터레이터쓰니 hasnext사용할수있다. 자료구조 안에 값이 있는지 체크해서 있으면 트루 없으면 폴스 반환
      String key=iter.next();
      // String value=(String)mt1.rMap.get(key);//강제형전환 키가 오브젝트타입이다. 오류남
      Object value=mt1.rMap.get(key);//get은 주어진 키의 값을 리턴
      System.out.println(key+":"+value);
    }
    mt1.mapPrint();
  }
  
}
