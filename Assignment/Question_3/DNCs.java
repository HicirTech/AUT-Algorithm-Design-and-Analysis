package Question_3;
/**
 * @author Luo Zeting ID:16938158
 *
 */
public class DNCs {
	
   private void Divide(int arr[], int start, int middle, int end)
    {
        int firstSize = middle - start + 1;
        int secondSize = end - middle;
       
        int S1[] = new int [firstSize];
        int S2[] = new int [secondSize];
        for (int i=0; i!=firstSize; ++i)
        {
            S1[i] = arr[start + i];
        }
        for (int j=0; j!=secondSize; ++j)
        {
            S2[j] = arr[middle + 1+ j];
        }
        this.merge(arr,start,S1,S2);
    }
        
	        
	private void merge(int[] arrTarget,int startIndex,int[]S1,int[] S2)
	{
	    int i = 0;
		int j = 0;
        int k = startIndex;
        while (i < S1.length && j < S2.length)
        {
            if (S1[i] < S2[j])
            {
            	arrTarget[k++] = S1[i++];
            }
            else
            {
            	arrTarget[k++] = S2[j++];
            }
           
        }

        while (i < S1.length)
        {
        	arrTarget[k++] = S1[i++];
         
        }
 
        while (j < S2.length)
        {
        	arrTarget[k++] = S2[j++];
        }
       }
    
    

    public void doDNC(int[][] input)
    {
    	long start=System.nanoTime();
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
    	this.doDivideAndConquer(totalArray,0,totalArray.length-1);
		long ends = System.nanoTime();
	    System.out.println("DivideAndConquer took "+(ends-start)+" nano seconds to finish");
    }

    private void doDivideAndConquer(int arr[], int start, int end)
    {
    	if (start < end)
        {
            int middle = (start+end)/2;
            this.doDivideAndConquer(arr, start, middle);
            this.doDivideAndConquer(arr , middle+1, end);
            this.Divide(arr, start, middle, end);  
           // printArray(arr);
        }   
    }
    
 
    public void printArray(int arr[])
    {
    	System.out.print("Divide and conquer:");
        int n = arr.length;
        for (int i=0; i<n; ++i)
        {
            System.out.print(arr[i] + " ");
            if(i%10==0&&i!=0)
            {
            	System.out.println();
            }
        }
        System.out.println();
    }
    
   
   
}