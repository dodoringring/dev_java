package dev_java.ch03;
//2차 배열->List<Map<>>제네릭->웹개발, 앱개발(하이브리드앱)-JSON

public class TwoArray1 {
  void toWhile(int[][]arr){//배열은 변수 앞이든 뒤이든 상관이 없다
    System.out.println("========[[while문으로]]===========");
    int i =0;
    while(i<arr.length){
      int j=0;
    while(i<arr[i].length){
      System.out.println("arr["+i+"]["+j+"]="+arr[i][j]);
      j++;
    }//end of inner while
  }//end if outter while
}

  public static void main(String[] args) {
    int arr[][]=new int [2][3];
    for(int i=0;i<arr.length;i++){//로우
      for(int j=0;j<arr[i].length;j++){//컬럼 [i]는 2차배열에서 값이 아니라 주소번지이다. 컬럼의 갯수를 뜻한다.
        System.out.println("arr["+i+"]["+j+"]+"+arr[i][j]);
      }
    }
    TwoArray1 ta = new TwoArray1();
    ta.toWhile(arr);
  }
  
}
