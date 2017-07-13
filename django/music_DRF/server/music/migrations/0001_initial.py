# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Song',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('added', models.DateTimeField(auto_now_add=True)),
                ('title', models.CharField(max_length=100)),
                ('artist', models.CharField(max_length=100)),
                ('url', models.URLField(max_length=500)),
            ],
            options={
                'ordering': ('added',),
            },
        ),
    ]
