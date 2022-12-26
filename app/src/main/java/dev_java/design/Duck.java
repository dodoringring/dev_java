package dev_java.design;
//추상 클래스
//단독으로 인스턴스 화 할 수 없다. 반드시 구현체 클래스 있어야함
//인터페이스가 추상 클래스보다 더 추상적이다.-생성자 일반 메소드도 갖음-> 그러니까 덜 추상적임
//생성자는 전변의 디폴트값을 결정 할 수 있으니까...
		
public abstract class Duck {	//추상
	FlyBehavior flyBehavior;	//인터페이스-날다, 날지못한다.
	QuackBehavior quackBehavior;	//인터페이스-MuteQuack무음(나무), 삐익(고무오리)Squeak, 청둥(꽥꽥)Quack 기능이 다르다. 다형성
	public Duck(){}	//생성자
	public abstract void display();	
	public void performFly(){	
    //FlyWithWings.java, FlyNoWay.java
		flyBehavior.fly();//추상메소드이다. 오버라이드가 필요하다.->구현체 클래스가 필요하다.
	}	
	public void performQuack(){	
		quackBehavior.quack();
	}	
	public void swimming(){	
		System.out.println("모든 오리는 물위에 뜬다");
	}   	
}		
		