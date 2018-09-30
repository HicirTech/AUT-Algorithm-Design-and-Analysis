package lab7;

public class Ranable {

	public static void main(String[] args)
	{
		System.out.println("Q2.a");
		Graph a  = new Graph();
		Nodes[]nodes = new Nodes[5];
		for(int i =0; i!= nodes.length;i++)
		{
			nodes[i]=new Nodes(String.format("%c", i+65));
		}
		nodes[0].addout(nodes[1]);
		nodes[0].addout(nodes[2]);
		nodes[0].addout(nodes[3]);
		nodes[0].addout(nodes[4]);
		
		nodes[1].addout(nodes[0]);
		nodes[2].addout(nodes[0]);
		nodes[3].addout(nodes[0]);
		nodes[4].addout(nodes[0]);
		a.buildGraph(nodes);
		a.EC(0.0001);
		a.Normalise();
		System.out.println();
		
		System.out.println("Q2.b");
		Graph b  = new Graph();
		Nodes[]nodesb = new Nodes[5];
		for(int i =0; i!= nodesb.length;i++)
		{
			nodesb[i]=new Nodes(String.format("%c", i+65));
		}
		nodesb[0].addout(nodesb[1]);
		nodesb[1].addout(nodesb[0]);
		
		nodesb[1].addout(nodesb[2]);
		nodesb[2].addout(nodesb[1]);
		
		nodesb[2].addout(nodesb[3]);
		nodesb[3].addout(nodesb[2]);
		
		nodesb[3].addout(nodesb[4]);
		nodesb[4].addout(nodesb[3]);
		b.buildGraph(nodesb);
		b.EC(0.0001);
		b.Normalise();
		System.out.println();
		
		System.out.println("Q2.c");
		Graph c  = new Graph();
		Nodes[]nodesc = new Nodes[4];
		for(int i =0; i!=nodesc.length;i++)
		{
			nodesc[i]=new Nodes(String.format("%c", i+65));
		}
		nodesc[0].addout(nodesc[1]);
		nodesc[0].addout(nodesc[2]);
		nodesc[0].addout(nodesc[3]);
			
		nodesc[1].addout(nodesc[0]);
		nodesc[1].addout(nodesc[2]);
		nodesc[1].addout(nodesc[3]);
		
		nodesc[2].addout(nodesc[0]);
		nodesc[2].addout(nodesc[1]);
		nodesc[2].addout(nodesc[3]);
		
		nodesc[3].addout(nodesc[0]);
		nodesc[3].addout(nodesc[1]);
		nodesc[3].addout(nodesc[2]);
		
		c.buildGraph(nodesc);
		c.EC(0.0001);
		
		c.Normalise();
		System.out.println();
		
		
	}
}
