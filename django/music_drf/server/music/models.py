from django.db import models
from django.utils import timezone

class Song(models.Model):
	title = models.CharField(max_length=100)
	artist = models.CharField(max_length=100)
	song_url = models.CharField(max_length=500)
	img_url = models.CharField(max_length=500)	

class MySong(models.Model):
        title = models.CharField(max_length=100)
        artist = models.CharField(max_length=100)
        song_url = models.CharField(max_length=500)
        img_url = models.CharField(max_length=500)

