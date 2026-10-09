from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget
)   
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPixmap
from colores import colores# Del archivo color.py, tráeme la clase Color



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
        
        union = QTabWidget()
        union.setTabPosition(QTabWidget.TabPosition.North)
        union.setMovable(True)

        widget1 = QWidget()
        widget2 = QWidget()

        widget1.setLayout(plantillaP1)
        widget2.setLayout(plantillaP2)

        union.addTab((widget1), "Pestaña 1")
        union.addTab((widget2), "Pestaña 2")
        
        
        
        self.setCentralWidget(union)




        






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()