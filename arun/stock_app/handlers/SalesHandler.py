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

class SalesHandler(webapp2.RequestHandler, BaseHandler):
    def post(self):
        JINJA_ENVIRONMENT = jinja2.Environment(
        loader=jinja2.FileSystemLoader('templates'),
        extensions=['jinja2.ext.autoescape'],
        autoescape=True)

        user_id = users.get_current_user().user_id()
        me = stock.query(stock.user_id==user_id).get()

        itemType = self.request.get_all('item').pop(0)
        saleDate = self.request.get_all('saledate').pop(0)
        # calc = self.request.get_all('calc').pop(0)

        self.cache('sales')

        template = JINJA_ENVIRONMENT.get_template('SalesFetch.html')
        self.response.write(template.render())

        today = daily.query(daily.user_id==user_id, daily.date==datetime.strptime(saleDate, "%d-%m-%Y")).get()
        #today = daily.query(daily.user_id==user_id, daily.date==saleDate).get()
        template_values = {
                'items':today.chapati,
                'itemType':'chapati',
                'date':saleDate,
            }

        template = JINJA_ENVIRONMENT.get_template('SalesView.html')
        self.response.write(template.render(template_values))


    def get(self):
        self.cache('sales')
        #
        JINJA_ENVIRONMENT = jinja2.Environment(
        loader=jinja2.FileSystemLoader('templates'),
        extensions=['jinja2.ext.autoescape'],
        autoescape=True)

        user = users.get_current_user()
        user_id = user.user_id()


        if str(user) in self.known:
            if self.known[str(user)]:
                template = JINJA_ENVIRONMENT.get_template('SalesFetch.html')
                self.response.write(template.render())
            else:
                self.errorpage('You Do Not Have Permission To View This Page')

        else:
            self.errorpage('You Do Not Have Permission To View This Page')

        # template = JINJA_ENVIRONMENT.get_template('SalesFetch.html')
        # self.response.write(template.render())

        # me = stock.query(stock.user_id==user_id).get()
        #
        # template_values = {
        #         'items':me.chapati,
        #     }
        #
        # template = JINJA_ENVIRONMENT.get_template('StockView.html')
        # self.response.write(template.render(template_values))
        #
        # template = JINJA_ENVIRONMENT.get_template('UpdateChapati.html')
        # self.response.write(template.render())
        #
        # today = daily.query(daily.user_id==user_id, daily.date==datetime.now().date()).get()
        #
        # template_values = {
        #         'items':today.chapati,
        #     }
        #
        # template = JINJA_ENVIRONMENT.get_template('StockView.html')
        # self.response.write(template.render(template_values))
