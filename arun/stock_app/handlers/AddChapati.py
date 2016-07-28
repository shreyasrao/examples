__author__ = 'shreyas'

import webapp2
from google.appengine.api import users
# from Stream import Personal
from Stock import stock
from handlers.BaseHandler import BaseHandler
# from Stream import Artist
# from Stream import Song
import jinja2
import cgi
from google.appengine.ext import ndb
import time
from datetime import datetime
from Stock import daily

class AddChapati(webapp2.RequestHandler, BaseHandler):

    def post(self):
        # user_id = users.get_current_user().user_id()
        packageType = self.request.get_all('package').pop(0)
        numPackages = self.request.get_all('quantity').pop(0)
        calc = self.request.get_all('calc').pop(0)

        if (int(numPackages) < 1) : #or (not isinstance(numPackages, int)):
            # Error Handler
            # JINJA_ENVIRONMENT = jinja2.Environment(
            # loader=jinja2.FileSystemLoader('templates'),
            # extensions=['jinja2.ext.autoescape'],
            # autoescape=True)
            #
            # template_values = {'message':'Stock Not Updated!!! Number should be greater than 0'}
            #
            # template = JINJA_ENVIRONMENT.get_template('ErrorPage.html')
            # self.response.write(template.render(template_values))
            self.cache('')
            self.errorpage('Stock Not Updated!!! Number should be greater than 0')
        else:

            user_id = 'nidhi'
            me = stock.query(stock.user_id==user_id).get()



            self.cache('chapati')

            chapatis = me.chapati

            for package in chapatis:
                if package.id==packageType:
                    if calc=='add':
                        package.quantity = package.quantity + int(numPackages)
                        # self.response.write("ADDED")
                    if calc=='remove':
                        package.quantity = package.quantity - int(numPackages)

                        today = daily.query(daily.user_id==user_id, daily.date==datetime.now().date()).get()

                        for item in today.chapati:
                            if item.id==packageType:
                                item.quantity = item.quantity + int(numPackages)

                        today.put()



            me.chapati = chapatis
            me.put()

            time.sleep(.5)
            self.redirect('/chapati')

        # self.response.write("TYPE: " + packageType + "\n" "Q: " + numPackages)
        # self.response.write(numPackages)
        # self.response.write("||||||")
        # self.response.write(packageType + " ||| END")
        # # self.cache('liked_artists')

        # if me.liked_artists:
        #     JINJA_ENVIRONMENT = jinja2.Environment(
        #     loader=jinja2.FileSystemLoader('templates'),
        #     extensions=['jinja2.ext.autoescape'],
        #     autoescape=True)
        #
        #     template_values = {
        #         'artists':me.liked_artists,
        #     }
        #
        #     template = JINJA_ENVIRONMENT.get_template('LikedArtists.html')
        #     self.response.write(template.render(template_values))
        # else:
        #     # self.response.write("You have not liked any artists yet")
        #     self.errorpage("As you like songs, those artists will be displayed here")