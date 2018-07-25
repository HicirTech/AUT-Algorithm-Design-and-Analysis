package lab1;
import static java.lang.System.nanoTime;
import java.util.*;

/**
 * This class has 4 way to calculation Fibonacci number from 1 to 45
 * To use each method, use try*() method
 * 								* = One, Two, Three, Four 
 * @author Luo Zeting ID 16938158
 * @see https://github.com/HicirTech/AUT-ADA
 */
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
		System.out.print("Here is try 4 - Fibonacci  Number is : ");
		System.out.println(tryFour(this.getNumber()));
		System.out.println("On my computer, this use 927200 nano second to calculate Fibonacci 45");
		System.out.println("\nOn your computer it use "+(nanoTime()-start)+" nano-second\n");
	}
	private int tryFour(int number)
	{
		return number==0?0:number==1?1:tryFourNotOneNotZero(number);		
	}
	
	private int tryFourNotOneNotZero(int number)
	{
		int arrayA[][] ={{0,1},{1,1}};
		int arrayB[][] = {{1,0},{0,1}};
		
		while(number > 0)
		{
			if(number%2 ==1)
				arrayB=returnMatrix(arrayB,arrayA);
			
			arrayA = returnMatrix(arrayA,arrayA);
			number/=2;
		}
		
		return arrayB[0][1];
	}

	private void multMatrix(int[][] arrayB, int [][] arrayA) throws ArrayIndexOutOfBoundsException {
        int a = arrayB[0][0] * arrayA[0][0] +  arrayB[0][1] * arrayA[1][0];
        int b = arrayB[0][0] * arrayA[0][1] +  arrayB[0][1] * arrayA[1][1];
        int c = arrayB[1][0] * arrayA[0][0] +  arrayB[1][1] * arrayA[0][1];
        int d = arrayB[1][0] * arrayA[0][1] +  arrayB[1][1] * arrayA[1][1];
        arrayB[0][0] = a;
        arrayB[0][1] = b;
        arrayB[1][0] = c;
        arrayB[1][1] = d;
    }
	private int[][] returnMatrix(int[][] arrayB, int [][] arrayA) throws ArrayIndexOutOfBoundsException {
        int a = arrayB[0][0] * arrayA[0][0] +  arrayB[0][1] * arrayA[1][0];
        int b = arrayB[0][0] * arrayA[0][1] +  arrayB[0][1] * arrayA[1][1];
        int c = arrayB[1][0] * arrayA[0][0] +  arrayB[1][1] * arrayA[0][1];
        int d = arrayB[1][0] * arrayA[0][1] +  arrayB[1][1] * arrayA[1][1];
        int result[][] = {{a,b},{c,d}};
        return result;
    }
}
