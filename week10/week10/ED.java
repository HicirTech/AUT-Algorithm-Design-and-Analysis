package week10;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class ED {

	public int ed(String c, String d)
	{
		String a=" "+c;
		String b=" "+d;
		int m = a.length();
		int n = b.length();
		
		int[][] e =new int[m][n];
		for(int i = 0;i!=m;i++)
		{
			e[i][0]=i;
		}
		for(int j = 0;j!=n;j++)
		{
			e[0][j]=j;
		}
		//printArray(e);
		for(int i=1;i!=m;i++)
		{
			for(int j=1;j!=n;j++)
			{
				int k = a.charAt(i)==b.charAt(j)?0:1;
				ArrayList<Integer> minvalue = new ArrayList<>();
				minvalue.add(e[i-1][j]+1);
				minvalue.add(e[i][j-1]+1);
				minvalue.add(e[i-1][j-1]+k);
				Collections.sort(minvalue);
				e[i][j]=minvalue.get(0);
			}
		}
		
		printArray(e);
		return 0;
	}
	
	void printArray(int[][] input)
	{
		for(int[] e:input)
		{
			System.out.println(Arrays.toString(e));
		}
	}
}
