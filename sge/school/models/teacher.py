from odoo import models, fields, api
from datetime import date, datetime
from dateutil.relativedelta import relativedelta





class teacher(models.Model):
    _name = 'school.teacher'
    _description = 'Modelo donde se almacenan los profesores'
    #_rec_name = 'id'

    name = fields.Char()
    subject_id = fields.One2many('school.subject', 'teacher_id')
    deparment = fields.Char()

    #estoy no entyra en practica, en teoria si
    hora1 = fields.Datetime(default=lambda self: fields.Datetime.now()) #hora actual del mundo
    hora2 = fields.Datetime(default = fields.Datetime.now()) #fecha de cuando se inicio el servidor (comando)

   