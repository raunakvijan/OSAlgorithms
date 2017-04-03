import java.util.Scanner;


public class ProducerConsumer {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Press enter to proceed");
		Scanner sc=new Scanner(System.in);
		sc.nextLine();
		Producer p=new Producer();
		Consumer c=new Consumer();
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		t1.start();
		t2.start();
	}

	

	

}
