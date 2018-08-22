package Question_4;

import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Luo Zeting ID:16938158
 *
 */
public class DFS {

	
	public static void dfsUsingStack(Vertex[] nodes)
	{
		Vertex node=nodes[0];
		Stack<Vertex> stack=new  Stack<Vertex>();
		node.lable=0;
		stack.add(node);
		node.isVisited=false;
		
		while (!stack.isEmpty())
		{
			Vertex element=stack.pop();
			List<Vertex> neighbours=element.out;
			for (int i = 0; i < neighbours.size(); i++) {
				Vertex n=neighbours.get(i);
				if(n!=null && !n.isVisited)
				{
					if(element.lable==0)
					{
						n.lable=1;
					}
					else if(element.lable==1)
					{
						n.lable=0;
					}
					
					stack.add(n); 
					n.isVisited=true; 
				}
			}
			
		}
		boolean isCycle=false;
		for(Vertex checkout: nodes)
		{
			for(Vertex out:checkout.out)
			{
				if(out.lable==checkout.lable)
				{
					System.out.println("[DFS]Odd cycle Found!!!");
					isCycle=true;
					System.out.println("[DFS]Is this a bipartite? : "+!isCycle);
					return;
				}
				
			}
		}
		if(isCycle==false)
		{
			System.out.println("[DFS]Is this a bipartite? : "+!isCycle);
		}
		
	}
}
