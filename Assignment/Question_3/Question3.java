package Question_3;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Luo Zeting ID:16938158
 *
 */
public class Question3 {

	public static void main(String[] args) {
		
		DNCs dnc = new DNCs();//Question 3.4
		Merge m = new Merge();
		
		int[][] Ramdon2DArray = getRamdonArray();
		m.doMarge(Ramdon2DArray);
		dnc.doDNC(Ramdon2DArray);
		
		System.out.println();

		for(int i=100,j=0;i<1001;i+=100,j++)
		{
			
			int[][] g = assignValue(makeFixedSizeArray(i,i));
			m.doMarge(g);
		//	System.out.println("_______________________________________________________________");
			dnc.doDNC(g);
			System.out.println();
		}	
		System.out.println("[Question 3.6] this supports my analysis!");
	}
	static void printTimeTable(int[] merge,int[] dnc)
	{
		for(int i=0,j =100;i!=merge.length;i++,j+=100)
		{
			System.out.println("for size "+j+" * "+j+"Array");
		}
	}
	
	static int[][] makeFixedSizeArray(int x,int y)
	{
		System.out.println("[Question 3.6][make KxN array]This is a "+x+"x"+y+" array");
		return new  int[x][y];
	}
	
	
	static int[][] getRamdonArray()
	{
		System.out.println("[Question 3.5] Generating K x N array");
		System.out.println("please input integer k: ");
		int k= new Scanner(System.in).nextInt();
		System.out.println("Please input integer n: ");
		int n= new Scanner(System.in).nextInt();
		return assignValue(ramdonArrays(k+1,n+1));
	}
	
	static int[][] ramdonArrays(int k, int n)
	{
		
		int x =k;
		int y =n;
		System.out.println("[Question 3.5][Random KxN array]This is a "+(x-1)+"x"+(y-1)+" array");
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
