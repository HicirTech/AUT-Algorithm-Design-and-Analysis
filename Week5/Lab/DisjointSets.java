package Lab;

import java.util.ArrayList;
import java.util.List;

public class DisjointSets {

	List<ArrayList<Node>> setOfEdge;// = new ArrayList<>();
	DisjointSets()
	{
		setOfEdge = new ArrayList<>();
	}
	
	public Node find(Node u)
	{
		for(List<Node> e : setOfEdge )
		{
			if(e.contains(u))
			{
				return e.get(0);
			}
		}
		return null;
	}
	
	public void Union(Node u ,Node v)
	{
		List<Node> setA = findSet(u);
		List<Node> setB = findSet(v);
		
		setA.addAll(setB);
		
		setOfEdge.remove(setB);
			
	}
	
	public void MakeSet(Node u)
	{
		ArrayList temp= new ArrayList<>();
		temp.add(u);
		this.setOfEdge.add(temp);
	}
	
	public List<Node> findSet(Node u)
	{
		for(List<Node> e : setOfEdge )
		{
			if(e.contains(u))
			{
				return e;
			}
		}
		return null;
	}
}
