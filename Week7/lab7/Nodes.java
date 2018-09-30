package lab7;

import java.util.ArrayList;

public class Nodes {
	ArrayList<Nodes> outer = new ArrayList<>();
	String name;
	
	Nodes()
	{
		
	}
	Nodes(String name)
	{
		this.name= name;
	}
	
	public void addout(Nodes outer)
	{
		this.outer.add(outer);
	}
	
	public String toString()
	{
		return "THIS: [" + this.name+"]";
	}
	
	
}
