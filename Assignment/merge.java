import java.util.Arrays;

public class merge {

	int [][] input;
	merge(int[][] input)
	{
		this.input=input;
	}
	
	void merge()
	{
		int[] firstOutPut;
		for(int i=1;i<=input.length;i+=2)
		{
			try
			{
				firstOutPut=new int[this.input[i-1].length+input[i].length];
				for(int j=0;j!=input[i-1].length;j++)
				{
					firstOutPut[j]=input[i-1][j];
				}
				for(int j=0;j!=input[i].length;j++)
				{
					firstOutPut[input[i-1].length+j]=input[i][j];
				}
				System.out.println(Arrays.toString(firstOutPut));
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				
			}
			}
	}
}

