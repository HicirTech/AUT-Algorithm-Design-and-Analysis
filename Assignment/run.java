import java.util.Arrays;
import java.util.Random;
public class run {

	public static void main(String[] args) {
		
		DNCs b = new DNCs();
		Merge c = new Merge();
	
		int[][] f = assignValue(ramdonArrays());
		
		c.doMarge(f);
		b.doDNC(f);

		int[][] g = assignValue(makeFixedSizeArray(1000,1000));
		c.doMarge(g);
	//	System.out.println(Arrays.toString(g));
		b.doDNC(g);
	
	}
	
	static int[][] makeFixedSizeArray(int x,int y)
	{
		System.out.println("[make KxN array]This is a "+x+"x"+y+" array");
		return new  int[x][y];
	}
	
	static int[][] ramdonArrays()
	{
		int x =new Random().nextInt(10)+1;
		int y =new Random().nextInt(10)+1;
		System.out.println("[Random KxN array]This is a "+x+"x"+y+" array");
		return new int[x][y];
	}
	static int[][] assignValue(int[][] input)
	{
		int[][] temp=input;
		for(int i=0;i!=input.length;i++)
		{
			for(int j=0;j!=input[i].length;j++)
			{
				if(j!=0)
				{
					temp[i][j]=getNotSmallerRandom(temp[i][j-1]);
				}
				else
				{
					temp[i][j]=new Random().nextInt(20);
				}
			}
		}		
		System.out.println("Finished assigning");
		return temp;		
	}
	static int getNotSmallerRandom(int before)
	{
		int i=0;
		while(i<=before)
		{
			i=new Random().nextInt(20)+before;
		}
		return i;
	}

}
