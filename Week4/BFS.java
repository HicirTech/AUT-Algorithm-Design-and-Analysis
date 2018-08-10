import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	static Queue<Nodes> order = new LinkedList<>();
	
	public static void main (String[] args)
	{
		 Nodes a = new Nodes("a");
		 Nodes b = new Nodes("b");
		 Nodes c = new Nodes("c");
		 Nodes d = new Nodes("d");
		 Nodes e = new Nodes("e");
	//	 Nodes f = new Nodes("f");
		 a.addOut(b, 1);
		 a.addOut(c, 2);
		 b.addOut(d, 3);
		 c.addOut(d, 4);
		 c.addOut(e, 5);
		 run(a);
	}
	
	static void run(Nodes in)
	{
		order.add(in);
		BFS();
	}
	
	static void BFS()
	{
		Nodes current = order.poll();
		System.out.println("work: " +current);
		current.isVisited=true;
		ArrayList<Nodes> outer =  (ArrayList<Nodes>) current.out.clone();
		for(Nodes e: outer)
		{
			if(e.isVisited==false)
			{
				if(order.contains(e))
				{
					continue;
				}
				order.add(e);
			}
		}
		if(!order.isEmpty())
		{
			BFS();
		}
	}
	

}
