package Question_3;
import java.util.Random;

/**
 * 
 * @author Luo Zeting ID:16938158
 *
 */
public class run {

	public static void main(String[] args) {
		
		DNCs dnc = new DNCs();//Question 3.4
		Merge m = new Merge();
	
		int[][] Ramdon2DArray = getRamdonArray();
		m.doMarge(Ramdon2DArray);
		dnc.doDNC(Ramdon2DArray);

		System.out.println();

		for(int i=100;i<1001;i+=100)
		{
			int[][] g = assignValue(makeFixedSizeArray(i,i));
			m.doMarge(g);
			dnc.doDNC(g);
			System.out.println();
		}	
	}
	
	static int[][] makeFixedSizeArray(int x,int y)
	{
		System.out.println("[Question 3.5][make KxN array]This is a "+x+"x"+y+" array");
		return new  int[x][y];
	}
	
	
	static int[][] getRamdonArray()
	{
		return assignValue(ramdonArrays());
	}
	
	static int[][] ramdonArrays()
	{
		int x =new Random().nextInt(100)+1;
		int y =new Random().nextInt(100)+1;
		System.out.println("[Question 3.4][Random KxN array]This is a "+x+"x"+y+" array");
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
					temp[i][j]=new Random().nextInt(10000);
				}
			}
		}		
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
