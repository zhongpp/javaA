package thread.base;

public class ThreadTest {
	public static void main(String[] args) {
		Thread thread = new Thread(new RunTask());
		thread.start();
		int i = 0;
		while(true){
			i++;
			try {
				Thread.sleep(1000);
				System.out.println("���̣߳����̵߳�״̬Ϊ "+thread.isAlive());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i==15){
				System.exit(0);
			}
		}
	}
}
