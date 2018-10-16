package Assignment;

public class runAble {

	public static void main(String[] args)
	{
		//SpiderLeg leg = new SpiderLeg();
		//System.out.println(leg.getHyperlink("https://www.reddit.com/"));
		//System.out.println(leg.getTitle("http://www.newegg.com"));
		//leg.getName("https://jsoup.org/cookbook");
		//leg.getImages("http://ashuyun.tk/WP");
		//leg.getImages("https://www.newegg.com");
		//leg.getMeta("https://www.newegg.com");
		//System.out.println(leg.getImageWidth("BufferedImage@433c675d: type = 13 IndexColorModel: #pixelBits = 8 numComponents = 4 color space = java.awt.color.ICC_ColorSpace@3f91beef transparency = 2 transIndex   = 255 has alpha = true isAlphaPre = false ByteInterleavedRaster: width = 100 height = 40 #numDataElements 1 dataOff[0] = 0"));
		Spider sp= new Spider();
		//sp.ini("http://ashuyun.tk/WP/", 2);
		Q3GUI q3 = new Q3GUI();
	//	Spider sp = new Spider();
		//sp.ini("http://ashuyun.tk/WP", 2);
		ActionControl ac= new ActionControl(q3,sp);
		ac.Begin();
		//Node a = new Node("abcde",2);
		//Node b = new Node("abcde",1);
		//System.out.println(a.equals(b));
	
	}
}
