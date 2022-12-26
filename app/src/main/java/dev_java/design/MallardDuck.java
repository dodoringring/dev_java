package dev_java.design;

			
public class MallardDuck extends Duck{			
	public MallardDuck() {		
    //게으른 인스턴스화(ApplicationContext)<->이른 인스턴스화(BeanFactory)->스프링 수업, 전자정부 프레임 워크
		quackBehavior = new Quack();	
		flyBehavior = new FlyWithWings();	//아~ 날고있겠네
	}		
	public void display(){		
		System.out.println("저는 물오리입니다.");	
	}		
}			
			