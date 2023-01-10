package dev_java.ch02;

public class Switch1 {

  public static void main(String[] args) {
    String bread = "도우넛";
    switch("소보로"){
      case "소보로":{
      System.out.println("소보로 빵입니다.");
      break;
      }
      case "도우넛" :{
        int protocol = 200;
        System.out.println("%s빵입니다.%d %n",bread,protocol);
        break;
      }
      default:
      System.out.println("원하는 빵이 없습니다.");
      break;
    }
  }////end of switch
  
}
