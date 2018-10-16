package Assignment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnknownHostException;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;



public class SpiderLeg {

	public Document setup(String url)
	{
		Document doc = null;
		
	        try {
				doc = Jsoup.connect(url).get();
			} catch(UnknownHostException e)
	        {
				e.printStackTrace();
	        }
	        catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        return doc;
       
	}
	public Set<String> getHyperlink(String url){
		Set<String> returnlinks = new HashSet<>();
		Document doc = setup(url);
        Elements links = doc.select("a[href]");
        for(Element link : links)
        {
        	String theUrl = link.toString().split("\"")[1];
        	if(urlFilter(theUrl))
        	{
        		returnlinks.add(theUrl);
        	}
        }
        
        return returnlinks;
	}
	public boolean urlFilter(String url)
	{
		return !url.contains("javascript:")&&
				!url.contains("@")&&
				!url.contains(".css")&&
				!url.contains("/page")&&
				!url.contains("respond")&&
				!url.contains("#head")&&
				!url.contains(".mp3")&&
				!url.contains(".ogg")&&
				!url.contains(".exe")&&
				!url.contains(".apk")&&
				!url.contains("www.ifanr.com")&&
				url.contains("http")&&				
				url.length()>4;
	}
	public String getTitle(String url)
	{
		Document doc = setup(url);
		return doc.title().toString();
	}
	
	
	public ArrayList<String> getMeta(String url)
	{
		ArrayList<String> mate = new ArrayList<>();
		Document doc = setup(url);
        Elements links = doc.select("meta");
        for(Element e : links)
        {
        	
        	if(e.toString().contains("keywords"))
        	{
        		mate.add("Keywords: "+e.attr("content"));
        	}
        	else if(e.toString().contains("description"))
        	{
        		mate.add( "Description: "+e.attr("content"));	
    		}
        }
        return mate;
	}
	public Set<String> getImages(String url)
	{
		boolean isHttps=false;
		if(url.contains("https"))
		{
			isHttps = true;
		}
		Set<String> linkOfImages = new HashSet<>();
		Document doc = setup(url);
	    Elements links = doc.select("img");
	    for(Element e : links)
	    {
	    	System.out.println("Title: "+this.getImageTitle(e)+
	    			" src: "+this.getImageSrc(e,isHttps)+
	    			" alt: "+this.getImageAlt(e)+
	    			" height: "+this.getImageHeight(this.getImageInfo(this.getImageSrc(e,isHttps)))+
	    			" width: " +this.getImageWidth(this.getImageInfo(this.getImageSrc(e,isHttps))));
	    	
	    	linkOfImages.add(this.getImageSrc(e,isHttps));
	    }
		return linkOfImages;
	}
	public String fixUrl(String url, boolean isHttps)
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
		return url;
	}
	
	public String getImageInfo(String url) {
		Image image = null;
		try {
			URL theUrl = new URL(url);
			image = ImageIO.read(theUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  image.toString();
	}
	
	public String getImageAlt(Element e)
	{
		return e.attr("alt");
	}
	public String getImageSrc(Element e,boolean isHttps)
	{
		return fixUrl(e.attr("src").toString(),isHttps);
	}
	
	public String getImageTitle(Element e)
	{
		return e.attr("title");
	}
	public String getImageHeight(String imgInfo)
	{
		return imgInfo.split("height = ")[1].split(" #")[0];
	}
	public String getImageWidth(String imgInfo)
	{
		return imgInfo.split("width = ")[1].split(" height")[0];
	}
}
