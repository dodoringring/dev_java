package dev_java.week4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
@AllArgsConstructor
class CarVO {
  private int speed;
  private String carColor;
  private int wheelNum;
}

public class CarVOMain_lombok{
  public static void main(String[] args) {
    // // new CarVO(50,"검정색");
    // CarVO cvo1=new CarVO();
    // CarVO cvo2=new CarVO(50,"검정색");
    // CarVO cvo3=new CarVO(50,"검정색",4);
    // CarVOMain carVOMain=new CarVOMain();
    // System.out.println(carVOMain);
    // System.out.println(cvo1);
    // System.out.println(cvo2);
    // System.out.println(cvo3);
    
    DeptVO dVo = DeptVO.builder().dname("총무부").build();
    System.out.println(dVo.getDeptno()+","+dVo.getDname()+dVo.getLoc());
  }
  
}
