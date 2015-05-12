package Offer;

public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * 饿汉式，一创建对象就初始化
 */
class Singleton1{
	private static final Singleton1 instance = new Singleton1();
	private Singleton1(){}//将构造函数私有化

	//提供外部访问的接口
	public static Singleton1 getInstance(){
		return instance;
	}
}

/*
 * 懒汉式，对象在方法被调用时才创建，也叫做对象的延迟加载
 */
class Singleton2{
	private Singleton2(){}
	private static Singleton2 instance = null;
	
	public static Singleton2 getInstance(){
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	}
}

/*
 *	上面这种懒汉式的会出现安全问题，多线程访问的时候，会创建多个实例，
 *	以下，为改进,加锁 
 */

class Singleton3{
	private Singleton3(){}
	private static Singleton3 instance = null;
	public static Singleton3 getInstance(){
		if(instance == null){//先判断一次，提高效率
			synchronized (Singleton3.class) {//再次判断的时候，加锁
				if(instance == null){
					instance = new Singleton3();
				}
				
			}
		}
		return instance;
	}
}
