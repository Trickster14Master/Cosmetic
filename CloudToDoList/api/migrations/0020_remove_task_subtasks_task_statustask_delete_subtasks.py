# Generated by Django 4.2 on 2023-08-24 03:29

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0019_alter_task_subtasks'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='task',
            name='SubTasks',
        ),
        migrations.AddField(
            model_name='task',
            name='StatusTask',
            field=models.BooleanField(default=False),
        ),
        migrations.DeleteModel(
            name='SubTasks',
        ),
    ]