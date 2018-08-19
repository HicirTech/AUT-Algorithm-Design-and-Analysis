
public class Merge {

	public int[] doMarge(int[][] array)
	{
		int[] temp = array[0];
		for(int i=1;i!=array.length;i++)
		{
			temp=this.merge(array[i],temp);
		}
		
		printArray(temp);
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
				res[k]=s1[i];
				i++;
				k++;
			}
			else
			{
				res[k]=s2[j];
				j++;
				k++;
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
	private void printArray(int arr[])
    {
        int n = arr.length;
        System.out.print("Merge:");
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

