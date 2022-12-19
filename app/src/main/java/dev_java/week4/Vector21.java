package dev_java.week4;

import java.util.Arrays;
import java.util.Map;
import java.util.Vector;

public class Vector21 {
  public static void main(String[] args) {
    //2중[ outter:=Vector-size,inner:=String[]-length] for문 돌림
    //끼워넣기 가능, 수정 대한 API제공은 없다.-클라우드 기반 데이터베이스 제품 이런식....
    Vector<String[]> v=new Vector<>();
    Vector<Map<String,Object>> v3=new Vector<>();//실무사용 패턴-완결편
    String imsi[]={"10","개발부","뉴욕"};
    v.add(imsi);
    imsi=new String[]{"20","총무부","인천"};
    System.out.println(Arrays.toString(imsi));//imsi가 대체된것을 알수있음
    v.add(imsi);
     for(int x=0;x<v.size();x++){//로우의 수-2번 반복
      for(int y=0;y<imsi.length;y++){//컬럼의 수-3번 반복
        String[] r=v.get(x);
        System.out.println(r[y]+" ");
      }
      System.out.println();//줄바꿈 약속
    }
    //크기가 얼마인가요?0
    //단일 for문 처리
    Vector<String[]> v2=new Vector<>();
    
  }
  
}
