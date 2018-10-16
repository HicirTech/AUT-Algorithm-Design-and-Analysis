package Assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Spider {

	public SpiderLeg leg;
	private Set<Node> seen;// = new HashSet<>();
	private Queue<Node> BFSQueue;// = new LinkedList<>();
	private int deep;
	
	private boolean isHttps=false;
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
		
		if(currentLevel<=this.deep)
		{
			Set<String> temp = leg.getHyperlink(current.getUrl());

			System.out.println(temp);
			for(String childUrl : temp)
			{
				if(!this.checkIsInQueueOrInSet(childUrl))
				{
					
					Node toAdd = new Node(childUrl,currentLevel+1,isHttps);
					//toAdd.setMeta(leg.getMeta(toAdd.getUrl()));
					//System.out.println(toAdd);
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
			if(e.getUrl().equalsIgnoreCase(url))
			{
				inSeenOrQueue = true;
			}
		}
		for(Node e : BFSQueue)
		{
			if(e.getUrl().equalsIgnoreCase(url))
			{

				inSeenOrQueue = true;
			}
		}
		return inSeenOrQueue;
	}
	
	public void ini(String url, int deep)
	{
		if(url.toLowerCase().contains("https"))
		{
			this.isHttps=true;
		}
		Node root = new Node(url,0, isHttps);
		//this.seen.add(root);
		this.BFSQueue.add(root);
		this.deep=deep;
		
		BFS();
	}
	
}
