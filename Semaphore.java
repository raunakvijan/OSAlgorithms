
public abstract class Semaphore {
	
	public  static int free=5;
	public static int available=0;
	public static int mutex=1;
	public static int n=5;
	public static int [] buffer=new int[5];

	public synchronized void  waitt(String s) {
		if(s=="free")
		{
			while(free<=0)
			{
				
			}
			free--;
			System.out.println("free="+free);
		}
		if(s=="mutex")
		{
			while(mutex<=0)
			{
				
			}
			mutex--;
			System.out.println("mutex="+mutex);
		}
		if(s=="available")
		{
			while(available<=0)
			{
				
			}
			available--;
			System.out.println("available="+available);
		}
		
	}
	public static synchronized void signal(String s) {
		if(s=="free")
		{
			free++;
			System.out.println("free="+free);
			
		}
		if(s=="available")
		{
			available++;
			System.out.println("available="+available);
		}
		if(s=="mutex")
		{
			mutex++;
			System.out.println("mutex="+mutex);
		}
	}
}
