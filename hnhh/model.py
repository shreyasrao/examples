# Copyright 2013 Google, Inc
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

from google.appengine.ext import ndb

def userName():
    return "shreyas"

class Song(ndb.Model):
    title = ndb.StringProperty() # title + ft. *
    artist = ndb.StringProperty()
    url = ndb.StringProperty() #SoundClound embedded link
    unique = ndb.GenericProperty()
    # type = ndb.StringProperty() #New Song or Popular Song

# class Playlist(ndb.Model):
#     title = ndb.StringProperty()
#     songs = ndb.StructuredProperty(Song, repeated=True)
#
# class Playlists(ndb.Model):
#     user = ndb.StringProperty()
#     playlists = ndb.StructuredProperty(Playlist, repeated=True)

class Favorites(ndb.Model):
    user = ndb.StringProperty()
    songs = ndb.StructuredProperty(Song, repeated=True)

class Liked(ndb.Model):
    user = ndb.StringProperty()
    title = ndb.StringProperty()  # title + ft. *
    artist = ndb.StringProperty()
    url = ndb.StringProperty()  # SoundClound embedded link
    unique = ndb.GenericProperty()

# def initUser():
#     a = Favorites.query(Favorites.user==userName()).get()
#     if a:
#         a
#     else:
#         Favorites(user=userName()).put()

def AllSongs():
    if Song.query().get():
        temp = 'a'
    else:
        AddSong("Views","Drake","drakeViews.com")
        AddSong("Blood on the Leaves", "Kanye West", "kanyeYeezus.com")
        AddSong("Prayer", "Kid Cudi", "kuderr.com")
    # do nothing, songs are already present

    updated = False
    while not updated:
        if Song.query(Song.title=='Prayer').get(): updated = True

    return Song.query() #TODO: New Songs vs Popular Songs query


def AddSong(title, artist, url):
    song = Song(title=title, artist=artist, url=url)
    song_key = song.put()
    song = song_key.get()
    song.unique = song.key.id()
    song.put()
    return song

def LikeSong(id):
    song = ndb.Key(Song, id).get()
    liked = Liked(user=userName(), title=song.title, artist=song.artist, url=song.url, unique=song.unique)
    liked.put()
    return song

def UnlikeSong(id):
    song = Liked.query(Liked.user == userName(), Liked.unique == id).get()
    song.key.delete()

def AllFavorites():
    return Favorites.query(Favorites.user==userName())

def allLiked():
    return Liked.query(Liked.user==userName())
#
# def DeleteGuest(id):
#     key = ndb.Key(Guest, id)
#     key.delete()
