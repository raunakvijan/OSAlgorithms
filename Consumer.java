
public class Consumer  implements Runnable{
	java.util.concurrent.Semaphore mutex;
	java.util.concurrent.Semaphore empty;
	java.util.concurrent.Semaphore avail;
	public Consumer(java.util.concurrent.Semaphore mutex,java.util.concurrent.Semaphore empty, java.util.concurrent.Semaphore avail) {
		// TODO Auto-generated constructor stub
			this.mutex=mutex;
			this.empty=empty;
			this.avail=avail;
		}
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10; i++) {
			//System.out.println("1");
			try {
			avail.acquire();
			mutex.acquire();
			consume(i);
			Thread.sleep(1000);
			mutex.release();
			empty.release();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public void consume(int i) {
		System.out.println("Consuming......"+i);


		
		return;
		
	}

}
