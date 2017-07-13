from rest_framework import serializers
from music.models import Song, Library
from django.contrib.auth.models import User

class SongSerializer(serializers.ModelSerializer):
	class Meta:
		model = Song
		fields = ("id","title","artist","added")

class LibrarySerializer(serializers.ModelSerializer):
	songs = SongSerializer(many=True)
	#songs = HyperlinkedRelatedField(many=True)
	class Meta:
		model = Library
		fields = ("id","owner","songs")
 
class UserSerializer(serializers.ModelSerializer):
	class Meta:
		model = User
