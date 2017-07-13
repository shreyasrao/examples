from django.db import models
from django.contrib.auth.models import User
from django.utils import timezone
from django.core.validators import MaxValueValidator, MinValueValidator


class Song(models.Model):
    added = models.DateTimeField(auto_now_add=True)
    title = models.CharField(max_length=100)
    artist = models.CharField(max_length=100)
    # url = models.URLField(max_length=500)

    class Meta:
	ordering = ('added',)

class Library(models.Model):
	owner = models.ForeignKey(User, null=True)
	songs = models.ManyToManyField(Song)
