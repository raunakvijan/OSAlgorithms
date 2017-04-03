import java.util.Scanner;


public class Lru {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter frame size");
		int size=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(0);
		}
		for (int i = 0; i <size; i++) {
			System.out.println(sb.charAt(i));
		}
		System.out.println("enter elements to insert . Enter end to exit");
		String element=sc.next();
		int pagehit=0;
		
		while(!element.equals("end"))
		{
			int flag=0;

			for (int i = 0; i < size; i++) {
				if((sb.charAt(i)+"").equals(element))
				{
					pagehit++;
					sb.deleteCharAt(i);
					sb.append(element);
					flag=1;
				}
				
			}
			if(flag==0)
			{
			sb.deleteCharAt(0);
			sb.append(element);
			
			}
			for (int i = 0; i <size; i++) {
				System.out.println(sb.charAt(i));
			}
			element=sc.next();
			
					
		}

	}

}
