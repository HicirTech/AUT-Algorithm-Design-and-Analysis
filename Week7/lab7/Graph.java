package lab7;
import java.util.ArrayList;
import java.util.Arrays;
public class Graph {
	
//	ArrayList<ArrayList<Integer>> graph;

	double[][] temp;
	double[] finalV;
	Graph()
	{
		
	}
	
	public void buildGraph(Nodes[] nodes)
	{
		this.temp = new double[nodes.length][nodes.length];
		for(int i = 0;i!=nodes.length;i++)
		{
			while(!nodes[i].outer.isEmpty())
			{
				Nodes node  = nodes[i].outer.remove(0);
				int index = 0;
				//System.out.println(node);
				while(!nodes[index].name.equals(node.name))
				{
					//System.out.println(nodes[index].toString());
					index++;
				}
				temp[i][index] = 1;
			
			}
		}
	//	printGraph();
	}
	public void printGraph()
	{
		for(int i = 0;i!=temp.length;i++)
		{
			for(int j = 0; j!= temp[i].length;j++)
			{
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void EC( double bounce)
	{
		double[][] b = temp;
		for(int i = 0,j=0;i!=b.length;i++,j++)
		{
			b[i][j]=1;
		}
		
		double [] start = new double[b.length];
		for(int e = 0;e!=start.length;e++)
		{
			start[e]=1;
		}
		//this.printGraph();

		double [] u= new double[start.length];
		double [] v =new double[start.length];
		for(int i=0;i!=b.length;i++)
		{
			u[i]=assign(b[i],start);
		}
		for(int i=0;i!=b.length;i++)
		{
			v[i]=u[i]/u[0];
		}
		
		//----

		double before = 0;
		double after = v[1];
		while(Math.abs(after - before)>bounce)
		{
			for(int i=0;i!=b.length;i++)
			{
				u[i]=assign(b[i],v);
			}
			
			for(int i=0;i!=b.length;i++)
			{
				v[i]=u[i]/u[0];
			}
			
		//	System.out.println();
			before = after;
			after = v[1];
		}	
		this.finalV=v;
		System.out.println("final:v:"+Arrays.toString(v));
	
	}
	
	public double assign(double[]x,double[]y)
	{
		double [] z = new double[y.length];
		double temp=0;
		for(int i= 0; i!=y.length;i++)
		{
			temp+=x[i]*y[i];
		}
		return temp;
	}
	
	public double getNorm(double[] v)
	{
		double temp=0;
		for(double e : v)
		{
			temp+=Math.pow(e, 2);
		}
		return Math.sqrt(temp);
	}
	public void Normalise()
	{
		System.out.print("Normalise ");
		for(double e : this.finalV)
		{
			System.out.print(+e/this.getNorm(finalV)+" ");
		}
		System.out.println();
	}
}
