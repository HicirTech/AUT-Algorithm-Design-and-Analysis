package Assignment;

import java.util.ArrayList;
import java.util.Set;

/**
 * this is a node class used for BFS and pagerank
 * this is for ada assignment 2 question 2,3,4
 * @author Luo Zeting ID:16938158
 *
 */
public class Node implements Comparable<Node>  {
	private String url;
	private String name;
	private int level;
	private ArrayList<String> meta;
	private boolean isHttps;
	private String keyforDisplay;
	private String descForDisplay;
	private Set<String> childSet;
	private SpiderLeg leg;
	private int inComingNumber;
	private Double currentRank;
	Node(String url,int level,boolean isHttps)
	{
		this.setUrl(url);
		this.setLevel(level);
		this.isHttps=isHttps;
		this.keyforDisplay="";
		this.descForDisplay="";
		this.leg=new SpiderLeg();
	}
	
	/**
	 * after Other has set, this method will 
	 * compete information of this class
	 */
	public void completeInformation()
	{
		this.setMeta(leg.getMeta(this.url));
		this.name=leg.getTitle(this.url);
		this.childSet=leg.getHyperlink(this.url);
	}
		
	
	/**
	 * when meta set, key and desc will be set at
	 * the same time
	 * @param mateSet of this url
	 */
	public void setKeyandDesc(ArrayList<String> mateSet)
	{
		for(String e:mateSet)
		{
			System.out.println(e);
			if(e.toLowerCase().contains("key"))
			{
				keyforDisplay =e;
			}
			else if(e.toLowerCase().contains("desc"))
			{
				descForDisplay=e;
			}
		}
	}


	/**
	 * this will call set key and desc
	 * @param meta going to set
	 */
	public void setMeta(ArrayList<String> meta) {
		this.meta = meta;
		setKeyandDesc(this.meta);
	}

	/**
	 * quick fix not complete url
	 * @param url going to be fix
	 * @return fix url
	 */
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
		return this.getCurrentRank().compareTo(arg0.getCurrentRank());
	}
	public int getInComingNumber() {
		return inComingNumber;
	}

	public void setInComingNumber(int inComingNumber) {
		this.inComingNumber = inComingNumber;
	}



	public Double getCurrentRank() {
		return currentRank;
	}



	public void setCurrentRank(double currentRank) {
		this.currentRank = currentRank;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<String> getChildSet() {
		return childSet;
	}


	public void setChildSet(Set<String> childSet) {
		this.childSet = childSet;
	}

	public void completeNodeName()
	{
		this.name=leg.getTitle(url);
	}
	public void compeletNodeChildSet()
	{
		this.childSet=leg.getHyperlink(url);
	}
	
	public String getKeyWord() {
		return this.keyforDisplay;
	}
	public String getDesc() {
		return this.descForDisplay;
	}




}
