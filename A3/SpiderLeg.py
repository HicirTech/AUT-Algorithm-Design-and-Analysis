import bs4
from urllib.request import urlopen as uReq
from bs4 import BeautifulSoup as soup
from PIL import Image
import requests
from io import BytesIO

def getTitle(url):
    myUrl = url
    uClient = uReq(myUrl)
    page_html = uClient.read()
    uClient.close()
    page_soup = soup(page_html,'html.parser')
    title = str(page_soup.title)[7:-8]
    print(title)

def getHyperLink(url):
    myUrl = url
    uClient = uReq(myUrl)
    page_html = uClient.read()
    uClient.close()  
    page_soup = soup(page_html,'html.parser')
    
    all_links= page_soup.findAll('a')
    
    for link in all_links:
        
        link_Str = str(link)

        if('a href' in link_Str):
            
            link= (link_Str.split('<a href="')[1])
            link=(link.split('"')[0])

            if(('javascript:' not in link )& ('@' not in link)):
                link = fixUrl(link)

                print(link)

def fixUrl(url):
    if(url[0:2]=='//'):
        url =  "https:" + url 
    return url

def getImage(url):
    myUrl = url
    uClient = uReq(myUrl)
    page_html = uClient.read()
    uClient.close()  
    page_soup = soup(page_html,'html.parser')

    for img in page_soup.findAll('img'):
        response = requests.get(fixUrl(img.get("src")))
        imageBuffer = Image.open(BytesIO(response.content))
        print(f'name: {img.get("title")} , URL: {fixUrl(img.get("src"))}, width: {imageBuffer.size[0]} , height {imageBuffer.size[1]}, alt: {img.get("alt")}')


def getMeta(url):
    myUrl = url
    uClient = uReq(myUrl)
    page_html = uClient.read()
    uClient.close()  
    page_soup = soup(page_html,'html.parser')
    for meta in page_soup.findAll('meta'):
        if('description' in str(meta).lower()):
            print(f"description: {meta.get('content')}")
        if('keyword' in str(meta).lower()):
            print(f"keyword: {meta.get('content')}")

def Run():
    getTitle("http://ashuyun.tk/WP")
    getHyperLink("http://ashuyun.tk/WP")
    getImage("http://ashuyun.tk/WP")
    getMeta("http://ashuyun.tk/WP")

if __name__ == '__main__': Run()