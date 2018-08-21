package Question_4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author Luo Zeting ID:16938158
 *
 */
public class BFS {
	
	Queue<Nodes> order; 
	int lable=0;
	BFS()
	{
		order= new LinkedList<>();
	}
	
	boolean run(Nodes in)
	{
		in.lable=0;
		this.order.add(in);
		return doBFS();
	}
	
	boolean doBFS()
	{
		Nodes current = this.order.poll();
		current.isVisited=true;
		ArrayList<Nodes> outer =current.out;
		
		for(Nodes e: outer) 
		{
			if(!e.isVisited)
			{
				if(this.order.contains(e))
				{
					continue;
				}

				if(current.lable==1)
				{
					this.lable=0;
				}
				else
				{
					this.lable=1;
				}
				e.lable=this.lable;
				for(Nodes checkOut : e.out)
				{
					if(checkOut.lable==e.lable)
					{
						System.out.println("Odd cycle Found!!!");
						return true;
					}
				}
				this.order.add(e);
			}
		}
		
		if(!this.order.isEmpty())
		{
			this.doBFS();
		}
		return false;
	}
}
