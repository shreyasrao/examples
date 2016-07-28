__author__ = 'shreyasrao'

from google.appengine.ext import ndb
import urllib2
from bs4 import BeautifulSoup

class stock(ndb.Model):
    user_id = ndb.StringProperty()

    chapati = ndb.PickleProperty()
    poori = ndb.PickleProperty()
    # tea = ndb.PickleProperty()
    # coffee = ndb.PickleProperty()

class daily(ndb.Model):
    user_id = ndb.StringProperty()
    date = ndb.DateProperty()

    chapati = ndb.PickleProperty()
    poori = ndb.PickleProperty()
    # tea = ndb.PickleProperty()
    # coffee = ndb.PickleProperty()


class chapati10(ndb.Model):
    size = 10
    type = "chapati"
    id="chapati10"
    name = "Chapati 10 pack"
    quantity = ndb.IntegerProperty()

class chapati20(ndb.Model):
    size = 20
    type = "chapati"
    id="chapati20"
    name = "Chapati 20 pack"
    quantity = ndb.IntegerProperty()

class chapati25(ndb.Model):
    size = 25
    type = "chapati"
    id="chapati25"
    name = "Chapati 25 pack"
    quantity = ndb.IntegerProperty()

class poori10(ndb.Model):
    size = 10
    type = "poori"
    id="poori10"
    name = "Poori 10 pack"
    quantity = ndb.IntegerProperty()

class poori20(ndb.Model):
    size = 20
    type = "poori"
    id="poori20"
    name = "Poori 20 pack"
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