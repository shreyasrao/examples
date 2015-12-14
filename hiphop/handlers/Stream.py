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
    # finalized = ndb.BooleanProperty()
#
#
# class Stream(ndb.Model):
#     owner_id = ndb.StringProperty()  # owner
#     name = ndb.StringProperty()  # stream name
#
#     photos = ndb.BlobKeyProperty(repeated=True)  # photos in stream
#     # photos = ndb.StructuredProperty(Photo, repeated=true)
#
#     num_photos = ndb.IntegerProperty()  # number of photos in stream
#     views = ndb.IntegerProperty()  # number of views of the stream
#     view_queue = ndb.DateTimeProperty(repeated=True)
#
#     subscribed_users = ndb.StringProperty(repeated=True)  # list of subsribed users
#
#     timestamp = ndb.DateTimeProperty()  # date that stream was created
#     date_last_added = ndb.DateProperty()  # date a photo was last added to the stream
#
#     tags = ndb.StringProperty(repeated=True)  # list of tags
#     cover_image = ndb.StringProperty()  # url to cover image
#
#
# class Photo(ndb.Model):
#     photo_title = ndb.StringProperty()  # photo title
#     photo_blob_key = ndb.BlobKeyProperty()  # photo blob key
#     photo_lat = ndb.FloatProperty()  # photo latitude
#     photo_long = ndb.FloatProperty()  # photo longitude
