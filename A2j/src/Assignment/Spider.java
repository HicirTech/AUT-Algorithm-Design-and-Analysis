package Assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Spider {

	public SpiderLeg leg;// 
	private Set<Node> seen;// = new HashSet<>();
	private Queue<Node> BFSQueue;// = new LinkedList<>();
	private int deep;
	Spider()
	{
		this.leg= new SpiderLeg();
		this.seen = new HashSet<>();
		this.BFSQueue = new LinkedList<>();
	}
	public void BFS()
	{
		Node current = BFSQueue.peek();
		int currentLevel = current.getLevel();
		
		//System.out.println(current);
		
		if(currentLevel<=this.deep)
		{
			Set<String> temp = leg.getHyperlink(current.getUtl());
			
			for(String childUrl : temp)
			{
				if(!this.checkIsInQueueOrInSet(childUrl))
				{
					Node toAdd = new Node(childUrl,currentLevel+1);
					//toAdd.setMeta(leg.getMeta(toAdd.getUtl()));
					BFSQueue.add(toAdd);
				}
			}
			System.out.println("Dequeue Processed: "+current+"\n"+ this.BFSQueue.remove(current));
			seen.add(current); // finished process add to seen
			if(!this.BFSQueue.isEmpty())
			{
				BFS();
			}	
		}
		else
		{
			return;
		}
	}
	public Set<Node> getSeen()
	{
		return this.seen;
	}
	public boolean checkIsInQueueOrInSet(String url)
	{
		boolean inSeenOrQueue = false;				
		for(Node e: seen)
		{
			if(e.getUtl().equalsIgnoreCase(url))
			{
				inSeenOrQueue = true;
			}
		}
		for(Node e : BFSQueue)
		{
			if(e.getUtl().equalsIgnoreCase(url))
			{

				inSeenOrQueue = true;
			}
		}
		return inSeenOrQueue;
	}
	
	public void ini(String url, int deep)
	{
		Node root = new Node(url,0);
		//this.seen.add(root);
		this.BFSQueue.add(root);
		this.deep=deep;
		BFS();
	}
	
}
