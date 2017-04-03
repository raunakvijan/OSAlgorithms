import java.util.Scanner;
import java.util.Stack;


public class dijktras {

	static int [] parent;
	static int [] dist;
	static int [] found;
	static int [] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		int n=9;
		parent=new int[9];
		dist=new int[9];
		found=new int[9];
		parent[0]=-1;

		for (int i = 0; i < n; i++) {
			dist[i]=1000000;
			
		}
		int source=0;
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
               };
		dist[source]=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <n; j++) {
				if(graph[i][j]==0)
				graph[i][j]=1000000;
			}
		}
		
		dijktras.dijkstra(graph,source,n);
		for (int i = 0; i < n; i++) {
			System.out.println("dist of "+i+" from source "+source+" is "+dist[i]);
		}
		
		for (int i = 0; i < n; i++) {
			
			System.out.print(" \n shortest path to "+i+" is:");
			par(i);
		}

	}
	public static void par(int i) {
		if(i!=-1)
		par(parent[i]);
		if(i!=-1)
		System.out.print(i);
		
	}
	public static void  dijkstra(int [][] graph,int source,int n) {
		int flag=1;
		int current=source;

		while(flag!=0)
		{
			
			flag=0;
		for (int i = 0; i < n; i++) {
			if(found[i]==0)
				flag=1;
		}
		if(flag==1)
		{
			
		found[current]=1;
		
		int min=0;
		
		for (int i = 0; i < n; i++) {
			if(found[min]!=0)
				min=i;
		}
		for (int i = 1; i < n; i++) {
			if(dist[i]>dist[current]+graph[current][i])
			{
				
				dist[i]=dist[current]+graph[current][i];
				parent[i]=current;
			}
			
			
		}
		current=findmin(graph,n);
		
		}
			}
	}
	public static int findmin(int[][] graph,int n) {
		int min=1000000;
		int minin = -1;
		for (int i = 0; i < n; i++) {
			if(dist[i]<min && found[i]!=1)
			{
				min=dist[i];
				minin=i;
			}
		}
		return minin;
	}

}
