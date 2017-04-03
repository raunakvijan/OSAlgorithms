import java.awt.HeadlessException;
import java.util.Scanner;


public class DiskScheduling {

	/**
	 * @param args
	 */
	static Scanner sc;
	 static int [] array;
	 static int [] order;
	 static int head;
	 static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 sc=new Scanner(System.in);
		 System.out.println("Enter no of elements");
		  n=sc.nextInt();
		 array=new int[n];
		 order=new int[n];
		 for (int i = 0; i < n; i++) {
			array[i]=sc.nextInt();
		}
		 System.out.println("Enter head");
		 head=sc.nextInt();
		 System.out.println("Enter choice 1. FCFS 2. SSTF 3. SCAN 4. CSCAN");
		 int choice=sc.nextInt();
		 if(choice==1)
		 {
			 fcfs();
		 }
		 if(choice==2)
		 {
			 sstf();
		 }
		 if(choice==3)
		 {
			 scan();
		 }
		 

	}
	
	public static void scan() {
		
	}
	
	static int found[];
	public static void sstf() {
		found=new int[n];
		for (int j = 0; j < n; j++) {
			
		
		int min=Integer.MAX_VALUE;
		int index = 0;
		
		for (int  i = 0; i <n; i++) {
			if(Math.abs(array[i]-head)<min && found[i]==0)
			{
				min=Math.abs(array[i]-head);
				index=i;
				
			}
			
		}
		found[index]=1;
		head=array[index];

		
		System.out.println(array[index]+" Dist:"+min);
		for (int i = 0; i < found.length; i++) {
			System.out.print(found[i]);
		}
		System.out.println();
		}
	}
	
	public static void fcfs() {
		order=array;
		display();
	}
	
	
	public static void display() {
		for (int i = 0; i < n; i++) {
			System.out.print(order[i]);
			int dist=Math.abs(order[i]-head);
			System.out.println(" Dist:"+dist);
			head=order[i];
		}
		
	}
	
	

}
