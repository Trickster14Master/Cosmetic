from django.db import models

def upload_to(instance, filename):
    return 'posts/{filename}'.format(filename=filename)
   
class Brands (models.Model):
    BrandsDescription=models.TextField(null=True)  
    
    def __str__(self):
        return self.BrandsDescription[0:50] 
    
class Cosmetic (models.Model):
    CosmeticName = models.TextField(default="")
    CosmeticDescription = models.TextField(null=True)
    Price = models.IntegerField(null=True)
    UrlsImage = models.ImageField(upload_to=upload_to, default = "")
    IsItNew = models.BooleanField(default="")
    Brands = models.ForeignKey(Brands, on_delete=models.CASCADE)
    
    def __str__(self):
        return self.CosmeticName[0:50]
    
class Order (models.Model):
    UserToken = models.TextField(default="")
    Date= models.DateTimeField(auto_now_add=True)
    Product = models.ManyToManyField(Cosmetic)
    Price = models.IntegerField(null=True)

    class Meta:
        ordering = ['UserToken']

    def __str__(self):
        return self.UserToken[0:50]

    
