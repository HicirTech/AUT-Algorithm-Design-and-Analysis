package week10;
import java.util.Arrays;
public class LIS {
	
	public int longest(int[] a)
	{
		int[] L = new int[a.length];
		for(int i =0 ;i!=a.length;i++)
		{
			L[i]=1;
		}
		
		for(int i =1;i<a.length;i++)
		{
			for(int j = 0;j<i;j++)
			{
				if(a[j]<a[i])
				{
					L[i]=Integer.max(L[i],L[j]+1);
					System.out.println("process List"+Arrays.toString(L));
				}
			}
		}
		System.out.println("print List"+Arrays.toString(L));
		Arrays.sort(L);
		return L[L.length-1];
	}
}
