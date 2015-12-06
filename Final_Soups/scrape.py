import json
import sys
import re
import urllib
from bs4 import BeautifulSoup

def scrape():
    # jsonQuoteData = "[]"
    print "HELLO"
    filename = "/Users/shreyas/Desktop/APT/shreyas/Final_Soups/New Hip Hop Songs, Hottest Music Releases.html"
    inputFile = open(filename)
    soup = BeautifulSoup(inputFile, "html.parser")

    allGridItems = soup.find_all('div', {'class':'gridItem-trackInfo'})

    items = list()

    for item in allGridItems:
        #print item
        now = str(item)
        items.append(now)


    # print items[0]

    links = list()

    for item in items:
        now = str(item)
        start =  now.index("href=") + 6
        end = now.index('"',start)
        links.append("http://www.hotnewhiphop.com" + now[start:end])

    print links[0]

    # filename = "/Users/shreyas/Desktop/APT/shreyas/Final_Soups/Jae Millz - Live From The Gutter (Freestyle) | Stream & Listen [New Song].html"
    # inputFile = open(filename)
    # soup = BeautifulSoup(inputFile, "html.parser")
    #
    # sound = str(soup.find("iframe"))
    # lstart = sound.index("https://w.soundcloud.com/")
    # lend = sound.index("&amp;", lstart)
    #print sound[lstart:lend]

    #print "Done!"

    url = links[0]
    page = urllib.urlopen(url)
    soup == BeautifulSoup(page.read(),"html.parser")

    sound = str(soup.find("iframe"))
    lstart = sound.index("https://w.soundcloud.com/")
    lend = sound.index("&amp;", lstart)
    print sound[lstart:lend]

    print "Done!"

    # TICKER = str(soup.title).split(" ")[0].split(">")[1].upper()
    #
    # # Code to get info from Tables
    # tables = soup.findChildren('table')
    # dataTables = soup.findAll('table', {'class':'yfnc_datamodoutline1'})

    #class="next-page"
    return

scrape()