import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class DiningPhilo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Press enter to proceed");
		Scanner sc=new Scanner(System.in);
		sc.nextLine();
		sc.close();
		Philo p[]=new Philo[5];
		Semaphore fork[] =new Semaphore[5];
		for (int i = 0; i < 5; i++) {
			fork[i]=new Semaphore(1);
		
		}
		for (int i = 0; i < 5; i++) {
			p[i]=new Philo(fork,i);
		}
		Thread t[] =new Thread[5];

		for (int i = 0; i < 5; i++) {
			t[i]=new Thread(p[i]);
			t[i].start();
		}
		
		
	}

}
