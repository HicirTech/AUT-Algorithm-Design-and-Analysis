package Lab;

import java.util.*;

public class Kruskal {

	public static void main(String[] args)
	{
		List<Edge> SortedEdges  = new ArrayList<>();
		Node a  = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		Node i = new Node("i");
		
		
		Edge ab = new Edge(a, b, 2);
		Edge ac = new Edge(a ,c ,4);
		Edge ad = new Edge(a, d, 6);
		Edge bc = new Edge(b, c, 5);
		Edge cd = new Edge(c, d, 1);
		Edge dh = new Edge(d, h, 4);
		Edge ce = new Edge(c, e, 2);
		Edge df = new Edge(d, f, 3);
		Edge ef = new Edge(e, f, 1);
		Edge eg = new Edge(e, g, 5);
		Edge fg = new Edge(f, g, 4);
		Edge ei = new Edge(e, i, 3);

		SortedEdges.add(ab);
		SortedEdges.add(ac);
		SortedEdges.add(ad);
		SortedEdges.add(bc);
		SortedEdges.add(cd);
		SortedEdges.add(dh);
		SortedEdges.add(ce);
		SortedEdges.add(df);
		SortedEdges.add(ef);
		SortedEdges.add(eg);
		SortedEdges.add(fg);
		SortedEdges.add(ei);
		Collections.sort(SortedEdges);
		
		
		List<Edge> X  = new ArrayList<>();
		DisjointSets D = new DisjointSets();
		D.MakeSet(a);
		D.MakeSet(b);
		D.MakeSet(c);
		D.MakeSet(d);
		D.MakeSet(e);
		D.MakeSet(f);
		D.MakeSet(g);
		D.MakeSet(h);
		D.MakeSet(i);
		long start = System.nanoTime();
		for(Edge x : SortedEdges)
		{
			if(D.find(x.nodeA)!=D.find(x.nodeB))
			{
				X.add(x);
				D.Union(x.nodeA, x.nodeB);
			}
		}
		
		
		
		System.out.println(X);
		System.out.println("Takes: "+(System.nanoTime()-start)+" nano-second");

		
	}
}
