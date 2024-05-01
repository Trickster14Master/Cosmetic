# Generated by Django 4.2 on 2023-04-08 05:15

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0005_order_total_cost'),
    ]

    operations = [
        migrations.AlterModelOptions(
            name='coffee',
            options={'ordering': ['name']},
        ),
        migrations.AlterModelOptions(
            name='dessert',
            options={'ordering': ['name']},
        ),
        migrations.AlterField(
            model_name='order',
            name='userToken',
            field=models.TextField(default=''),
        ),
    ]