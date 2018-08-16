
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Nodes{

	///ArrayList<ArrayList<nodes<T>>> outNeighours= new ArrayList<>();//element 0 is node 2 is weight
	ArrayList<Nodes> out = new ArrayList<>();
	HashMap <Nodes,Integer> checkweight  = new HashMap<>();
	boolean isVisited;
	Nodes in = null;
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
		this.checkweight.put(out, weight);
	}
	void addOut(Nodes out)
	{
		this.out.add(out);
	}
	public String toString()
	{
		return this.name;
	}

}
