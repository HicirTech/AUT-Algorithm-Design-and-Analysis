package lab4;

import java.util.Arrays;

public class PriorityQueueUsingArray {

	Nodes[] array;
	int currentMaxIndex;
	PriorityQueueUsingArray(int size)
	{
		this.array= new Nodes[size];
		this.currentMaxIndex=0;
	}
	
	public void insert(int key, int value)
	{
		if(this.array.length-1==this.lastNotNull())
		{
			System.out.println("Queue Full!!!");
		}
		else
		{
			this.array[this.lastNotNull()]=new Nodes(key,value);
			Arrays.sort(this.array,0,this.lastNotNull());
		}
	}
	public int lastNotNull()
	{
		int result = 0;
		if(this.array[0]!=null)
		{
			while(this.array[result]!=null)
			{
				result++;
			}
		}
		else
		{
			return 0;
		}
		return result;
	}
	public int dequeue()
	{
		int lowPowerNodeValue=Integer.MIN_VALUE;
		try
		{
			lowPowerNodeValue=this.array[0].value;
			for(int n=1;n!=this.array.length;n++)
			{
				this.array[n-1] = this.array[n];
			}
			this.array[this.lastNotNull()]=null;
			return  lowPowerNodeValue;
		}
		catch(NullPointerException e)
		{
			System.out.println("Queue is empty, dequeue false return Integer.MIN_VALUE");
		}
		return lowPowerNodeValue;
	}
	public String toString() {
		return Arrays.toString(this.array);
	}
	
}
