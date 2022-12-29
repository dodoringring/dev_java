package dev_java.oracle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeptVO {
  int deptno;
  String dname;
  String loc;

  
}
