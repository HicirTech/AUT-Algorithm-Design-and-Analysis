package Lab;

public class Edge implements Comparable<Edge> {
	Node nodeA;
	Node nodeB;
	int weight;
	
	Edge(String a,String b, int weight)
	{
		this.nodeA=new Node();
		nodeA.name=a;
		this.nodeB=new Node();
		nodeB.name=b;
		this.weight=weight;
	}
	Edge(){
		
	}
	
	Edge(Node nodeA,Node nodeB, int weight)
	{
		this.nodeA=nodeA;
		this.nodeB=nodeB;
		this.weight=weight;
	}
	public String toString()
	{
		return this.weight+" "+this.nodeA+" - "+this.nodeB;
	}
	public boolean hasNode(Node o)
	{
		return this.nodeA==o||this.nodeB==o;
	}
	@Override
	public int compareTo(Edge o) {
		
		return this.weight-o.weight;
	}


	
}
