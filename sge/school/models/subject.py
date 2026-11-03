from odoo import models, fields, api
from datetime import date, datetime
from dateutil.relativedelta import relativedelta





class subject(models.Model):
    _name = 'school.subject'
    _description = 'Modelo donde se almacenan los alumnos'

    name = fields.Char()
    level = fields.Selection([
        ('1', 'Primero'),
        ('2', 'Segundo')
    ])
    student_ids = fields.Many2many('school.student')
    teacher_id = fields.Many2one('school.teacher')
    deparment_teacher = fields.Char(related='teacher_id.deparment')



   