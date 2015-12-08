__author__ = 'shreyas'

import webapp2
import jinja2
import json
# from Stream import Stream
from google.appengine.api import users
from BaseHandler import BaseHandler
from Stream import Latest
from Stream import Popular
import datetime

class PopularHandler(webapp2.RequestHandler, BaseHandler):
    def get(self):
        self.cache('popular')


        JINJA_ENVIRONMENT = jinja2.Environment(
        loader=jinja2.FileSystemLoader('templates'),
        extensions=['jinja2.ext.autoescape'],
        autoescape=True)

        user = users.get_current_user()
        user_id = user.user_id()

        soundLinks = list()
        soundLinks.append("https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/235593121")
        soundLinks.append("https://w.soundcloud.com/player/?url=https://soundcloud.com/derricknthecity/kellz-christmas-party")
        soundLinks.append("https://w.soundcloud.com/player/?url=https://soundcloud.com/asapferg/tatted-angel")


        meta = list()
        meta.append({'artist':'R. Kelly', 'title':'christmas party', 'link': "https://w.soundcloud.com/player/?url=https://soundcloud.com/derricknthecity/kellz-christmas-party"})

        linkStore = Popular(songs=meta)
        linkStore.put()

        temp = False

        while(temp==False):
            ret = Popular.query()
            for a in ret:
                temp=True

        ret = Popular.query().get()
        # af = dict()
        # af = json.loads(ret.sclinks)
        # self.response.write(ret.songs)


        #Get the list of streams
        # my_streams = Stream.query(Stream.owner_id == user_id)
        # subscribed_streams = Stream.query(Stream.subscribed_users.IN([user_id]))

        # base = Latest.query().get().sclinks

        # self.response.write(str(base))

        template_values = {
            'songs':ret.songs,
        }

        template = JINJA_ENVIRONMENT.get_template('ShowPage2.html')
        self.response.write(template.render(template_values))