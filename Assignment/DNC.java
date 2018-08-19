import java.util.Arrays;

public class DNC {

	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
	int[] Divide(int totalArray[], int startIndex, int middle, int endIndex)
    {
 
    	//this will make two arrays to store first half and secend
        int S1[] = new int [ middle - startIndex + 1];//S1 is array with size of first half of the total array
        int S2[] = new int [endIndex - middle];//S2 is array with size of half of the total array
        
        //copy element in array into breaked dowm array
        for (int index=0; index!=S1.length; ++index)
        {
            S1[index] = totalArray[startIndex + index];
        }        
        for (int index=0; index!=S2.length; ++index)
        {
            S2[index] = totalArray[middle + 1+ index];
        }
       	
       	return merge(S1,S2);
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
 
    // Main function that sorts arr[l..r] using
    // merge()
    int[] DivideAndConquer(int arr[], int startIndex, int maxIndex)
    {
       if (startIndex < maxIndex)
        {
        	int middle = (startIndex+maxIndex)/2;// Find the middle point
        	this.DivideAndConquer(arr, startIndex, middle);  //Sort first 
        	this.DivideAndConquer(arr , middle+1, maxIndex);//Sort second halves          	
            return this.Divide(arr, startIndex, middle, maxIndex);// Merge the sorted halves
        
        }
       return null;
       
       
    }
 
    public void doDNC(int[][] input)
    {
    	int [] totalArray = new int[input.length*input[0].length];
    	int totalIndex = 0;
    	for(int index=0;index!=input.length;index++)
    	{
    		for(int inter=0;inter!=input[index].length;inter++)
    		{
    			totalArray[totalIndex]=input[index][inter];
    			totalIndex++;
    		}
    	}
    	totalArray = this.DivideAndConquer(totalArray, 0, totalArray.length-1);
    	this.printArray(totalArray);
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
   
}
