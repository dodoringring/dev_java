package dev_java.week2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberVaildCheck {
  @DisplayName("입력받은 값 유효성 체크하기")
  @ParameterizedTest
  @ValueSource(strings={"151","150","360"})//파라미터를 쓸때 input 사용

  void 너정수니 (String input){
    assertTrue(isNumber(input));//맞는지 틀린지 보는것
    assertTrue( 자리수체크 (input));
  }
  public static boolean 자리수체크(String s){
    boolean isOk=false;
    if(s.length()==3){
      isOk=true;
      return isOk;
    }else{
      return isOk;
    }
  }

  public static boolean isNumber(String s){
  try{
    Double.parseDouble(s); //문자를 더블로 바꾸는것=parseDouble
    return true;
    }catch(NumberFormatException e){//에러의 종류
    return false;
    }
  }
}
