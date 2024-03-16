from django.contrib import admin

from .models import Cosmetic
admin.site.register(Cosmetic)

from .models import Brands
admin.site.register(Brands)

from .models import Order
admin.site.register(Order)
