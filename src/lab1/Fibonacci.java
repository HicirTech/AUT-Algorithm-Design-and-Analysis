package lab1;
import static java.lang.System.nanoTime;
import java.util.*;
//import java.util.Stack;
public class Fibonacci {

	private int number;
	
	Fibonacci(int number)
	{
		this.setNumber(number);
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
		System.out.print("Here is try 1 - Number is : ");
		System.out.println(tryOne(this.getNumber()));
		System.out.println("Use "+(nanoTime()-start)+" nano-second\n");
	}
	
	private int tryOne(int number)
	{
		return number==0?0:number==1?1:(tryOne(number-1)+tryOne(number-2));
	}
	
	public void tryTwo()
	{
		long start= nanoTime();
		System.out.print("Here is try 2 - Number is : ");
		System.out.println(tryTwo(number));
		System.out.println("Use "+(nanoTime()-start)+" nano-second\n");
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
		System.out.print("Here is try 3 - Number is : ");
		System.out.println(tryThree(this.getNumber()));
		System.out.println("Use "+(nanoTime()-start)+" nano-second\n");
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
		System.out.print("Here is try 4 - Number is : ");
		System.out.println(tryFour(this.getNumber()));
		System.out.println("Use "+(nanoTime()-start)+" nano-second\n");
	}
	//--------------------------------------------------------------------------
	private int tryFour(int number)
	{
		Stack<Integer> index =findIndexOfOne(number);
		int arrayA[][] ={{0,1},{1,1}};
		int arrayB[][] = {{1,0},{0,1}};

		while(!index.isEmpty())
		{
			int thisTime=index.pop().intValue();
			System.out.println("thistime"+thisTime);
			for(int inside =1;inside<=thisTime;inside++)
			{
				multMatrix(arrayB,arrayA);
			}
		}
		
		return  arrayB[0][1];
	}
	
	private Stack<Integer> findIndexOfOne(int number)
	{
		String toBinary=Integer.toBinaryString(number).toString();
		System.out.println(toBinary);
		Stack<Integer> index = new Stack<Integer>();
		while(toBinary.contains("1"))
		{	
			index.add(toBinary.length()-toBinary.indexOf("1"));
			toBinary=toBinary.replaceFirst("1", "0");
		}
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
}
