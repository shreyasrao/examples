from rest_framework import viewsets
from music.models import Song, Library
from music.serializers import SongSerializer, LibrarySerializer, UserSerializer
from django.contrib.auth.models import User

class SongViewSet(viewsets.ModelViewSet):
	queryset = Song.objects.distinct()
	serializer_class = SongSerializer

class LibraryViewSet(viewsets.ModelViewSet):
	queryset = Library.objects.all()
	serializer_class = LibrarySerializer

class UserViewSet(viewsets.ModelViewSet):
	queryset = User.objects.all()
	serializer_class = UserSerializer
