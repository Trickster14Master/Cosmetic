# Generated by Django 4.2 on 2023-04-10 05:01

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0010_remove_order_product_order_coffee_order_dessert_and_more'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='order',
            name='coffee',
        ),
        migrations.RemoveField(
            model_name='order',
            name='dessert',
        ),
        migrations.RemoveField(
            model_name='order',
            name='topping',
        ),
        migrations.RemoveField(
            model_name='order',
            name='total_cost',
        ),
        migrations.AddField(
            model_name='order',
            name='product',
            field=models.ManyToManyField(to='api.product'),
        ),
    ]