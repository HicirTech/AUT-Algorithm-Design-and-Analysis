package Assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
/**
 * Spider class for question 2
 * which used a bfs, to run limited websites
 * also you can limited the depth to run
 * @author Luo Zeting ID:16938158
 *
 */
public class Spider {

	public SpiderLeg leg;
	private Set<Node> seen;
	private Queue<Node> BFSQueue;
	private int deep;
	private int maxWeb;
	private boolean isHttps;
	private int currentWebCount;
	Spider()
	{
		this.leg= new SpiderLeg();
		this.seen = new HashSet<>();
		this.currentWebCount = 0;
		this.isHttps=false;
		this.BFSQueue = new LinkedList<>();
	}
	/**
	 * the bfs runs here, it will take the current node
	 * put it child into queue(if the child is not in seen and 
	 * not in queue), and dequeue it self, put it
	 * self into a set called seen. if the queue is empty
	 * or the BFS finished the max depth level, or get max number
	 * of site, it will stop, result can be access by see the seen set
	 * all node are label with url and found level
	 */
	public void BFS()
	{
		Node current = BFSQueue.peek();
		int currentLevel = current.getLevel();
		
		if(currentLevel<=this.deep)
		{
			Set<String> temp = leg.getHyperlink(current.getUrl());
			for(String childUrl : temp)
			{
				if(!this.checkIsInQueueOrInSet(childUrl))
				{
					
					Node toAdd = new Node(childUrl,currentLevel+1,isHttps);
					BFSQueue.add(toAdd);
					this.currentWebCount++;
					
				}
			}
		//	System.out.println("Dequeue Processed: "+current+"\n");
			this.BFSQueue.remove(current);
			seen.add(current); // finished process add to seen
			if(!this.BFSQueue.isEmpty()&&this.seen.size()<this.maxWeb)
			{
				BFS();
			}
			else
			{
				System.out.println("Final seen set size: "+this.seen.size());
			}
		}
		else
		{
			System.out.println("Final seen set size: "+this.seen.size());
			return;
		}
	}
	/**
	 * let you get the seen 
	 * @return seen set as result
	 */
	public Set<Node> getSeen()
	{
		return this.seen;
	}
	
	
	/**
	 * this is helper function to check the url is in the seen
	 * or in the queue or not
	 * @param url to check
	 * @return is in the seen or queue or not
	 */
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
	
	/**
	 * entry point of the BFS, use this to setup BFS
	 * @param url going to search
	 * @param deep the deep going to be sear
	 * @param maxNumber the maxnumber of site will be search
	 */
	public void ini(String url, int deep, int maxNumber)
	{
		if(url.toLowerCase().contains("https"))
		{
			this.isHttps=true;
		}
		Node root = new Node(url,0, isHttps);
		this.maxWeb=maxNumber;
		this.BFSQueue.add(root);
		this.deep=deep;
		this.currentWebCount++;
		System.out.println("BFS is runing, please wait");
		BFS();
	}
	
	/**
	 * print the seen set element
	 */
	public void printSeenSet()
	{
		for(Node e: seen)
		{
			System.out.println(e);
		}
	}
	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Here is Question 2 test");
		System.out.println("Enter your URL   Format of your URL should be like [http/https]://[some url]/");
		String url= sc.nextLine();	
		Spider spider = new Spider();
		System.out.println("Enter the deep to search : suggested: no more than 2 (for normal website, level 2 is very deep to be search)");
		int deep = sc.nextInt();
		System.out.println("Enter the max number of website to search: suggested: no more than 20");
		int maxNumber = sc.nextInt();
		spider.ini(url, deep, maxNumber);
		spider.printSeenSet();
		
		
	}
	
}
