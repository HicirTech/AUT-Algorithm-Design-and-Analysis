package Lab;

import java.util.*;

import org.omg.PortableServer.AdapterActivator;


public class Prim {

	public static void main(String[] args) {
	
		
		ArrayList<Node> Nodes = new ArrayList<>();
		Node a  = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		Node i = new Node("i");
		
		a.addOut(b, 2);
		a.addOut(c, 4);
		a.addOut(d, 6);
		b.addOut(a, 2);
		b.addOut(c, 5);
		c.addOut(b, 5);
		c.addOut(a, 4);
		c.addOut(d,1);
		c.addOut(e, 2);
		d.addOut(c, 1);
		d.addOut(a,6);
		d.addOut(h, 4);
		d.addOut(f, 3);
		h.addOut(d, 4);
		e.addOut(c, 2);
		e.addOut(f,1);
		e.addOut(g, 5);
		e.addOut(i, 3);
		i.addOut(e, 3);
		g.addOut(e, 5);
		g.addOut(f, 4);
		f.addOut(d, 3);
		f.addOut(e, 1);
		f.addOut(g, 4);
		
		Nodes.add(a);
		Nodes.add(b);
		Nodes.add(c);
		Nodes.add(d);
		Nodes.add(e);
		Nodes.add(f);
		Nodes.add(g);
		Nodes.add(h);
		Nodes.add(i);
		Long start = System.nanoTime();
		ArrayList<Node> known = new ArrayList<>();
		ArrayList<Node> pre = new ArrayList<>();
		PriorityQueue<Node> P = new PriorityQueue<>();
		a.value=0;
		P.add(a);
		
		for(int id = 0; id!=  Nodes.size();id++)
		{
			if(!Nodes.get(id).name.equals("a"))
			{
				Nodes.get(id).value=Integer.MAX_VALUE;
				P.add(Nodes.get(id));
			}
		}
		
		//System.out.println(P);
		while(P.isEmpty()==false)
		{
			
			PriorityQueue<Node> Q = new PriorityQueue<>();
			while(!P.isEmpty())
			{
				Q.add(P.poll());
			}
			P=Q;
			
			Node u = P.poll();
			known.add(u);
			
			for(Node v : u.outer)
			{
				if(!known.contains(v))
				{
					if(v.weight.get(u)<=v.value)
					{
						v.value=v.weight.get(u);
					}
				}
			}

		}
		System.out.println(known);
	
		System.out.println("Takse: "+(System.nanoTime()-start)+" Nano-second");
		
	
	}


	
}
