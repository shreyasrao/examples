# Copyright 2013 Google, Inc
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#             http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import json

import webapp2

import model


def AsDict(song):
    # if num==3:
    #     return {'title': song.title, 'artist': song.artist, 'url':song.url}
    # else:
    return {'title': song.title, 'artist': song.artist, 'url': song.url, 'id': song.unique}

class RestHandler(webapp2.RequestHandler):

    def dispatch(self):
        # time.sleep(1)
        super(RestHandler, self).dispatch()

    def SendJson(self, r):
        self.response.headers['content-type'] = 'text/plain'
        self.response.write(json.dumps(r))


class QueryHandler(RestHandler):

    def get(self):
        # model.initUser()
        songs = model.AllSongs()
        r = [AsDict(song) for song in songs]
        self.SendJson(r)

class LikeHandler(RestHandler):

    def post(self):
        r = json.loads(self.request.body)
        song = model.LikeSong(r['id'])
        r = AsDict(song)

        # songs = model.AllFavorites().get().songs
        # r = [AsDict(song) for song in songs]

        self.SendJson(r)

class UnlikeHandler(RestHandler):
    def post(self):
        r = json.loads(self.request.body)
        model.UnlikeSong(r['id'])

class FavoritesHandler(RestHandler):
    def get(self):
        # songs = model.AllFavorites().get().songs
        songs = model.allLiked()
        r = [AsDict(song) for song in songs]
        self.SendJson(r)



#
# class UpdateHandler(RestHandler):
#
#     def post(self):
#         r = json.loads(self.request.body)
#         guest = model.UpdateGuest(r['id'], r['first'], r['last'])
#         r = AsDict(guest)
#         self.SendJson(r)
#
#
# class InsertHandler(RestHandler):
#
#     def post(self):
#         r = json.loads(self.request.body)
#         guest = model.InsertGuest(r['first'], r['last'])
#         r = AsDict(guest)
#         self.SendJson(r)
#
#
# class DeleteHandler(RestHandler):
#
#     def post(self):
#         r = json.loads(self.request.body)
#         model.DeleteGuest(r['id'])


APP = webapp2.WSGIApplication([
    ('/rest/query', QueryHandler),
    ('/rest/like', LikeHandler),
    ('/rest/favorites', FavoritesHandler),
    ('/rest/unlike', UnlikeHandler)
    # ('/rest/insert', InsertHandler),
    # ('/rest/delete', DeleteHandler),
    # ('/rest/update', UpdateHandler),
], debug=True)
