__author__ = 'shreyas'

import webapp2
import jinja2
from google.appengine.api import users
from BaseHandler import BaseHandler
from Stream import Latest

class LatestHandler(webapp2.RequestHandler, BaseHandler):
    def get(self):
        self.cache('latest')

        JINJA_ENVIRONMENT = jinja2.Environment(
        loader=jinja2.FileSystemLoader('templates'),
        extensions=['jinja2.ext.autoescape'],
        autoescape=True)

        user = users.get_current_user()
        user_id = user.user_id()

        # upToDate = False
        # already = Latest.query()
        # for each in already:
        #     mod = each.date_modified
        #     if(mod==datetime.datetime.now().date()):
        #         upToDate=True
        #         break
        #
        # if(not upToDate):
        #     self.response.write("Not the latest")

            # self.sleep()
            # self.working = True
            # if(self.working): self.response.write("Currently refreshing the latest links ... save all songs that you like")
            # self.working = True
            # else:
            #     a = threading.Thread(target=self.sleep())
                # a.start()

            # linkStore = Latest(songs=meta, date_modified=datetime.datetime.now().date())
            # linkStore.put()
            # time.sleep(1)

        # foundSomething = False
        # while(not foundSomething):
        #     ret = Latest.query()
        #     for a in ret:
        #         foundSomething=True

        # temp = False
        #
        # while(temp==False):
        #     ret = Latest.query()
        #     for a in ret:
        #         if (a.get().date_modified != datetime.datetime.now().date()):
        #             self.response.write("SAME DATE FOUND")
        #             break

        ret = Latest.query().order(-Latest.date_modified).get()
        # self.response.write(str(ret.date_modified)
        # af = dict()
        # af = json.loads(ret.sclinks)
        # self.response.write(str(type(ret.sclinks)))
        # self.response.write(ret.songs)

        template_values = {
            'songs':ret.songs,
        }

        template = JINJA_ENVIRONMENT.get_template('ShowPage3.html')
        self.response.write(template.render(template_values))



        # initialized = False
        # while(not initialized):
        #     all = Latest.query()
        #     for store in all:
        #         if (store.finalized == False): self.redirect('/error')


        # def get(self):
        # self.cache('manage')
        #
        # JINJA_ENVIRONMENT = jinja2.Environment(
        # loader=jinja2.FileSystemLoader('templates'),
        # extensions=['jinja2.ext.autoescape'],
        # autoescape=True)
        #
        # user = users.get_current_user()
        # user_id = user.user_id()
        #
        # #Get the list of streams
        # my_streams = Stream.query(Stream.owner_id == user_id)
        # subscribed_streams = Stream.query(Stream.subscribed_users.IN([user_id]))
        # template_values = {
        #     'my_streams':my_streams,
        #     'subscribed_streams':subscribed_streams
        # }
        #
        # template = JINJA_ENVIRONMENT.get_template('ManagementPage.html')
        # self.response.write(template.render(template_values))