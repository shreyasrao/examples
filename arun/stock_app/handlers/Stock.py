__author__ = 'shreyasrao'

from google.appengine.ext import ndb
import urllib2
from bs4 import BeautifulSoup

class stock(ndb.Model):
    user_id = ndb.StringProperty()

    chapati = ndb.PickleProperty()
    poori = ndb.PickleProperty()
    tea = ndb.PickleProperty()
    coffee = ndb.PickleProperty()

class daily(ndb.Model):
    user_id = ndb.StringProperty()
    date = ndb.DateProperty()

    chapati = ndb.PickleProperty()
    poori = ndb.PickleProperty()
    tea = ndb.PickleProperty()
    coffee = ndb.PickleProperty()


class chapati10(ndb.Model):
    size = 10
    type = "chapati"
    id="chapati10"
    name = "chapati 10 count"
    quantity = ndb.IntegerProperty()

class chapati20(ndb.Model):
    size = 20
    type = "chapati"
    id="chapati20"
    name = "chapati 20 count"
    quantity = ndb.IntegerProperty()

class chapati25(ndb.Model):
    size = 25
    type = "chapati"
    id="chapati25"
    name = "chapati 25 count"
    quantity = ndb.IntegerProperty()

#
# class chapati(ndb.Model):
#     ten = ndb.IntegerProperty()
#     twenty = ndb.IntegerProperty
#     twentyFive = ndb.IntegerProperty()

    # user_id = ndb.StringProperty()
    # liked_artists = ndb.PickleProperty()
    # liked_songs = ndb.PickleProperty()
    #
    #
    # version = ndb.IntegerProperty()