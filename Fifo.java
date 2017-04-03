
import java.util.Scanner;


public class Fifo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter frame size");
		int no=sc.nextInt();
		System.out.println("Enter no of elements to insert");
		int noele=sc.nextInt();
		int head=0;
		int [] elements=new int[noele];
		int frame []=new int[no];
		int pagehit = 0;
		
		outer:
		for (int i = 0; i < noele; i++) {
			for (int j = 0; j < frame.length; j++) {
				System.out.print("|"+frame[j]+"|");
			}
			System.out.println();
			int element=sc.nextInt();
			for (int j = 0; j <no; j++) {
				if(frame[j]==element)
				{
					pagehit++;
					continue outer;
				}
			}
			
			frame[head]=element;
			head++;
			head=head%no;
			
			
			System.out.println();
			
		}
		for (int j = 0; j < frame.length; j++) {
			System.out.print("|"+frame[j]+"|");
		}
		
		System.out.println("Page hit="+pagehit+" page faults="+(noele-pagehit));
		

	}

}
