package Lab2;

public class Karatsuba {

	Karatsuba()
	{
		
	}	
	
	public String multiply(int x, int y)
	{
		return new Integer(inmultiply(x,y)).toString();
	}
	
	private int inmultiply(int x, int y)
	{
		return (intToString(x).length()==1&&intToString(y).length()==1)?(x*y):lengthNotOne(x,y);
	}
	private String intToString(int number)
	{
		return String.format("%d",number);	
	}
	private String intToBinaryString(int number)
	{
		return Integer.toBinaryString(number);
	}
	private int goCeli(int number)
	{	
		return number / 2 + ((number % 2 == 0) ? 0 : 1); 
	}
	private int lengthNotOne(int x, int y)
	{
		int a = splitNumberIntoBinary(x)[0];
		int b =  splitNumberIntoBinary(x)[1];
		int c = splitNumberIntoBinary(y)[0];
		int d =  splitNumberIntoBinary(y)[1];
		
		int p1 = inmultiply(a,c);
		int p2 = inmultiply(b,d);
		int p3 = inmultiply(a+b,c+d);
		System.out.println(intToBinaryString(p1)+"   "+p2+"   "+p3);
		p3= p3-p2-p1;
		p1|=p1<<intToString(x).length();
		p3|=p3<<goCeli(intToString(x).length());
		System.out.println(intToBinaryString(p3));
		return p1+p2+p3;
	}
	
	public  int[] splitNumberIntoBinary(int number)
	{
	
		String target =String.format("%d", number);
		
		int targetIndex = goCeli(target.length());
		
		String breakFirstHalf = target.substring(0, targetIndex);
		String breakSecondHalf =  target.substring(targetIndex);
		
		System.out.println(breakFirstHalf + "    " +breakSecondHalf);
		int [] resultArray = new int[2] ;
		resultArray [0]=  Integer.parseInt(breakFirstHalf, 2);
		resultArray [1]=  Integer.parseInt(breakSecondHalf, 2);
		
		return resultArray;		
	}
}
