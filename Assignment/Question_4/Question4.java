package Question_4;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Luo Zeting ID:16938158
 *
 */
public class Question4 {
	public static int[][] graph;
	
	static Random rand = new Random();
	static Vertex[] nodes;
	static Vertex[] DFSnodes;
	public static void main(String args[]) {
		System.out.println("[Question 4.3] Enter n to get random graph with order of n");
		int n = new Scanner(System.in).nextInt();
		graph = new int[n][n];
		createGraph(graph);
		makeList(graph);
		DFSnodes=nodes.clone();//copy of graph
		BFSIsBipartite();
		DFSIsBipartite();
		
		System.out.println();
		for(int i=10;i<=101;i+=10)
		{
			System.out.println("[Question 4.5]now doing order "+i+" ramdon graph");
			graph = new int[i][i];		
			createGraph(graph);
			makeList(graph);
			DFSnodes=nodes.clone();//copy of graph
		
			long start=System.nanoTime();
			BFSIsBipartite();
			long ends = System.nanoTime();
			System.out.println("BFS took "+(ends-start)+" nano seconds to finish");
			start=System.nanoTime();
			DFSIsBipartite();
			ends = System.nanoTime();
			System.out.println("DFS took "+(ends-start)+" nano seconds to finish");
			System.out.println();
		}
	}
	
	static void DFSIsBipartite()
	{
		DFS dfs = new DFS();//Question 4.4, Question 4.5
		dfs.dfsUsingStack(DFSnodes);
	}
	static void BFSIsBipartite()
	{
		
		boolean isNotFound=true;
		
		BFS bfs = new BFS();//Question 4.4, Question 4.5
		for(int i=0;i!=nodes.length;i++)
		{
			if(!nodes[i].isVisited)
			{
				boolean checker = bfs.run(nodes[i]);
					
				if(checker)
				{
					System.out.println("[BFS]Is this a bipartite? : "+!checker);
					isNotFound=false;
					return;
				}
			}
		}
		
		if(isNotFound==true)
		{
			System.out.println("[BFS]Is this a bipartite? : "+isNotFound);
		}
		
	   

	}
	
	
	static void createGraph(int[][] graph) {
		for(int i = 0; i < graph.length; i++) {
			graph[i][i] = 0;
		}
		for(int i = 0; i < graph.length; i++) {
			for(int j = i + 1; j < graph.length; j++) {
				graph[i][j] = (int) (rand.nextInt(2));
				graph[j][i] = graph[i][j];
			}
		}
	}
	
	
	static ArrayList<Vertex> makeList(int[][] graph)
	{
		nodes=new Vertex[graph.length];
		for(int index= 0; index!=nodes.length;index++)
		{
			nodes[index] = new Vertex(String.format("%d",index));
		}
		
		ArrayList outside=new ArrayList();
		for(int i =0 ; i!=graph.length;i++)
		{
			ArrayList inside = new ArrayList();
			for(int j=0; j!=graph[i].length;j++)
			{
				if(graph[i][j]==1)
				{
					inside.add(j);
					nodes[i].addOut(nodes[j]);
				}
			}
			outside.add(inside);
		}
		return outside;
	}
	
}
