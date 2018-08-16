package lab4;

public class Nodes   implements Comparable<Nodes>{
	public int key;
	public int value;
	
	Nodes(int key,int value)
	{
		this.key=key;
		this.value=value;
	}
	Nodes()
	{
	}
	

	public String toString()
	{
		return  "Key["+this.key+"] Value["+this.value+"]";
	}


	@Override
	public int compareTo(Nodes arg0) {
		
		return this.key-arg0.key;
	}
}
