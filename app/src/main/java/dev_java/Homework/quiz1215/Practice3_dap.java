package dev_java.Homework.quiz1215;
/*
 * 연습문제 3
0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
  출력하고 그 숫자의 빈도수를 계산하여 출력하시오
원본 : 0 1 2 3 4 5 6 7 8 9
       2 5 6 8 7 8 9 0 1 1
       5
       3
       3
       7
       9
       2
       0 4 5 6 6 7 8 8 9 9
숫자 : 0 1 2 3 4 5 6 7 8 9
갯수 : 10 9 18 11 7 9 15 14 7 5 
100개를 일차배열로 초기화하기
카운트는 전역으로
100개는 지변으로
 */

public class Practice3_dap {
  int counts[]=new int[10];

  int[] intArray(int datas[], int size){
    int i=0;
    for(;i<datas.length;i++){
      datas[i]=(int)(Math.random()*10);
    }
    dataPrint(datas);
    return datas;
  }
  void dataPrint(int[] datas){
    for(int i=0; i<datas.length;i++){
      System.out.print(datas[i]);
      if(i%10==9){
        System.out.println("\n");
        }//end of if
      }//end of for
    }
  void bindo (int[] datas){
    for(int i=0;i<datas.length;i++){
      for(int j=0;j<10;j++){
        if(j==datas[i]){
          counts[j]=counts[j]+1;
        }
      }//end of inner for
    }//end of outter for

    for(int i=0;i<10;i++){
      System.out.println(counts[i]);
    }
  }///end of bindo

  void bindo_dap (int[] datas){
    for(int i=0;i<datas.length;i++){
      counts[datas[i]]++;
      }
      for(int i=0;i<10;i++){
      System.out.println(counts[i]);
      }
    }
  
  public static void main(String[] args) {
    int datas[]=new int[100];
    Practice3_dap p3=new Practice3_dap();
    p3.intArray(datas, 100);
    p3.dataPrint(datas);
    p3.bindo_dap(datas);

    
  }
}
