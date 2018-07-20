package lab1;
import static java.lang.System.nanoTime;
import java.util.*;

public class Fibonacci {

	
	private int number;
	
	@SuppressWarnings("resource")
	Fibonacci()
	{
		System.out.println("Please input a number for Fibonacci calculation");
		this.setNumber(new Scanner(System.in).nextInt());
		System.out.println("for number "+ this.getNumber());
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void tryOne()
	{
		long start= nanoTime();
		System.out.print("Here is try 1 - Fibonacci  Number is : ");
		System.out.println(tryOne(this.getNumber()));
		System.out.println("On my computer, this use 9109515899 nano-second to calculate Fibonacci 45");
		System.out.println("On your computer it use "+(nanoTime()-start)+" nano-second\n");
	}
	
	private int tryOne(int number)
	{
		return number==0?0:number==1?1:(tryOne(number-1)+tryOne(number-2));
	}
	
	public void tryTwo()
	{
		long start= nanoTime();
		System.out.print("Here is try 2 - Fibonacci  Number is : ");
		System.out.println(tryTwo(number));
		System.out.println("On my computer, this use 64200 nano second to calculate Fibonacci 45");
		System.out.println("On your computer it use "+(nanoTime()-start)+" nano-second\n");
	}
	
	private int tryTwo(int number)
	{
		return number == 0?0:tryTwoNotZero(number);
	}
	
	private int tryTwoNotZero(int number)
	{
		int array[]= new int[number+1];
		try
		{
			array[0]=0;
			array[1]=1;
		
			for(int index =2;index<=number;index++)
			{
				array[index]=(array[index-1])+(array[index-2]);
			}
		}catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println("Index out of bounds");
		}
		return array[number];
	}
	
	public void tryThree()
	{
		long start= nanoTime();
		System.out.print("Here is try 3 - Fibonacci  Number is : ");
		System.out.println(tryThree(this.getNumber()));
		System.out.println("On my computer, this use 317200 nano second to calculate Fibonacci 45");
		System.out.println("On your computer it use "+(nanoTime()-start)+" nano-second\n");
	}
	private int tryThree(int number)
	{
		return number==0?0:number==1?1:tryThreeNotOneNotZero(number);
	}
	
	private int tryThreeNotOneNotZero(int number)
	{
		int arrayA[][] ={{0,1},{1,1}};
		int arrayB[][] = {{1,0},{0,1}};
		try {
			for(int index =0;index!=number;index++)
			{
			multMatrix(arrayB,arrayA);
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println("Index out of bounds");
		}
		return arrayB[0][1];
	}
	
	public void tryFour()
	{
		long start= nanoTime();
		System.out.print("Here is try 4: ");
		System.out.println(tryFour(this.getNumber()));
		System.out.println("On my computer, this use 927200 nano second to calculate Fibonacci 45");
		System.out.println("On your computer it use "+(nanoTime()-start)+" nano-second\n");
		System.out.println("The algorithm is wrong, try 4 will not get right answer!!!");
	}
	private int tryFour(int number)
	{
		Stack<Integer> index =findIndexOfOne(number);
		int arrayModel[][] = {{1,0},{0,1}};
		int[][] resultArray;
	
		
		int[][][] swap = new int[index.size()][2][2];
		for(int i = 0; i != swap.length;i++)
		{
			swap[i]=arrayModel;
		}
		
	
		int swapInt = 0;
		while(!index.isEmpty())
		{
			int thisTime = index.pop().intValue();
			
			for(int i=1;i<=thisTime;i++)
			{
				swap[swapInt]=matrixPowerUp(swap[swapInt]);
			}
			swapInt++;	
		}
	
		resultArray = new int[2][2];
		resultArray=returnMatrix(swap[0], swap[1]);
		for(int i = 2;i!=swap.length;i++)
		{			
			resultArray=returnMatrix(resultArray,swap[i]);
		}
		return resultArray[0][1];
		
		
	}
	
	private Stack<Integer> findIndexOfOne(int number)
	{
		String toBinary=Integer.toBinaryString(number).toString();
		System.out.println("Binary is :"+toBinary);
		System.out.print("index of 1 is : ");
		Stack<Integer> index = new Stack<Integer>();
		while(toBinary.contains("1"))
		{	
			index.add(toBinary.length()-toBinary.indexOf("1"));
			toBinary=toBinary.replaceFirst("1", "0");
		}
		System.out.println(index.toString());
		
		return index;
	}
	private void multMatrix(int[][] arrayB, int [][] arrayA) {
        int a = arrayB[0][0] * arrayA[0][0] +  arrayB[0][1] * arrayA[1][0];
        int b = arrayB[0][0] * arrayA[0][1] +  arrayB[0][1] * arrayA[1][1];
        int c = arrayB[1][0] * arrayA[0][0] +  arrayB[1][1] * arrayA[0][1];
        int d = arrayB[1][0] * arrayA[0][1] +  arrayB[1][1] * arrayA[1][1];
        arrayB[0][0] = a;
        arrayB[0][1] = b;
        arrayB[1][0] = c;
        arrayB[1][1] = d;
    }
	private int[][] returnMatrix(int[][] arrayB, int [][] arrayA) {
        int a = arrayB[0][0] * arrayA[0][0] +  arrayB[0][1] * arrayA[1][0];
        int b = arrayB[0][0] * arrayA[0][1] +  arrayB[0][1] * arrayA[1][1];
        int c = arrayB[1][0] * arrayA[0][0] +  arrayB[1][1] * arrayA[0][1];
        int d = arrayB[1][0] * arrayA[0][1] +  arrayB[1][1] * arrayA[1][1];
        int result[][] = {{a,b},{c,d}};
        return result;
    }
	private int[][] matrixPowerUp(int[][] arrayB) {
        int a = arrayB[0][0] * 0 +  arrayB[0][1] * 1;
        int b = arrayB[0][0] * 1 +  arrayB[0][1] * 1;
        int c = arrayB[1][0] * 0 +  arrayB[1][1] * 1;
        int d = arrayB[1][0] *1 +  arrayB[1][1] * 1;
        int result[][] = {{a,b},{c,d}};
        return result;
        }
}
