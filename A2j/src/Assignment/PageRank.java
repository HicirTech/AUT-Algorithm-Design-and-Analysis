package Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * this class will get a set of page from BFS, and run the page on those page
 * @author Luo Zeting ID:16938158
 *
 */
public class PageRank {

	String url;
	ArrayList<Node> nodes;
	int maxSite;
	Spider bfs;	
	int deep;
	int iteration;
	String keyword;
	boolean hasKeyWord=false;
	double [] iniVector;
	double [][] graph;
	
	/**
	 * set up page rank needed
	 * @param entry url of entry
	 * @param deep maximum depth of BFS
	 * @param maxiteration maximum iteration going to do
	 * @param maxSite maximum website number going to search
	 */
	public void setup(String entry,int deep,int maxiteration,int maxSite)
	{
		this.url=entry;
		this.maxSite=maxSite;
		this.deep=deep;
		bfs = new Spider();
		this.iteration=maxiteration;
	}	
	
	/**
	 * run bfs, and call case set to array function
	 */
	public void completeNodes()
	{
		 bfs.ini(this.url,this.deep,this.maxSite);
		 this.CastSetToArrayList();	
	}
	
	/**
	 * if user input a keyword this will run 
	 * @param keyWord the keyword will looking for
	 */
	public void setKeyWord(String keyWord)
	{
		this.keyword = keyWord;
		this.hasKeyWord=true;
	}
	
	/**
	 * this will case the result set into array
	 * because set in unordered but we can use 
	 * array to order it with index
	 * this will also call the ini funciton to set up the 
	 * vector
	 */
	public void CastSetToArrayList()
	{
		this.nodes= new ArrayList<>();
		for(Node e : bfs.getSeen())
		{
			e.compeletNodeChildSet();
			e.completeNodeName();
			e.completeInformation();
			if(this.hasKeyWord)
			{
				if(e.getKeyWord().toLowerCase().contains(keyword.toLowerCase())||e.getDesc().toLowerCase().contains(keyword.toLowerCase()))
				{
					this.nodes.add(e);
				}
			}
			else
			{
				this.nodes.add(e);
			}
			
		}
		ini();
	}	
	
	/**
	 * set up the vector and call
	 * build map, cast the relationship of
	 * websites to a matrix
	 */
	public void ini()
	{
		this.iniVector=new double[nodes.size()];
		for(int i=0;i!=nodes.size();i++)
		{
			nodes.get(i).setCurrentRank(1.0/nodes.size());
			iniVector[i]=1.0/nodes.size();
		}
		
		for(int i=0;i!=nodes.size();i++)
		{
			int inComingCounter=0;
			
			for(Node node: nodes)
			{
				for(String out : node.getChildSet())
				{
					if(out.equalsIgnoreCase(nodes.get(i).getUrl()))
					{
						inComingCounter++;
					}	
				}
			}
			nodes.get(i).setInComingNumber(inComingCounter);			
		}
		buildMap();
	}
	
	/**
	 * convert relationship to a matrix 
	 * prepare for pagerank
	 */
	public void buildMap()
	{
		int n = nodes.size();
		this.graph = new double[n][n];
		for (int i=0;i!=n;i++)
		{
			for(int j=0;j!=n;j++)
			{
				this.graph[i][j]=0;
			}
		}
		
		for (int i=0;i!=n;i++)
		{
			Node node = this.nodes.get(i);
			node.compeletNodeChildSet();
				
			ArrayList<String> childs = new ArrayList<>();
			
			for(String child : node.getChildSet())
			{
				childs.add(child);
			}
			
			for(String child:childs)
			{
				for(int k = 0;k<n;k++)
				{
					if(child.equalsIgnoreCase(nodes.get(k).getUrl()))
					{
						graph[i][k]=1;
					}
				}
			}
		}
		
		
		for(int i=0;i!=n;i++)
		{
			double d = this.getColumnTotal(i);
			
			if(d!=0)
			{
				for(int j = 0; j!=n;j++)
				{
					graph[j][i]=graph[j][i]/d;
				}
			}
			
		}
	}
	
	/**
	 * do page rank for N iteration
	 */
	public void runPageRank()
	{
		for(int i =0;i!=this.iteration;i++)
		{
			this.iniVector=vectorMaxtrix(this.iniVector,this.graph);
		}
	}
	
	/**
	 * do vector x matrix
	 * @param vector vector for process
	 * @param matrix matrix for process
	 * @return finished processed vector
	 */
	public double[] vectorMaxtrix(double[] vector,double[][] matrix)
	{
		double[] result = new double[vector.length];
		int n = vector.length;
		
		for(int i=0;i!=n;i++)
		{
			double rowsum=0;
			for(int j=0;j!=n;j++)
			{
				rowsum+=(matrix[i][j]*vector[j]);
			}
			result[i]=rowsum;
			this.nodes.get(i).setCurrentRank(rowsum);
		}
		
		return result;		
	}
	
	/**
	 * get column not 0 count
	 * @param i cloumn number
	 * @return how many row that column is not 0
	 */
	public double getColumnTotal(int i)
	{
		double count =0 ;
		for(int j = 0;j!=graph.length;j++)
		{
			if(graph[j][i]!=0)
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * print the matrix to string
	 * @return string of the matrix
	 */
	public String printMaxtrix()
	{
		String result = "";
		for (double[] j : graph)
		{
			for(double k : j)
			{
				result += String.format("%.3f ",k);
			}
			result+="\n";
		}
		return result;
		
	}	
	
	/**
	 * print the vector to string
	 * @return string of the vector
	 */
	public String printVector()
	{
		String result = "";
		for (double j : iniVector)
		{
			result += String.format("%.3f ",j);
		}
		return result;
	}
	
	
}
