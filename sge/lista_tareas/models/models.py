# -*- coding: utf-8 -*-
from odoo import models, fields, api


#Definimos el modelo de datos
class lista_tareas(models.Model):

    #Nombre y descripcion del modelo de datos
    _name = 'lista_tareas.lista_tareas'
    _description = 'lista_tareas.lista_tareas'
    _rec_name = 'prioridad' #para buscarlo por este nombre
    _order = 'prioridad desc'
    #Elementos de cada fila del modelo de datos
    #Los tipos de datos a usar en el ORM son

    #https://www.odoo.com/documentation/19.0/developer/reference/addons/orm.html#fields
    tarea = fields.Char(required=True)
    prioridad = fields.Selection([(1,'Bajo'),(2,'Medio'),(3,'Alta')])
    urgente = fields.Boolean(compute="_value_urgente", store=True, help='Campo calculado segun la prioridad')
    realizada = fields.Boolean()

    
    #Este computo depende de la variable prioridad
    @api.depends('prioridad')
    #Funcion para calcular el valor de urgente
    def _value_urgente(self):
    #Para cada registro
        for record in self:
        #Si la prioridad es mayor que 10, se considera urgente, en otro caso no lo es
            if int(record.prioridad)>10:
                record.urgente = True
            else:
                record.urgente = False