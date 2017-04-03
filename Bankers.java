import java.util.Scanner;


public class Bankers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noproc=5;
		int resno=3;
		int [][] max=new int[noproc][resno];
		int alloc [][]=new int [noproc][resno];
		int need [][] =new int[noproc][resno];
		int avail[] =new int[resno];
		avail[0]=1;
		avail[1]=6;
		avail[2]=2;
		max[0][0]=5;
		max[0][1]=2;
		max[0][2]=1;

		max[1][0]=3;
		max[1][1]=2;
		max[1][2]=2;
		

		max[2][0]=3;
		max[2][1]=2;
		max[2][2]=2;
		

		max[3][0]=7;
		max[3][1]=3;
		max[3][2]=1;
		

		max[4][0]=5;
		max[4][1]=0;
		max[4][2]=3;
		
		
		alloc[0][0]=3;
		alloc[0][1]=0;
		alloc[0][2]=1;

		alloc[1][0]=0;
		alloc[1][1]=2;
		alloc[1][2]=1;
		

		alloc[2][0]=2;
		alloc[2][1]=0;
		alloc[2][2]=0;
		

		alloc[3][0]=2;
		alloc[3][1]=1;
		alloc[3][2]=0;
		

		alloc[4][0]=4;
		alloc[4][1]=0;
		alloc[4][2]=2;
		
		
		for (int i = 0; i < noproc; i++) {
			for (int j = 0; j < resno; j++) {
				need[i][j]=max[i][j]-alloc[i][j];
			}
		}
		
		int noo=0;
		int found[]=new int[noproc];
		while(noo!=noproc)
		{
			int i;
			for ( i = 0; i < noproc; i++) {
				int flag=0;
				if(found[i]==1)
					continue;
				for (int j = 0; j < resno; j++) {
					if(need[i][j]>avail[j])
					{
						flag=1;
					}
				}
				if(flag==0)
				{
					break;
				}
			}
			found[i]=1;
			noo++;
			for (int j = 0; j < resno; j++) {
				avail[j]+=alloc[i][j];
				need[i][j]=0;
			}
			System.out.println("Process "+i);
			
		}
		
	}

}
