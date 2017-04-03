import java.util.Scanner;

public class ProdCons {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter maximum size of buffer");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		java.util.concurrent.Semaphore mutex=new java.util.concurrent.Semaphore(1);
		java.util.concurrent.Semaphore empty=new java.util.concurrent.Semaphore(n);
		java.util.concurrent.Semaphore avail=new java.util.concurrent.Semaphore(n);
		avail.tryAcquire(n);
		Producer p=new Producer(mutex,empty,avail);
		Consumer c=new Consumer(mutex,empty,avail);
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		t1.start();
		t2.start();
	}

}
