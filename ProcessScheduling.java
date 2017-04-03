import java.util.Scanner;


public class ProcessScheduling {

	/**
	 * @param argslength
	 */
	static Process [] proc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter options 1. FCFS 2.SJf no-pre 3.sjf pre 4. round robin");
		int choice=sc.nextInt();
		if(choice==1)
		{
			fcfs();
		}
		if(choice==2)
		{
			sjfnon();
		}
		if(choice==3)
		{
			sjfpre();
		}
		if(choice==4)
		{
			round();
		}
		
	}
	
	private static void round() {
		System.out.println("enter no of processes");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		 proc=new Process[n];
		 System.out.println("Enter quantum time");
		 int time=sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter arrival time and burst time");
			
			proc[i]=new Process(sc.nextInt(), sc.nextInt(),i+1);
		}
		int tot=0;
		int [] burst=new int[n];
		for (int i = 0; i < n; i++) {
			tot+=proc[i].burst;
			burst[i]=proc[i].burst;
		}

		int current=0;
		int turn=0;
		int array []=new int[tot];
		for (int i = 0; i < array.length; i++) {
			array[i]=7;
		}
		while(current<tot)
		{
			while(true)
			{
				if(proc[turn].arrival<=current && burst[turn]>0)
				{
					break;
				}
				else
				{
					turn++;
					turn=turn%n;
				}
			}
			int add;
			if (burst[turn]>time) {
				add=time;
			}
			else
			{
				add=burst[turn];
			}
			//System.out.print(turn +","+current+"."+add+" ");
			
			for (int j = 0; j < add; j++) {
				array[j+current]=turn;
			}
			current+=add;
			burst[turn]-=add;
			if(burst[turn]==0)
			{
				proc[turn].turnaround=current-proc[turn].arrival;
			}
			
			turn++;
			turn=turn%n;
		}
		System.out.println();
		for (int i = 0; i < tot; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			proc[i].waiting=proc[i].turnaround-proc[i].burst;
		}
		System.out.println("PROCESS \t ARRIVAL \t BURST \t TURNAROUND \t WAITING ");
	
		for (int i = 0; i < n; i++) {
			
			System.out.println(proc[i].no+"\t \t"+proc[i].arrival+"\t \t"+proc[i].burst+
					"\t \t"+proc[i].turnaround+"\t \t"+proc[i].waiting
					);
	}
		
		
	}
	
	public static void sjfpre() {
		System.out.println("enter no of processes");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		 proc=new Process[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter arrival time and burst time");
			
			proc[i]=new Process(sc.nextInt(), sc.nextInt(),i+1);
		}
		int tot=0;
		for (int i = 0; i < n; i++) {
			tot+=proc[i].burst;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-1; j++) {
				if(proc[j].burst>proc[j+1].burst)
				{
					Process temp;
					temp=proc[j];
					proc[j]=proc[j+1];
					proc[j+1]=temp;
				}
			}
		}
		int [] array=new int[tot];
		int [] burst=new int[n];
		for (int i = 0; i < n; i++) {
			burst[i]=proc[i].burst;
		}
		for (int i = 0; i < tot; i++) {
			int j;
			for (j = 0; j < n; j++) {
				if(proc[j].burst>0 && proc[j].arrival<=i)
				break;
			}
			if(j==n)
			{
				
				array[j]=-1;
				continue;
			}
			array[i]=proc[j].no;
			proc[j].burst=proc[j].burst-1;
			if(proc[j].burst==0)
				proc[j].turnaround=i+1-proc[j].arrival;
			
			
		}
		for (int i = 0; i < n; i++) {
			proc[i].waiting=proc[i].turnaround-burst[i];
			
		}
		System.out.println("Process chart :");
		for (int i = 0; i < tot; i++) {
			System.out.print(array[i] +".");
		}
		System.out.println();
		
		System.out.println("PROCESS \t ARRIVAL \t BURST \t TURNAROUND \t WAITING ");
		
		for (int i = 0; i < n; i++) {
			System.out.println(proc[i].no+"\t \t"+proc[i].arrival+"\t \t"+burst[i]+
					"\t \t"+proc[i].turnaround+"\t \t"+proc[i].waiting
					);
	}
	}
	
	public static void sjfnon()
	{
		System.out.println("enter no of processes");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		 proc=new Process[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter arrival time and burst time");
			
			proc[i]=new Process(sc.nextInt(), sc.nextInt(),i+1);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-1; j++) {
				if(proc[j].burst>proc[j+1].burst)
				{
					Process temp;
					temp=proc[j];
					proc[j]=proc[j+1];
					proc[j+1]=temp;
				}
			}
		}
		int current=0;
		int order[]=new int[n];
		int done[]=new int[n];
		for (int i = 0; i <n ; i++) {
			int j;
			for (j = 0; j < n; j++) {
				if(done[j]!=1 && proc[j].arrival<=current)
					break;
			}
			order[i]=j;
			done[j]=1;
			proc[j].waiting=current-proc[j].arrival;
			proc[j].turnaround=proc[j].waiting+proc[j].burst;
			current+=proc[j].burst;
		}
		System.out.println("PROCESS \t ARRIVAL \t BURST \t TURNAROUND \t WAITING ");
		int naa=proc.length;
		for (int i = 0; i < naa; i++) {
			int no=order[i];
			System.out.println(proc[no].no+"\t \t"+proc[no].arrival+"\t \t"+proc[no].burst+
					"\t \t"+proc[no].turnaround+"\t \t"+proc[no].waiting
					);
	}
		
	}
	
	public static void printa(Process [] a)
	{
		System.out.println("PROCESS \t ARRIVAL \t BURST \t TURNAROUND \t WAITING ");
		int n=a.length;
		for (int i = 0; i < n; i++) {
			System.out.println(proc[i].no+"\t \t"+proc[i].arrival+"\t \t"+proc[i].burst+
					"\t \t"+proc[i].turnaround+"\t \t"+proc[i].waiting
					);
	}
	}
	public static void fcfs()
	{
		System.out.println("enter no of processes");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		 proc=new Process[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter arrival time and burst time");
			proc[i]=new Process(sc.nextInt(), sc.nextInt(),i+1);
		}
		int current=0;
		for (int i = 0; i <n ; i++) {
			proc[i].waiting=current-proc[i].arrival;
			proc[i].turnaround=proc[i].waiting+proc[i].burst;
			current+=proc[i].burst;
		}
		printa(proc);
		
		}
	}


