package designMode.singleton;

/**
 * 
 * @author hxd
 * @Time 2017-01-20
 *
 */
public class SingletonClass {
	/**
	 * static:��̬����ָ�ڱ������������ڴ��һֱ���ڣ�ֱ�������˳��ڴ�Ż��ͷ�����ռ䣬Ҳ����ֻҪ���������У���ô����ڴ�ͻ�һֱ���� 
	 * synchronized : ��ʾ�߳�ͬ��,һ��ֻ����һ���߳̽���÷���,�����߳���Ҫ���øķ���,��Ҫ�ŶӵȺ�,���Ա�ʶ�̰߳�ȫ  
	 */
	
	/**
	 * ˫������ʽ
	 * �൱�������̰߳�ȫģʽ��������
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
	 * ��̬�ڲ���
	 * ���ַ�ʽͬ��������classloder�Ļ�������֤��ʼ��instanceʱֻ��һ���̣߳���������ģʽ��ͬ���ǣ���ϸ΢�Ĳ�𣩣�
	 * 
	 * ����ģʽ��ֻҪSingletonClass�౻װ���ˣ���ôinstance�ͻᱻʵ������û�дﵽlazy loadingЧ������
	 * �����ַ�ʽ��SingletonClass�౻װ���ˣ�instance��һ������ʼ������ΪSingletonHolder��û�б�����ʹ�ã�
	 * ֻ����ʾͨ������getInstance����ʱ���Ż���ʾװ��SingletonHolder�࣬�Ӷ�ʵ����instance��
	 * ����һ�£����ʵ����instance��������Դ�����������ӳټ��أ�
	 * ����һ���棬�Ҳ�ϣ����Singleton�����ʱ��ʵ��������Ϊ�Ҳ���ȷ��Singleton�໹�����������ĵط�������ʹ�ôӶ������أ�
	 * ��ô���ʱ��ʵ����instance��Ȼ�ǲ����ʵġ����ʱ�����ַ�ʽ��ȶ���ģʽ���Եúܺ���
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
	 * ����ģʽ
	 * ����classLoader���Ʊ����˶��̵߳�ͬ������,�����������ʱ��ʵ����,�ᵼ��ʵ������ԭ���кܶ���,
	 * �ڵ���ģʽ�л����getSingleton����,���ǲ���֤�������ķ�ʽ(���������ľ�̬����)���������,���Ǻ��ʼ��instance��Ȼû�дﵽlady loading ��Ч��
	 * ������ģʽ����:һ�����������ʱʵ����,һ�����ڵ�һ�ε��ö����ʱ�����ʵ����
	 * ClassLoader : jvm ����ػ���
	 */
	/*private static SingletonClass singletonClass = new SingletonClass();
	private SingletonClass(){
		
	}
	
	public static SingletonClass getSingleton(){
		return singletonClass;
	}*/
	
	/**
	 * ����ģʽ,�̰߳�ȫ
	 * �ڶ��߳����������Ĺ���,Ҳ�߱��ܺõ�lazy loading,����û��Ч�ʺܵ�,�ٷ�֮99������ͬ��
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
	 * ����ģʽ,�̲߳���ȫ
	 * ����д�������غ�����,���Ƕ��߳��²�����������
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
 * ö��ģʽ
 * ��Effective Java����Josh Bloch �ᳫ�ķ�ʽ���������ܱ�����߳�ͬ�����⣬���һ��ܷ�ֹ�����л����´����µĶ���
 * ���� java jdk 1.5 ֮��ż���enum ����,
 * ���������õ�
 */
/*public enum SingletonClass {
	INSTANCE;
	 public void whateverMethod() {  
	 }  
}*/