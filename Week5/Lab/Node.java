package Lab;

import java.util.ArrayList;
import java.util.HashMap;
public class Node implements Comparable<Node>{

	ArrayList<Node> outer;
	HashMap<Node,Integer> weight;
	String name;
	int value;
	Node(String name)
	{
		this();
		this.name=name;
	}
	Node()
	{
		this.outer=new ArrayList<>();
		weight = new HashMap<>();
		this.value=-1;
	}
	
	public void addOut(Node o,int weight)
	{
		this.outer.add(o);
		this.weight.put(o,weight);
	}
	public String toString()
	{
		return this.name;//+" Dist:"+this.value;
	}
	
	public String read()
	{
		String re=this.name+": ";
		re+=weight.toString();
		return re;
	}
	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return this.value-arg0.value;
	}
	
}
