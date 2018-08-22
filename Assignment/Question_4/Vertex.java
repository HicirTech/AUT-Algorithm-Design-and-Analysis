package Question_4;

import java.util.ArrayList;


/**
 * 
 * @author Luo Zeting ID:16938158
 *
 */

public class Vertex{

	ArrayList<Vertex> out = new ArrayList<>();
	boolean isVisited;
	int lable=-1;
	String name;
	Vertex previous=null;// only for DFS
	
	Vertex(String name)
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
	void addOut(Vertex out)
	{
		this.out.add(out);
	}
	public void printOuter()
	{
		String a=this.name+"Outer:";
		for(Vertex c : out)
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
