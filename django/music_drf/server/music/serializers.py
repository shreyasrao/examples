from rest_framework import serializers
from music.models import Song, MySong

class SongSerializer(serializers.HyperlinkedModelSerializer):
	class Meta:
		model = Song
		fields = ("id", "title", "artist", "song_url", "img_url")

class MySongSerializer(serializers.HyperlinkedModelSerializer):
        class Meta:
                model = MySong
                fields = ("id", "title", "artist", "song_url", "img_url")
