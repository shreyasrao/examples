__author__ = 'shreyas'

import webapp2
import cgi
# from Stream import Stream
from google.appengine.ext import ndb

class LikeSongHandler(webapp2.RequestHandler):
    def post(self):
        songs = self.request.get_all('liked_songs')
        for song in songs:
            self.response.write("Title:" + str(song))




        # self.redirect('/management')

        # stream_names = self.request.get_all('deleted_streams')
        # for stream_name in stream_names:
        #     stream_key = ndb.Key(Stream,stream_name)
        #     stream_key.delete()
        #
        #
        #
        # self.redirect('/management')