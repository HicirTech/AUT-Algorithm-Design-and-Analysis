import SpiderLeg

def Run():
    SpiderLeg.getTitle("http://ashuyun.tk/WP")
    SpiderLeg.getHyperLink("http://ashuyun.tk/WP")
    SpiderLeg.getImage("http://ashuyun.tk/WP")
    SpiderLeg.getMeta("http://ashuyun.tk/WP")

if __name__ == '__main__': Run()