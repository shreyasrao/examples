__author__ = 'shreyas'

import webapp2
import jinja2
from google.appengine.api import users
from BaseHandler import BaseHandler
from Stock import stock
from Stock import chapati10
from Stock import chapati20
from Stock import chapati25
from Stock import daily
from datetime import datetime
# from Stream import Latest

class StockHandler(webapp2.RequestHandler, BaseHandler):
    def start(self):

        user = users.get_current_user()
        user_id = user.user_id()

        me = stock.query(stock.user_id==user_id).get()

        if me:
            me
        else:
            me = stock(user_id=str(user_id))

        if me.chapati:
            me.chapati
        else:
            new_10 = chapati10(quantity=0)
            new_20 = chapati20(quantity=0)
            new_25 = chapati25(quantity=0)

            new_chapatis = list()
            new_chapatis.append(new_10)
            new_chapatis.append(new_20)
            new_chapatis.append(new_25)

            me.chapati = new_chapatis

        me.put()

    def daily(self):
        user = users.get_current_user()
        user_id = user.user_id()

        today = daily.query(daily.user_id==user_id, daily.date==datetime.now().date()).get()

        if today:
            today
        else:
            today = daily(user_id=str(user_id), date=datetime.now().date())

        if today.chapati:
            today.chapati
        else:
            new_10 = chapati10(quantity=0)
            new_20 = chapati20(quantity=0)
            new_25 = chapati25(quantity=0)

            new_chapatis = list()
            new_chapatis.append(new_10)
            new_chapatis.append(new_20)
            new_chapatis.append(new_25)

            today.chapati = new_chapatis

        today.put()

    def get(self):
        self.cache('stock')
        #
        JINJA_ENVIRONMENT = jinja2.Environment(
        loader=jinja2.FileSystemLoader('templates'),
        extensions=['jinja2.ext.autoescape'],
        autoescape=True)

        user = users.get_current_user()
        user_id = user.user_id()


        if str(user) in self.known:
            self.start()
            self.daily()
            me = stock.query(stock.user_id==user_id).get()

            template_values = {
                    'items':me.chapati,
                }

            template = JINJA_ENVIRONMENT.get_template('StockView.html')
            self.response.write(template.render(template_values))

        else:
            self.errorpage('You Do Not Have Permission To View This Page')


        #
        # all = stock.query(stock.user_id==user_id).get()
        #
        # if all:
        #     self.response.write("Found user\n")
        # else:
        #     self.response.write("Adding New user\n")
        #     new_user = stock(user_id=str(user_id))
        #     new_user.put()
        #
        # # current = stock.query(stock.user_id==user_id).get()
        # chapatis = stock.query(stock.user_id==user_id).get().chapati
        #
        # if chapatis:
        #     self.response.write("Found some stock\n")
        # else:
        #     self.response.write("No chapatis\n")
        #     self.start()

        # self.start()
        # self.daily()

        # me = stock.query(stock.user_id==user_id).get()
        #
        # template_values = {
        #         'items':me.chapati,
        #     }
        #
        # template = JINJA_ENVIRONMENT.get_template('StockView.html')
        # self.response.write(template.render(template_values))

        # template = JINJA_ENVIRONMENT.get_template('UpdateChapati.html')
        # self.response.write(template.render())

        # today = daily.query(daily.user_id==user_id, daily.date==datetime.now().date()).get()
        #
        # template_values = {
        #         'items':today.chapati,
        #     }
        #
        # template = JINJA_ENVIRONMENT.get_template('StockView.html')
        # self.response.write(template.render(template_values))
