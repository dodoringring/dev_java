package dev_java.ch01;

public class PrideMain {
  public static void main(String[] args) {
   Pride myCar= new Pride();
   Pride herCar= new Pride();
   myCar= herCar;

   System.out.println(myCar==herCar); 
  }
 
  
}
