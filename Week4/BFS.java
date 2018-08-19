import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	static Queue<Nodes> order = new LinkedList<>();
	static int a=0;
	public static void main (String[] args)
	{
		 Nodes n1 = new Nodes("1");
		 Nodes n2 = new Nodes("2");
		 Nodes n3 = new Nodes("3");
		 Nodes n4 = new Nodes("4");
		 Nodes n5 = new Nodes("5");
		 Nodes n6 = new Nodes("6");
		 Nodes n7 = new Nodes("7");
		 Nodes n8 = new Nodes("8");
		 Nodes n9 = new Nodes("9");
		 Nodes n10 = new Nodes("10");
		 Nodes n11 = new Nodes("11");
		 Nodes n12 = new Nodes("12");
		 Nodes n13 = new Nodes("13");
		 Nodes n14 = new Nodes("14");
		 Nodes n15= new Nodes("15");
		 Nodes n16 = new Nodes("16");
		 Nodes n17 = new Nodes("17");
		 Nodes n18 = new Nodes("18");
		 Nodes n19 = new Nodes("19");
		 Nodes n20 = new Nodes("20");
		 n1.addOut(n2);
		 n1.addOut(n3);
		 n1.addOut(n4);
		 n2.addOut(n7);
		 n2.addOut(n8);
		 n3.addOut(n4);
		 n7.addOut(n10);
		 n8.addOut(n11);
		 n8.addOut(n9);
		 n8.addOut(n4);
		 n4.addOut(n6);
		 n6.addOut(n5);
		 n9.addOut(n10);
		 n9.addOut(n5);
		 n10.addOut(n13);
		 n13.addOut(n14);
		 n13.addOut(n17);
		 n13.addOut(n12);
		 n12.addOut(n10);
		 n12.addOut(n18);
		 n18.addOut(n19);
		 n14.addOut(n16);
		 n14.addOut(n15);
		 n15.addOut(n13);
		 n17.addOut(n19);
		 n19.addOut(n20);
		 
		 
		 
		 run(n1);
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
