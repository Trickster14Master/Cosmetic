# Generated by Django 5.0.3 on 2024-03-16 08:21

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0024_order'),
    ]

    operations = [
        migrations.DeleteModel(
            name='File',
        ),
        migrations.RemoveField(
            model_name='taskforgroup',
            name='Group',
        ),
        migrations.DeleteModel(
            name='Note',
        ),
        migrations.DeleteModel(
            name='Task',
        ),
        migrations.RenameField(
            model_name='order',
            old_name='PendingDeprecationWarningrice',
            new_name='Price',
        ),
        migrations.DeleteModel(
            name='GroupTask',
        ),
        migrations.DeleteModel(
            name='TaskForGroup',
        ),
    ]
