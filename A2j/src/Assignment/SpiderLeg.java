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

/**
 * This is the class for ADA assginment 2 
 * it will answer question 1 
 * for test this code, run this class
 * @author Luo Zeting ID:16938158
 *
 */
public class SpiderLeg {
	
	
	//Set up a conection to the URL and get the document back 
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
				e.printStackTrace();
			}
		
        return doc;
       
	}
	
	
	/**
	 * this is the method will get hyperlink in a website
	 * @param url going to be search
	 * @return a set of url contain the hyperlinks in the websites
	 */
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
	/**
	 * a filter to check the url is ok to be used
	 * this will filter most of files and not runable link
	 * also will check the url contains "http"
	 * @param url going to be check
	 * @return does url passed the filter or not
	 */
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
				!url.contains(".png")&&
				!url.contains(".jpg")&&
				!url.contains("&amp")&&
				!url.contains("www.ifanr.com")&&
				!url.contains("/webapps")&&
				url.contains("http")&&				
				url.length()>4;
	}
	
	
	/**
	 * Question 1 get title method
	 * @param url for get title
	 * @return the title of the url
	 */
	public String getTitle(String url)
	{
		Document doc = setup(url);
		return doc.title().toString();
	}
	
	/**
	 * Question 1 get meta method
	 * @param url for get mate
	 * @return a arraylist of meta which has keyword and description 
	 */	
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
	
	/**
	 * Question 1 get meta method
	 * @param url for get mate
	 * @return a arraylist of meta which has keyword and description 
	 */	
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
	    	try
		    {
		    	System.out.println("Title: "+this.getImageTitle(e)+
		    			" src: "+this.getImageSrc(e,isHttps)+
		    			" alt: "+this.getImageAlt(e)+
		    			" height: "+this.getImageHeight(this.getImageInfo(this.getImageSrc(e,isHttps)))+
		    			" width: " +this.getImageWidth(this.getImageInfo(this.getImageSrc(e,isHttps))));
		    	
		    	linkOfImages.add(this.getImageSrc(e,isHttps));
		   	} 
	    	catch(NullPointerException nullPe)
			{
				System.out.println("Bad image");
			}
	    }
		return linkOfImages;
	}
	
	/**
	 * a simple helper funtion to fix those url is wrong because do not have http/https
	 * @param url going to be fix
	 * @param isHttps is the url is a https url
	 * @return fixed url
	 */
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
	
	/**
	 * A helper function to get information of a image, which will correct the url do not label
	 * information of the picture  
	 * @param url of the image
	 * @return the image information read from image io
	 */
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
	
	
	/**
	 * this is a helper function to get a "alt" tga
	 * in the image element come from the jsoup
	 * @param e for checl
	 * @return the alt tag infomation in string format
	 */
	public String getImageAlt(Element e)
	{
		return e.attr("alt");
	}
	
	/**
	 * this is a helper function to get a "src" tga
	 * in the image element come from the jsoup
	 * and also fix the url if the url is not compete
	 * @param e to check 
	 * @param isHttps is the website original https
	 * @return image src in string format
	 */
	public String getImageSrc(Element e,boolean isHttps)
	{
		return fixUrl(e.attr("src").toString(),isHttps);
	}
	
	/**
	 * this is a helper function to get a "title" tga
	 * in the image element come from the jsoup
	 * @param e image element going to be search 
	 * @return title in string format
	 */
	public String getImageTitle(Element e)
	{
		return e.attr("title");
	}
	
	
	/**
	 * helper method use imageIO to get the height information from the image
	 * @param imgInfo imgInfo from imageIO toString method 
	 * @return height information of the image in string format
	 */
	public String getImageHeight(String imgInfo)
	{
		return imgInfo.split("height = ")[1].split(" #")[0];
	}
	
	/**
	 * helper method use imageIO to get the weight information from the image
	 * @param imgInfo imgInfo from imageIO toString method 
	 * @return weight information of the image in string format
	 */
	public String getImageWidth(String imgInfo)
	{
		return imgInfo.split("width = ")[1].split(" height")[0];
	}
	
	/**
	 * A test unit for test the qestion 1 methods
	 * @param args if you call from comment... but it is not used
	 */
	public static void  main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Here is Question 1 test");
		System.out.println("Enter your URL   Format of your URL should be like [http/https]://[some url]/");
		String url= sc.nextLine();	
		SpiderLeg leg = new SpiderLeg();
		
		while(true)
		{
			System.out.println("Run method by selecting the following");
			System.out.println("1. Get title");
			System.out.println("2. Get HyperLink");
			System.out.println("3. Get images");
			System.out.println("4. Get Meta");
			System.out.println("5. Stop the Question 1 test");
			int userInput = sc.nextInt();
			switch(userInput)
			{
			case 1: 
				System.out.println("Title: "+leg.getTitle(url));
				break;
			case 2:
				Set<String> result = leg.getHyperlink(url);
				System.out.println("HyperLink in url : ");
				for(String innerUrl : result)
				{
					System.out.println(innerUrl);
				}
				break;
			case 3:
				System.out.println("Images in url : ");
				leg.getImages(url);
				break;
			case 4:
				System.out.println("Meta what has with keyword or description");
				leg.getMeta(url);
				break;
			case 5:
				System.exit(0);
				break;
			default :
				break;
			}
		}	
	}
}
