from rest_framework import viewsets
from music.models import Song, MySong
from music.serializers import SongSerializer, MySongSerializer

class SongViewSet(viewsets.ModelViewSet):
	queryset = Song.objects.all()
	serializer_class = SongSerializer

class MySongViewSet(viewsets.ModelViewSet):
        queryset = MySong.objects.all()
        serializer_class = MySongSerializer
