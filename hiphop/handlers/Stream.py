__author__ = 'shreyasrao'

from google.appengine.ext import ndb
import urllib2
from bs4 import BeautifulSoup

class Personal(ndb.Model):
    user_id = ndb.StringProperty()
    liked_artists = ndb.PickleProperty()
    liked_songs = ndb.PickleProperty()


    version = ndb.IntegerProperty()

class Song(ndb.Model):
    title = ndb.StringProperty()
    artist = ndb.StringProperty()
    link = ndb.StringProperty()

    # liked_user = ndb.StringProperty()

class Artist(ndb.Model):
    name = ndb.StringProperty()
    image_link = ndb.StringProperty()
    id = ndb.IntegerProperty()

# class Likes(ndb.Model):
#     user_id = ndb.StringProperty()

class Popular(ndb.Model):
    songs = ndb.PickleProperty()
    date_modified = ndb.DateProperty()

class Latest(ndb.Model):
    date_modified = ndb.DateProperty()
    songs = ndb.PickleProperty()
    finalized = ndb.BooleanProperty()

    def scrape(self):
        # jsonQuoteData = "[]"
        # print "HELLO"
        # filename = "/Users/shreyas/Desktop/APT/shreyas/Final_Soups/New Hip Hop Songs, Hottest Music Releases.html"
        # inputFile = open(filename)

        url = "http://www.hotnewhiphop.com/songs/"
        page = urllib2.urlopen(url)
        soup = BeautifulSoup(page.read(), "html.parser")
        allGridItems = soup.find_all('div', {'class': 'gridItem-trackInfo'})

        items = list()

        for item in allGridItems:
            now = str(item)
            items.append(now)

        links = list()

        for item in items:
            now = str(item)
            start = now.index("href=") + 6
            end = now.index('"', start)
            links.append("http://www.hotnewhiphop.com" + now[start:end])
        # print "the numbers of links is " + str(len(links))

        # web = "http://www.hotnewhiphop.com/r-kelly-christmas-party-new-song.1967561.html"

        soundLinks = list()
        notFound = list()

        for link in links:
            web = link
            site = urllib2.urlopen(web)
            soup = BeautifulSoup(site.read(), "html.parser")
            sound = str(soup.find("iframe"))
            lstart = sound.find("https://soundcloud.com/")
            if (lstart == -1):
                # soundLinks.append("CANNOT FIND: " + link)
                notFound.append("CANNOT FIND: " + link)
            else:
                lend = sound.find("&amp;", lstart)
                soundLinks.append("https://w.soundcloud.com/player/?url=" + sound[lstart:lend])

        # print soundLinks
        # print "Number of found links is " + str(len(soundLinks))
        # print "Number of not found links is " + str(len(notFound))
        # print notFound



        # print "Done!"
        return soundLinks


class Stream(ndb.Model):
    owner_id = ndb.StringProperty()  # owner
    name = ndb.StringProperty()  # stream name

    photos = ndb.BlobKeyProperty(repeated=True)  # photos in stream
    # photos = ndb.StructuredProperty(Photo, repeated=true)

    num_photos = ndb.IntegerProperty()  # number of photos in stream
    views = ndb.IntegerProperty()  # number of views of the stream
    view_queue = ndb.DateTimeProperty(repeated=True)

    subscribed_users = ndb.StringProperty(repeated=True)  # list of subsribed users

    timestamp = ndb.DateTimeProperty()  # date that stream was created
    date_last_added = ndb.DateProperty()  # date a photo was last added to the stream

    tags = ndb.StringProperty(repeated=True)  # list of tags
    cover_image = ndb.StringProperty()  # url to cover image


class Photo(ndb.Model):
    photo_title = ndb.StringProperty()  # photo title
    photo_blob_key = ndb.BlobKeyProperty()  # photo blob key
    photo_lat = ndb.FloatProperty()  # photo latitude
    photo_long = ndb.FloatProperty()  # photo longitude
