
public class BinarySearch {
	public static void main(String args[]) {
		
	
	int [] a=new int[]{2,3,1,77,55,44,488,66};
	a=sort(a);
	System.out.println(binarysearch(a,0,a.length-1,66));
	}

	private static int[] sort(int[] a) {
		// TODO Auto-generated method stub
		int i=a.length;
		for (int j = 0; j <i-1; j++) {
			for (int j2 = j; j2 < i-1; j2++) {
				if(a[j2+1]<a[j2])
				{
					int temp=a[j2+1];
					a[j2+1]=a[j2];
					a[j2]=temp;
				}
			}
		}
		return a;
	}

	private static int  binarysearch(int [] a,int i, int j, int k) {
		// TODO Auto-generated method stub
		int middle=(i+j)/2;
		if(j>=i)
		{
		if(a[middle]==k)
			return middle;
		else
		{
			if(k<a[middle])
				return binarysearch(a, 0, middle-1, k);
			if(k>a[middle])
				return binarysearch(a, middle+1, j, k);
		}
		}
		return -1;
	}
}
