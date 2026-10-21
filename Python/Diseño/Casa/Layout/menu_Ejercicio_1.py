from PyQt6.QtWidgets import (
    QApplication, QHBoxLayout, QWidget, QMainWindow, QPushButton, QLabel,
    QRadioButton, QLineEdit, QVBoxLayout, QCheckBox, QComboBox, QListWidget,
    QAbstractItemView, QDial, QSpinBox, QSlider, QCalendarWidget, QGroupBox, 
    QGridLayout, QStackedLayout, QTabWidget, QToolBar, QStatusBar
)   
from PyQt6.QtCore import Qt, QSize
from PyQt6.QtGui import QPixmap, QAction, QIcon
from colores import colores# Del archivo color.py, tráeme la clase Color



class miVentana(QMainWindow):

    

    def __init__(self):
        super().__init__()


        self.setWindowTitle("Ventana")

        self.cont = 0

        #TEXTO
        self.texto = QLabel("Hola")


        #BARRA DE OPCIONES
        barra = QToolBar() #creo la barra
        self.addToolBar(barra) #añado la barra a la ventana


        #METO UN BOTON DENTRO DE LA BARRA
        boton = QAction(QIcon("Layout/icons/cake.png"), "Mi boton", self)
        boton.setStatusTip("Mi boton 1")
        boton.triggered.connect(self.textoCambiado)
        barra.addAction(boton)


        #CREO EL MENU DE OPCIONES DE ARRIBA Y METO UNA OPCION
        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")
        menu_archivo.addAction(boton)


        #COLOCO EL TEXTO
        self.setCentralWidget(self.texto)


    def textoCambiado(self):
        self.cont = self.cont +1
        self.texto.setText(f"Texto cambiado: {self.cont}")
        #con setText le deciomos que cambie el contenido del texto 



        






app = QApplication([])


aplicacion = miVentana()
aplicacion.show()

app.exec()