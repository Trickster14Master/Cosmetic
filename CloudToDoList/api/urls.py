from . import views
from django.urls import path, include, re_path 
from rest_framework import routers

routBrands = routers.SimpleRouter()
routBrands.register(r'BrandsAPI', views.BrandsAPI)

routCosmetic = routers.SimpleRouter()
routCosmetic.register(r'CosmeticAPI', views.CosmeticAPI)

routOrder = routers.SimpleRouter()
routOrder.register(r'OrderAPI', views.OrderAPI)

urlpatterns = [
    path("BrandsAPI/", include(routBrands.urls)),
    path("CosmeticAPI/", include(routCosmetic.urls)),
    path("OrderAPI/", include(routOrder.urls)),
]