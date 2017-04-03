

public class Producer  implements Runnable {

	java.util.concurrent.Semaphore mutex;
	java.util.concurrent.Semaphore empty;
	java.util.concurrent.Semaphore avail;
	
	
	

	public Producer(java.util.concurrent.Semaphore mutex,java.util.concurrent.Semaphore empty, java.util.concurrent.Semaphore avail) {
		// TODO Auto-generated constructor stub
			this.mutex=mutex;
			this.empty=empty;
			this.avail=avail;
		}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try
			{
		empty.acquire();
		mutex.acquire();
		produce(i);
		Thread.sleep(300);

		mutex.release();
		avail.release();
			}
			catch(Exception e)
			{
				
			}
		}
		
	}
	public void produce(int i){
		System.out.println("Producing......"+i);
		
		
		return ;
	}

}
