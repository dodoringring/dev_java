package dev_java.week4;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeptVO {
  int deptno;
  String dname;
  String loc;

  
}
