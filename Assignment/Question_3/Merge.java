package Question_3;
/**
 * 
 * @author Luo Zeting ID:16938158
 *
 */
public class Merge {
	

	public int[] doMarge(int[][] array)
	{
		long start=System.nanoTime();
		int[] temp = array[0];
		for(int i=1;i!=array.length;i++)
		{
			temp=this.merge(array[i],temp);
		}
		
		//printArray(temp);
		long ends = System.nanoTime();
	    System.out.println("Merge took "+(ends-start)+" nano seconds to finish");
		return temp;
	}
	
	private int[] merge(int[] s1, int[] s2)
	{
		int i=0;
		int j=0;
		int k=0;
		int[] res = new int[s1.length+s2.length];
		while(i<s1.length&&j<s2.length)
		{
			if(s1[i]<s2[j])
			{
				res[k++]=s1[i++];
				
			}
			else
			{
				res[k++]=s2[j++];
				
			}
			
		}
		while(i<s1.length)
		{
			res[k++]=s1[i++];
			
		}
		while(j<s2.length)
		{
			res[k++]=s2[j++];
		}
		return res;
	}
	public void printArray(int arr[])
    {
        int n = arr.length;
        System.out.print("Merge:");
        for (int i=0; i<n; ++i)
        {
            System.out.print(arr[i] + " ");
	        if(i%10==0)
	        {
	        	System.out.println();
	        }
        }
        System.out.println();
    }
}

