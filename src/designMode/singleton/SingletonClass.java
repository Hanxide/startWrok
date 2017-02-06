package designMode.singleton;

/**
 * 
 * @author hxd
 * @Time 2017-01-20
 *
 */
public class SingletonClass {
	/**
	 * static:静态就是指在编译后所分配的内存会一直存在，直到程序退出内存才会释放这个空间，也就是只要程序在运行，那么这块内存就会一直存在 
	 * synchronized : 表示线程同步,一次只能有一个线程进入该方法,其他线程想要调用改方法,需要排队等候,可以标识线程安全  
	 */
	
	/**
	 * 双重锁形式
	 * 相当于懒汉线程安全模式的升级版
	 */
	private volatile static SingletonClass singletonClass;
	private SingletonClass(){
		
	}
	public static synchronized SingletonClass getSingleton(){
		if(singletonClass == null){
			synchronized (SingletonClass.class){
				if(singletonClass == null){
					singletonClass = new SingletonClass();
				}
			}
		}
		return singletonClass;
	}
	
	/**
	 * 静态内部类
	 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，它跟饿汉模式不同的是（很细微的差别）：
	 * 
	 * 饿汉模式是只要SingletonClass类被装载了，那么instance就会被实例化（没有达到lazy loading效果），
	 * 而这种方式是SingletonClass类被装载了，instance不一定被初始化。因为SingletonHolder类没有被主动使用，
	 * 只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance。
	 * 想象一下，如果实例化instance很消耗资源，我想让他延迟加载，
	 * 另外一方面，我不希望在Singleton类加载时就实例化，因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，
	 * 那么这个时候实例化instance显然是不合适的。这个时候，这种方式相比饿汉模式就显得很合理
	 */
/*	private static class SingletonHoder {
		private static final SingletonClass SINGLETON = new SingletonClass();
	}
	private SingletonClass(){
		
	}
	public static SingletonClass getSingleton(){
		return SingletonHoder.SINGLETON;
	}*/
	
	/**
	 * 饿汉模式
	 * 基于classLoader机制避免了多线程的同步问题,但是在类加载时就实例化,会导致实例化的原因有很多种,
	 * 在单例模式中会调用getSingleton方法,但是不保证有其他的方式(或者其他的静态方法)导致类加载,这是后初始化instance显然没有达到lady loading 的效果
	 * 与懒汉模式区别:一个是在类加载时实例化,一个是在第一次调用对象的时候进行实例化
	 * ClassLoader : jvm 类加载机制
	 */
	/*private static SingletonClass singletonClass = new SingletonClass();
	private SingletonClass(){
		
	}
	
	public static SingletonClass getSingleton(){
		return singletonClass;
	}*/
	
	/**
	 * 懒汉模式,线程安全
	 * 在多线程下能正常的工作,也具备很好的lazy loading,但是没有效率很低,百分之99都不用同步
	 * 
	 */
/*	private static SingletonClass singletonClass;
	private SingletonClass(){
		
	};
	public static synchronized SingletonClass getSingleton(){
		if(singletonClass == null){
			singletonClass = new SingletonClass();
		}
		return singletonClass;
	}*/
	
	/**
	 * 懒汉模式,线程不安全
	 * 这种写法懒加载很明显,但是多线程下不能正常工作
	 */
	/*private static  SingletonClass singletonClass;
	
	private SingletonClass(){
		
	};
	
	public static  SingletonClass getSingleton(){
		if(singletonClass == null){
			singletonClass = new SingletonClass();
		}
		return singletonClass;
	}*/
}

/**
 * 
 * @author HXD
 * 枚举模式
 * 是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 * 不过 java jdk 1.5 之后才加入enum 特性,
 * 很少有人用到
 */
/*public enum SingletonClass {
	INSTANCE;
	 public void whateverMethod() {  
	 }  
}*/