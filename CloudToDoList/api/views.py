from rest_framework.decorators import api_view
from rest_framework import viewsets
from rest_framework.response import Response
from rest_framework.permissions import *
from rest_framework.authentication import TokenAuthentication
from api.permissions import IsAdminOrReadOnly
from .serializers import *
from django_filters.rest_framework import DjangoFilterBackend
from rest_framework.filters import SearchFilter

class BrandsAPI(viewsets.ModelViewSet):
    # показываем что доступны все методы для работы с данными (post, get, put, delete запросы)
    queryset= Brands.objects.all()
    # указываем сериализатор
    serializer_class = BrandsSerializer 
    # устанавливаем классы для фильтрации 
    filter_backends = (DjangoFilterBackend, SearchFilter)
    
    def get_paginated_response(self, data):
       return Response(data)

class CosmeticAPI(viewsets.ModelViewSet):
    # показываем что доступны все методы для работы с данными (post, get, put, delete запросы)
    queryset= Cosmetic.objects.all()
    # указываем сериализатор
    serializer_class = CosmeticSerializer 
    
    def get_paginated_response(self, data):
       return Response(data)

class OrderAPI(viewsets.ModelViewSet):
    # показываем что доступны все методы для работы с данными (post, get, put, delete запросы)
    queryset= Order.objects.all()
    # указываем сериализатор
    serializer_class = OrderSerializer 
    # устанавливаем классы для фильтрации 
    filter_backends = (DjangoFilterBackend, SearchFilter)
    # указываем поле по которому проводить фильтрацию 
    search_fields = ['UserToken']
    
    def get_paginated_response(self, data):
       return Response(data)