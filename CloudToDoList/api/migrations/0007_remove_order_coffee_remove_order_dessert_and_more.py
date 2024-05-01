# Generated by Django 4.2 on 2023-04-08 05:27

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0006_alter_coffee_options_alter_dessert_options_and_more'),
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
        migrations.AddField(
            model_name='order',
            name='coffee',
            field=models.ManyToManyField(to='api.coffee'),
        ),
        migrations.AddField(
            model_name='order',
            name='dessert',
            field=models.ManyToManyField(to='api.dessert'),
        ),
        migrations.AddField(
            model_name='order',
            name='topping',
            field=models.ManyToManyField(to='api.topping'),
        ),
    ]