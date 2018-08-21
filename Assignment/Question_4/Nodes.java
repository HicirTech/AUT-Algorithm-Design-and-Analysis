package Question_4;

import java.util.ArrayList;
/**
 * 
 * @author Luo Zeting ID:16938158
 *
 */

public class Nodes{

	ArrayList<Nodes> out = new ArrayList<>();
	boolean isVisited;
	int lable=-1;
	String name;
	Nodes()
	{
		
	}
	Nodes(String name)
	{
		this.name=name;
	}
	
	
	boolean haveOut()
	{
		return !out.isEmpty();
	}
	
	void visited()
	{
		if(!haveOut())
		{
			this.isVisited=true;
		}
	}
	void addOut(Nodes out,int weight)
	{
		this.out.add(out);
	}
	void addOut(Nodes out)
	{
		this.out.add(out);
	}
	public void printOuter()
	{
		String a=this.name+"Outer:";
		for(Nodes c : out)
		{
			a+=c.name;
		}
	}
	public String toString()
	{
		//printOuter();
		return this.name+":lable"+this.lable;
	}

}
