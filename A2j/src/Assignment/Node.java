package Assignment;

import java.util.ArrayList;

public class Node implements Comparable<Node>  {
	private String url;
	private int level;
	//private String keywords;
	private ArrayList<String> meta;
	private boolean isHttps;
	Node(String url,int level,boolean isHttps)
	{
		this.setUrl(url);
		this.setLevel(level);
		this.isHttps=isHttps;
	}
	
	
	
	public String getKeyWord() {
		String returning = "";
		try
		{
			for(String e: meta)
			{
				if(e.contains("key"))
				{
					returning=e;
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("no key found");
		}
		return returning;
	}
	public String getDesc() {
		String returning = "";
		for(String e: meta)
		{
			if(e.contains("desc"))
			{
				returning=e;
			}
		}
		return returning;
	}



	public void setMeta(ArrayList<String> meta) {
		this.meta = meta;
	}

	public String fixUrl(String url)
	{
		if(url.substring(0,2).equals("//"))
		{
			if(isHttps)
			{
				url = "https:"+url;
			}
			else
			{
				url = "http:"+url;
			}
		}
		
		if(url.substring(0,4).equalsIgnoreCase("www"))
		{
				url = "https://"+url;
		}
		return url;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = fixUrl(url);
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String toString()
	{
		return "URL: " + this.getUrl()+"\n Found in Level"+this.getLevel();
	}
	@Override
	public int hashCode() {
		return this.getUrl().toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.getUrl().toLowerCase().equals(((Node)obj).getUrl().toLowerCase());
	}

	@Override
	public int compareTo(Node arg0) {
		return this.getUrl().toLowerCase().compareTo(arg0.getUrl().toLowerCase());
	}
}
