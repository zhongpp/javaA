package thread.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.thinkive.common.util.RandomUtil;

public class DoubleLockTest {

	private  Map<Object, Object> map = new ConcurrentHashMap<Object, Object>();
	
	public void test(Object key){
		Object a = map.get(key);
		if(a == null){
			synchronized (key) {
				a = map.get(key);
				if(a == null){
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					map.put(key, key);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int threadNum = 1000;
		CountDownLatch threadSignal = new CountDownLatch(threadNum);//��ʼ��countDown  
		DoubleLockTest test  = new DoubleLockTest();
		test.initMap();
		//System.out.println("map�Ĵ�С��"+map.size());
		long before = System.currentTimeMillis();
		for(int j=0;j<threadNum;j++){
			ThreadDemo demo = new ThreadDemo(test,threadSignal);
			Thread t = new Thread(demo);
			t.start();
		}
		threadSignal.await();
		long end = System.currentTimeMillis();
		//System.out.println("map�Ĵ�С��"+map.size());
		System.out.println("��ʱ��������"+(end - before));
	}

	/**
	 * ��ʼ��map 
	 */
	private void initMap() {
		for(int i=0;i<1000;i++){
			map.put(i, i);
		}
	}
	
}

class ThreadDemo implements Runnable{

	private CountDownLatch threadsSignal; 
	private DoubleLockTest test;
	
	public ThreadDemo(DoubleLockTest test,CountDownLatch threadsSignal) {
		this.test = test;
		this.threadsSignal = threadsSignal;
	}

	public void run() {
		Integer i = RandomUtil.getRandomInt(100);
		System.out.println("�߳����ƣ�"+Thread.currentThread().getName()+",�������"+i);
		test.test(i);
		threadsSignal.countDown();
	}
	
}
