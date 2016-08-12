package thread.base;

public class RunTask implements Runnable{

	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("子线程还活着"+i);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==8){
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
