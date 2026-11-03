from odoo import models, fields, api
from datetime import date, datetime
from dateutil.relativedelta import relativedelta


class student(models.Model):
    _name = 'school.student'
    _description = 'Modelodonde se almacenan los alumnos'

    name = fields.Char()
    surname = fields.Char()
    birthDay = fields.Date()
    gender = fields.Selection([
        ('1', 'Femenino'),
        ('2', 'Masculino')
    ])
    provincia = fields.Char()
    dni = fields.Char()
    subject_id = fields.Many2many('school.subject')
    photo = fields.Image(max_width = 200, max_height = 150)
    anios = fields.Integer(compute='_calcularAnios', help='Campo calculado para la edad')#indico que es un campo calculado


    @api.depends('birthDay')
    def _calcularAnios(self):
       
        for alumno in self:

            alumno.anios = relativedelta(datetime.today(),alumno.birthDay).years
            #record.anios = 20
        
           


    #@api.depends('value')
    #def _value_pc(self):
    #    for record in self:
    #        record.value2 = float(record.value) / 100


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

   