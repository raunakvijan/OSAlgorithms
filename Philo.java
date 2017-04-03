import java.util.concurrent.Semaphore;


public class Philo implements Runnable{
	Semaphore fork[] ;
	int no;
	public Philo(Semaphore[] fork,int n) {
		this.fork=fork;
		this.no=n;
	}

	public void run() {
		think(no);
		try {
			fork[no].acquire();
		
		fork[(no+1)%5].acquire();
		eat(no);
		Thread.sleep(300);
		System.out.println(no+" finished eating");

		fork[no].release();
		fork[(no+1)%5].release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void think(int n) {
		System.out.println(no+" is thinking");
	}
	public void eat(int n) {
		System.out.println(no+" is eating");
	}
}
