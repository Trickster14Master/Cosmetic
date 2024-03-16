from dataclasses import field
from rest_framework.serializers import ModelSerializer
from rest_framework import serializers
from .models import *


class BrandsSerializer(ModelSerializer):
    class Meta:
        model= Brands
        fields='__all__'
        
class CosmeticSerializer(ModelSerializer):
    brands=BrandsSerializer(read_only=True, many=True)
    class Meta:
        model= Cosmetic
        fields=('CosmeticName','CosmeticDescription','Price','UrlsImage','IsItNew','brands')
        
class OrderSerializer(ModelSerializer):
    product = CosmeticSerializer(read_only=True, many=True)
    class Meta:
        model= Order
        fields=('UserToken','Date','product','Price')

