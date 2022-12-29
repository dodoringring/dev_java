package dev_java.oracle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {
  Map <String, Object> rMap=new HashMap<>();//rMap.size()=0
  public void setMap(){
    rMap.put("deptno",10);
    rMap.put("dname","인사부");
    rMap.put("loc","뉴욕");
    rMap.put("loc","부산");//새로 덮어쓰기 된다. 키는 바뀌지 않는거라서.
  }
  public static void main(String[] args) {
    MapTest1 mt1=new MapTest1();
    mt1.setMap();//이렇게 안해도 되는것은 콜백 메소드뿐이다.
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
    
  }
  
}
