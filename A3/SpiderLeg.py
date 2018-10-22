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
'''
this function will get the hyperlink in the URL
but it will not get any think looks like javascript
also any email addressl, .css. mp3 or #header
will not be get
'''
def getHyperLink(url):
    linkSet = set()
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

            if(('javascript:' not in link )&
                ('@' not in link)&
                ('.css' not in link)&
                ('/page'not in link)&
                ('.mp3' not in link)&
                ('#respond'not in link)&
                ('#head' not in link)&
                (len(link)!=1)&
                ('http' in link)
                ):
                link = fixUrl(link)
                print(link)
                print('============================================')
                linkSet.add(link)
    return linkSet

def fixUrl(url):
    if(url[0:2]=='//'):
        url =  "https:" + url 
    return url

def getImage(url):
    imageUrlSet = set()
    myUrl = url
    uClient = uReq(myUrl)
    page_html = uClient.read()
    uClient.close()  
    page_soup = soup(page_html,'html.parser')

    for img in page_soup.findAll('img'):
        response = requests.get(fixUrl(img.get("src")))
        imageBuffer = Image.open(BytesIO(response.content))
        print(f'name: {img.get("title")} , URL: {fixUrl(img.get("src"))}, width: {imageBuffer.size[0]} , height {imageBuffer.size[1]}, alt: {img.get("alt")}')
        imageUrlSet.add(fixUrl(img.get("src")))
    return imageUrlSet

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


if __name__ == '__main__':
    print(getHyperLink('https://www.blizzard.com/en-us/'))
    #getTitle('https://www.newegg.com')
   # getImage('http://www.ifixit.com/Teardown/PlayStation+4+Pro+Teardown/72946')
    #getMeta('https://www.newegg.com')