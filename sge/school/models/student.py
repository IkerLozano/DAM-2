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
        
    _sql_constraint = [

        ('check_age', 'check(age<16)', 'Elalumno es menor de 16 años')
    ]


    #@api.depends('value')
    #def _value_pc(self):
    #    for record in self:
    #        record.value2 = float(record.value) / 100




   