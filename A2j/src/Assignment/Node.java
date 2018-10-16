package Assignment;

import java.util.ArrayList;

public class Node implements Comparable<Node>  {
	private String utl;
	private int level;
	//private String keywords;
	private ArrayList<String> meta;
	Node(String url,int level)
	{
		this.setUtl(url);
		this.setLevel(level);
	}
	
	
	
	public String getKeyWord() {
		String returning = "";
		for(String e: meta)
		{
			if(e.contains("key"))
			{
				returning=e;
			}
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
		if(url.substring(0,4).equalsIgnoreCase("www"))
		{
				url = "https:"+url;
		}
		return url;
	}
	
	public String getUtl() {
		return utl;
	}
	public void setUtl(String utl) {
		this.utl = fixUrl(utl);
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String toString()
	{
		return "URL: " + this.getUtl()+"\n Found in Level"+this.getLevel();
	}
	@Override
	public int hashCode() {
		return this.getUtl().toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.getUtl().toLowerCase().equals(((Node)obj).getUtl().toLowerCase());
	}

	@Override
	public int compareTo(Node arg0) {
		return this.getUtl().toLowerCase().compareTo(arg0.getUtl().toLowerCase());
	}
}
