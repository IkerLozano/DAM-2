from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from color import Color # Del archivo color.py, tráeme la clase Color



class miVentana(QMainWindow):

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")


        #PESTAÑA 1   
        texto = QLabel("Hola")
        barra = QLineEdit()

        plantillaP1 = QHBoxLayout()

        plantillaP1.addWidget(texto)
        plantillaP1.addWidget(barra)


        #PESTAÑA 2

        opcion = QCheckBox("Selecion")
        boton = QPushButton("Pulsa")

        plantillaP2 = QVBoxLayout()

        plantillaP2.addWidget(opcion)
        plantillaP2.addWidget(boton)


        #UNION DE LAS PESTAÑAS
        
        pestañas = QTabWidget() #permite organizar diferentes widgets en pestañas
        pestañas.setTabPosition(QTabWidget.TabPosition.North) #donde colocar las pestañas
        pestañas.setMovable(True) #si se pueden mover


        widget1 = QWidget()
        widget2 = QWidget()

        #meto las plantillas con su contenido
        widget1.setLayout(plantillaP1)
        widget2.setLayout(plantillaP2)

        #creo una pestaña para cada plantilla
        pestañas.addTab((widget1), "Pestaña 1")
        pestañas.addTab((widget2), "Pestaña 2")
        
        
        
        self.setCentralWidget(pestañas)




        






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()